package tests.basicGUITests.steps;

import com.github.javafaker.Faker;
import cucumber.api.java8.En;
import tests.basicGUITests.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.basicGUITests.utils.Constants.registrationUrl;

public class RegistrationSteps implements En {
    public RegistrationSteps() {

        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();

        Given("I am on the Registration page", () -> {
            open(registrationUrl);
        });

        When("I create a user with the valid data", () -> {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 20);
            registrationPage.insertUserData(email, password, password);
        });

        When("I click SignUp button", registrationPage::clickSignUpBtn);
    }
}
