package tests.basicGUITests.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationConfirmationPage {
    public RegistrationConfirmationPage(){}

    private By message = By.tagName("h4");

    public void assertMessage(String msg){
        $(message).shouldHave(text(msg));
    }
}
