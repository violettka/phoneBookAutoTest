package tests.basicGUITests.pages;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    public ForgotPasswordPage() { }

    //web elements

    private By loginLink = By.linkText("Already have an account?");
    private By emailInput = By.id("defaultRegisterFormEmail");
    private By sendBtn = By.xpath("//button[contains(text(),'Send')]");
    public static By errorMsg = By.id("error-message");

    public ForgotPasswordPage resetPass(String email){
        $(emailInput).setValue(email);
        $(sendBtn).click();
        return this;
    }

    public void loginLinkClick(){
        $(loginLink).click();
    }
}

