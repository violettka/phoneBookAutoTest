package tests.basicGUITests.steps;

import io.cucumber.docstring.DocString;
import io.cucumber.java8.En;
import tests.basicGUITests.pages.RegistrationConfirmationPage;


public class RegistrationConfirmationSteps implements En {
    public RegistrationConfirmationSteps() {

        RegistrationConfirmationPage regConfirm = new RegistrationConfirmationPage();

    Then("I see a confirmation message:", (DocString message) -> {
        String msg = message.getContent();
        regConfirm.assertMessage(msg);
    });
}}
