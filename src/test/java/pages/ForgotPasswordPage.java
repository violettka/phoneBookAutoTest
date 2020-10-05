package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import utils.PageObject;

public class ForgotPasswordPage extends PageObject {


    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"success-message\"]/h6")
    public static WebElement confirmCheckEmailText;
    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"forgot-pass-form\"]/div[2]/div[1]/button")
    private WebElement sendBtn;
    @FindBy(id = "success-message")
    public static WebElement confirmStringPassChanged;
    @FindBy(id = "email-error-invalid")
    public static WebElement emailErrMsg;
    @FindBy(xpath = "/html/body/app-root/app-forgot-password/div/div[1]/div/a[1]")
    public static WebElement loginLink;
    @FindBy(xpath = "/html/body/app-root/app-forgot-password/div/div[1]/div/a[2]")
    private WebElement regNewAccLink;


    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[2]/div[1]/div/input")
    public static WebElement setNewPassword;
    @FindBy(xpath = "//*[@id=\"registration-form\"]/div[3]/div[1]/div/input")
    public static WebElement confirmNewPassword;
    @FindBy(xpath = "//*[@id=\"password-recovery-form\"]/div[3]/div[1]/button")
    public static WebElement resetPassSubmitBtn;

    public String getTextConfStringPassChanged() {
        return confirmStringPassChanged.getText();
    }

    public String getTextErrWrongEmail() {
        return emailErrMsg.getText();
    }


    public ForgotPasswordPage resetPass(String user){
        loginField.sendKeys(user);
        sendBtn.click();

        return new ForgotPasswordPage(driver);
    }

    public void loginLinkClick(){
        loginLink.click();
    }

    public void regNewAccLinkClick(){
        regNewAccLink.click();
    }
}

