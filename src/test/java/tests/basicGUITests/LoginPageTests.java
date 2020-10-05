package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import utils.FunctionalTest;
import static org.junit.Assert.*;
import static utils.Constants.*;


//   9
public class LoginPageTests extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void init() {
        driver.get(loginUrl);
    }

    @Test
    public void testLoginLinkRegEnable(){
        loginPage.regNewAccLinkClick();
        assertEquals(registrationUrl, getUrl());

    }

    @Test
    public void testLoginLinkForgotEnable(){
        loginPage.forgotPassLinkClick();
        assertEquals(forgotPassUrl, getUrl());
    }

    @Test
    public void testLoginConfirmedUser(){
        loginPage.login(userExisted, passwordExisted);

        assertEquals("Logout", loginPage.getTextLogout());
        assertEquals(contactsUrl, getUrl());
    }

    @Test
    public void testLoginConfirmedUserUpCase(){
        loginPage.login("QATEST.TARAN01@gmail.com", passwordExisted);

        assertEquals("Logout", loginPage.getTextLogout());
        assertEquals(contactsUrl, getUrl());
    }

    @Test
    public void testLoginLogout(){
        loginPage.login(userExisted, passwordExisted);
        loginPage.logout();

        assertEquals(loginUrl, getUrl());
        assertEquals(false, loginPage.loginBtnIsEnabled());
    }


    @Test
    public void testLoginTooShortPass(){
        loginPage.login(userExisted, shortPass);

        assertEquals("Password must be at least 8 characters.", loginPage.getErrTextShortPass());
        assertEquals(false, loginPage.loginBtnIsEnabled());
    }

    @Test
    public void testLoginTooLongPass(){
        loginPage.login(userExisted, longPass);

        assertEquals("Password must be no longer than 20 characters.", loginPage.getErrTextLongPass());
        assertEquals(false, loginPage.loginBtnIsEnabled());
    }


    @Test
    public void testLoginEmptyLogin(){
        loginPage.login("", passwordExisted);

        assertEquals("Email is required.", loginPage.getErrTextEmailIsEmpty());
        assertEquals(false, loginPage.loginBtnIsEnabled());

    }

    @Test
    public void testLoginEmptyPass(){
        loginPage.login(userExisted, "");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[1]/div/div/h2")).click();

        assertEquals("Password is required.", loginPage.getErrTextPassIsEmpty());
        assertEquals(false, loginPage.loginBtnIsEnabled());

    }

    @Test
    public void testLoginIncorrectUser(){
        loginPage.login(userExisted + "1", passwordExisted);

        assertEquals("Email must be a valid email address.", loginPage.getErrTextEmailInvalid());
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testLoginWrongUserNoAt(){
        loginPage.login( "qatest.taran01gmail.com", passwordExisted);

        assertEquals("Email must be a valid email address.", loginPage.getErrTextEmailInvalid());
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testLoginWrongUserNoPoint(){
        loginPage.login( "qatest.taran01@gmailcom", passwordExisted);

        assertEquals("Email must be a valid email address.", loginPage.getErrTextEmailInvalid());
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testLoginWrongUserAsString(){
        loginPage.login( "qatesttaran01gmailcom", passwordExisted);

        assertEquals("Email must be a valid email address.", loginPage.getErrTextEmailInvalid());
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testLoginWrongUserBadDom(){
        loginPage.login( "qatest.taran01@gmail.c", passwordExisted);

        assertEquals("Email must be a valid email address.", loginPage.getErrTextEmailInvalid());
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testLoginIncorrectPassword(){
        loginPage.login(userExisted, passwordExisted + "1");

        assertEquals("Please check your activation or Login + Password combination", loginPage.getErrTextNotExist());
        assertEquals(loginUrl, getUrl());
    }
}
