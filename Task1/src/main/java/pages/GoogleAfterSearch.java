package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleAfterSearch {

    protected WebDriver chromeDriver;

    public GoogleAfterSearch(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public List<WebElement> getResults() {
        return chromeDriver.findElements(By.xpath("//*[@class='TbwUpd NJjxre']"));
    }
}
