package tests.basicGUITests.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private By loginBtn = By.xpath("//button[contains(text(),'Login')]");


    public LoginPage() {
    }

    public void loginBtnExists() {
        $(loginBtn).should(exist);
    }

}