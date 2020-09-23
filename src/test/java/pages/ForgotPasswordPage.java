package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import utils.PageObject;

public class ForgotPasswordPage extends PageObject {
    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement loginField;
    @FindBy(xpath = "/html/body/app-root/app-login/form/div[4]/a")
    private WebElement forgotPassLink;
    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/button")
    private WebElement resetPassBtn;
    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/section/div/h4")
    private WebElement confirmString;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPasswordPage resetPass(String user){
        forgotPassLink.click();
        loginField.sendKeys(user);
        resetPassBtn.click();

        return new ForgotPasswordPage(driver);
    }
}

