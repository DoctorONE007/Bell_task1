package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GooglePageFactory {

    @FindBy(how = How.XPATH, using = "//*[@class='gLFyf gsfi']")
    WebElement searchField;

    @FindBy(how = How.XPATH, using = "//*[@class='gNO89b']")
    WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class='TbwUpd NJjxre']//*[@class='iUh30 Zu0yb qLRx3b tjvcx']")
    List<WebElement> allElements;



    public void find(String keysFind) {
        searchField.click();
        searchField.sendKeys(keysFind);
        searchButton.click();
    }

    public List<WebElement> getAllElements() {
        return allElements;
    }
}
