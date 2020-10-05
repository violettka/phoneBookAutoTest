package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import utils.FunctionalTest;
import static org.junit.Assert.assertEquals;
import static utils.Constants.*;


public class ForgotPasswordPageTests extends FunctionalTest {

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @Before
    public void init(){
        driver.get(forgotPassUrl);
    }

    @Test
    public void testForgotLinkLoginEnable(){
        forgotPasswordPage.loginLinkClick();
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testForgotLinkRegEnable(){
        forgotPasswordPage.regNewAccLinkClick();
        assertEquals(registrationUrl, getUrl());
    }

    @Test
    public void testRetrievePass(){
        forgotPasswordPage.resetPass(userExisted);

        assertEquals("Password recovery instructions have been sent to " + userExisted + ".", forgotPasswordPage.getTextConfStringPassChanged());
        assertEquals(forgotPassUrl, getUrl());

    }

    @Test
    public void testRetrievePassWrongUser(){
        forgotPasswordPage.resetPass(wrongUser);

        assertEquals("Email must be a valid email address.", forgotPasswordPage.getTextErrWrongEmail());
        assertEquals(forgotPassUrl, getUrl());

    }
}
