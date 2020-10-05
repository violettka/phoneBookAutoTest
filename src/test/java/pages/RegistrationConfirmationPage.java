package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;


public class RegistrationConfirmationPage extends PageObject {

    @FindBy(xpath = "/html/body/app-root/app-activate-email/main/section/div/h4")
    private WebElement checkYourEmailMsg;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationText() {
        return checkYourEmailMsg.getText();
    }
}
