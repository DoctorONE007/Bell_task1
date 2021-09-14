package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Opensite {
    protected WebDriver chromeDriver;
    private final List<WebElement> results;


    public Opensite(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        results = chromeDriver.findElements(By.xpath("//*[@class='main-page-info__block']//*[@class='main-page-exchange__rate']"));
    }

    public List<WebElement> getResults() {
        return results;
    }

    public double[] parseDouble() {
        double[] res = new double[4];
        try {
            for (int i = 0; i < res.length; i++) {
                res[i] = Double.parseDouble(getResults().get(i).getText().replace(',', '.'));
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return res;
    }
}
