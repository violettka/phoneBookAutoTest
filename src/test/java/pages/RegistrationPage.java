package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class RegistrationPage extends PageObject {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement loginField;
    @FindBy(id = "defaultRegisterFormPass")
    private WebElement setPassword;
    @FindBy(id = "defaultRegisterFormConfPass")
    private WebElement confirmPassword;
    @FindBy(id = "btnSignup")
    private WebElement signUpBtn;

    public RegistrationConfirmationPage register(String user, String password, String confPassword){

        loginField.sendKeys(user);
        setPassword.sendKeys(password);
        confirmPassword.sendKeys(confPassword);
        signUpBtn.click();
        return new RegistrationConfirmationPage(driver);
    }
}
