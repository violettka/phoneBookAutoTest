package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.RegistrationConfirmationPage;
import pages.RegistrationPage;
import utils.FunctionalTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static utils.Constants.*;


public class RegistrationPageTests extends FunctionalTest {


    private String confPassword = newRandomPass;
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Before
    public void init(){
        driver.get(registrationUrl);
    }

//  11
    @Test
    public void testCreateUser() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register(newRandomUser, newRandomPass, confPassword);

        assertEquals("Please, check your email and activate your account.", confirmationPage.getConfirmationText());
        assertEquals(confirmRegUrl, getUrl());
        logger.info("Valid login registration test passed");
    }

    @Test
    public void testCreateExistedUser() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register(userExisted, passwordExisted, passwordExisted);

        assertEquals("Error! User already exists Login now?", registrationPage.getErrAlreadyExists());
        assertEquals(registrationUrl, getUrl());

    }

    @Test
    public void testCreateWrongUserNoAt() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register(wrongUser, newRandomPass, confPassword);

        assertEquals("Email must be a valid email address.", registrationPage.getErrTextEmail());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
        logger.info("Invalid login registration test passed");
    }

    @Test
    public void testCreateWrongUserAsString() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register("wrongUser", newRandomPass, confPassword);

        assertEquals("Email must be a valid email address.", registrationPage.getErrTextEmail());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
        logger.info("Invalid login registration test passed");
    }

    @Test
    public void testCreateWrongUserNoPoint() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register("wrongUser@wrongUser", newRandomPass, confPassword);

        assertEquals("Email must be a valid email address.", registrationPage.getErrTextEmail());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
        logger.info("Invalid login registration test passed");
    }

    @Test
    public void testCreateWrongUserBadDom() {
        RegistrationConfirmationPage confirmationPage = registrationPage.register("wrongUser@wrongUser.w", newRandomPass, confPassword);

        assertEquals("Email must be a valid email address.", registrationPage.getErrTextEmail());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
        logger.info("Invalid login registration test passed");
    }

    @Test
    public void testCreateTooShortPass(){
        RegistrationConfirmationPage confirmationPage = registrationPage.register(newRandomUser, shortPass, confPassword);

        assertEquals("Password must be at least 8 characters.", registrationPage.getErrTextShortPass());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
    }

    @Test
    public void testCreateTooLongPass(){
        RegistrationConfirmationPage confirmationPage = registrationPage.register(newRandomUser, longPass, confPassword);

        assertEquals("Password must be no longer than 20 characters.", registrationPage.getErrTextLongPass());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
    }

    @Test
    public void testCreatePassNotMatch(){
        RegistrationConfirmationPage confirmationPage = registrationPage.register(newRandomUser, newRandomPass, confPassword + "1");

        assertEquals("Passwords does not match", registrationPage.getErrTextPassNotMatch());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());
    }

    @Test
    public void testEmailIsEmpty(){
        RegistrationConfirmationPage confirmationPage = registrationPage.register("", newRandomPass, confPassword);

        assertEquals("Email is required.", registrationPage.getErrTextEmailIsEmpty());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());

    }

    @Test
    public void testPassIsEmpty(){
        RegistrationConfirmationPage confirmationPage = registrationPage.register(newRandomUser, "", confPassword);

        assertEquals("Password is required.", registrationPage.getErrTextPassIsEmpty());
        assertEquals(false, registrationPage.signUpBtnIsEnabled());

    }


}
