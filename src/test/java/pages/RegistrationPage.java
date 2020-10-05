package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;


public class RegistrationPage extends PageObject {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[4]/div[1]/button")
    private WebElement signUpBtn;
    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[1]/div[1]/div/input")
    private WebElement enterEmailField;
    @FindBy (xpath = "//*[@id=\"registration-form\"]/div[2]/div[1]/div/input")
    private WebElement newPasswordField;
    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[3]/div[1]/div/input")
    private WebElement confirmPassword;
    @FindBy(id = "email-error-invalid")
    private WebElement emailErrMsg;
    @FindBy(id = "password-error-minlength")
    private WebElement passShortErrMsg;
    @FindBy(id = "password-error-maxlength")
    private WebElement passLongErrMsg;
    @FindBy(id = "confirm-password-error-matcher")
    private WebElement passNotMatchErrMsg;
    @FindBy(id = "email-error-required")
    private WebElement emailIsEmptyErrMsg;
    @FindBy(id = "error-message")
    private WebElement alreadyExistsErrMsg;
    @FindBy(id = "password-error-required")
    private WebElement passIsEmptyErrMsg;


    public String getErrTextEmail() {
        return emailErrMsg.getText();
    }

    public String getErrTextShortPass() {
        return passShortErrMsg.getText();
    }

    public String getErrTextLongPass() {
        return passLongErrMsg.getText();
    }

    public String getErrTextPassNotMatch() {
        return passNotMatchErrMsg.getText();
    }

    public String getErrTextEmailIsEmpty() {
        return emailIsEmptyErrMsg.getText();
    }

    public String getErrTextPassIsEmpty() {
        return passIsEmptyErrMsg.getText();
    }

    public boolean signUpBtnIsEnabled(){
        return signUpBtn.isEnabled();

    }

    public String getErrAlreadyExists(){
        return alreadyExistsErrMsg.getText();

    }


    public RegistrationConfirmationPage register(String user, String password, String confPassword){

        enterEmailField.sendKeys(user);
        newPasswordField.sendKeys(password);
        confirmPassword.sendKeys(confPassword);
        signUpBtn.click();
        return new RegistrationConfirmationPage(driver);
    }
}
