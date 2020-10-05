package pages;

import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.PageObject;

import static utils.Constants.*;

public class EmailPage extends PageObject {


    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public String getRegToken(String user, String password) {
        driver.get(emailUrl);
        Constants.loginFieldGmail.sendKeys(user);
        nextBtn.click();
        passwordFieldGmail.sendKeys(password);
        nextBtn2.click();
        confTokenLetter.click();
        String regToken = tokenLink.getText().split("n/", 2)[1];
        System.out.println(regToken);

        return tokenLink.getText();
    }


}
