package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class LoginPage extends PageObject {
    @FindBy(id = "")
    private WebElement login;
    @FindBy(id = "")
    private WebElement password;
    @FindBy(xpath = "/html/body/app-root/app-registration/form/a")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String user, String pass) {
        login.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        return new MainPage(driver);
    }

}