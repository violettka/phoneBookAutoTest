package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class LoginPage extends PageObject {
    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement loginField;
    @FindBy(id = "defaultRegisterFormPass")
    private WebElement passwordField;
    @FindBy(id = "btnLogin")
    WebElement loginButton;
    @FindBy(xpath = "/html/body/app-root/app-user-page/app-header/nav/a[2]")
    private WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String user, String password) {
        loginField.sendKeys(user);
        this.passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage(driver);
    }

}