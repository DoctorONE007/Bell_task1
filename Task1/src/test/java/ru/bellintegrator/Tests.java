package ru.bellintegrator;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleAfterSearch;
import pages.GoogleBeforeSearch;
import pages.GooglePageFactory;
import pages.Opensite;


public class Tests extends BaseTests {

    @Feature("Проверка результатов поиска")
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"Гладиолус,https://ru.wikipedia.org"})
    public void firstPO(String keyWords, String result) {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find(keyWords);
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains(result)),
                "Статьи " + keyWords + " содержащие " + result + " не найдены");
    }

    @Feature("Проверка результатов поиска")
    @Test
    public void secondPF() {
        chromeDriver.get("https://www.google.com/");
        GooglePageFactory googlePageFactory = PageFactory.initElements(chromeDriver, GooglePageFactory.class);
        googlePageFactory.find("Гладиолус");
        Assertions.assertTrue(googlePageFactory.getAllElements().stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")),
                "При поиске Гладиолус страницы https://ru.wikipedia.org не найдены");
    }

    @Feature("Проверка курса покупки/продажи валюты")
    @Test
    public void thirdMoney() {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find("Открытие");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains("https://www.open.ru")),
                "При поиске Открытие страницы https://www.open.ru не найдены");

        chromeDriver.get("https://www.open.ru");
        Opensite opensite = new Opensite(chromeDriver);
        double[] res = opensite.parseDouble();

        Assertions.assertTrue(res[0] < res[1], "Продажа USD не больше покупки");
        Assertions.assertTrue(res[2] < res[3], "Продажа EUR не больше покупки");


    }

}
