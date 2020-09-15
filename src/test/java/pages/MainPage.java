package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "")
    private WebElement menuBtn;

    @FindBy(xpath = "")
    private WebElement settingsBtn;


    private void clickCreatePage() {
        menuBtn.click();
        driver.findElement(By.xpath("")).click();
    }


}