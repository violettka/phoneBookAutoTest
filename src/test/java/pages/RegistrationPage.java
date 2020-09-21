package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class RegistrationPage extends PageObject {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
    private WebElement loginCreateField;
    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[2]/input")
    private WebElement setPassword;
    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[3]/input")
    private WebElement confirmPassword;
    @FindBy(xpath = "/html/body/app-root/app-registration/form/button")
    private WebElement signUpBtn;

    public RegistrationConfirmationPage register(String user, String password, String confPassword){

        loginCreateField.sendKeys(user);
        setPassword.sendKeys(password);
        confirmPassword.sendKeys(confPassword);
        signUpBtn.click();
        return new RegistrationConfirmationPage(driver);
    }
}
