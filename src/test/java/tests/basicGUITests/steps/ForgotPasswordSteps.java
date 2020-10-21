package tests.basicGUITests.steps;


import com.github.javafaker.Faker;
import cucumber.api.java8.En;
import tests.basicGUITests.pages.ForgotPasswordPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.basicGUITests.pages.ForgotPasswordPage.errorMsg;
import static tests.basicGUITests.utils.Constants.forgotPassUrl;
import static tests.basicGUITests.utils.Constants.nonExistingUserMessage;

public class ForgotPasswordSteps implements En {
    public ForgotPasswordSteps() {

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        Faker faker = new Faker();

        Given("I am on the 'Forgot Password' page", () -> {
           open(forgotPassUrl);
        });

        When("I click on the Login link", () -> {
            forgotPasswordPage.loginLinkClick();
        });

        When("I reset non-existing user password", () -> {
            forgotPasswordPage.resetPass(faker.internet().emailAddress());
        });

        Then("I see validation message", () -> {
            $(errorMsg).shouldHave(text(nonExistingUserMessage));
        });

    }
}
