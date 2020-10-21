package tests.basicGUITests.steps;


import cucumber.api.java8.En;
import gherkin.formatter.model.DocString;
import tests.basicGUITests.pages.RegistrationConfirmationPage;


public class RegistrationConfirmationSteps implements En {
    public RegistrationConfirmationSteps() {

        RegistrationConfirmationPage regConfirm = new RegistrationConfirmationPage();

    Then("I see a confirmation message:", (DocString message) -> {
        String msg = message.getValue();
        regConfirm.assertMessage(msg);
    });
}}
