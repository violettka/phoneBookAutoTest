package tests.basicGUITests.steps;

import cucumber.api.java8.En;
import tests.basicGUITests.pages.LoginPage;

public class LoginPageSteps implements En {
    public LoginPageSteps() {

        LoginPage loginPage = new LoginPage();

        Then("I see Login button", () -> {
            loginPage.loginBtnExists();
        });

    }
}
