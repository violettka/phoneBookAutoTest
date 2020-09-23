package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import utils.FunctionalTest;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BasicGUITest extends FunctionalTest {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    private String user = System.currentTimeMillis() + ".taran@gmail.com";
    private String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    private String userExisted = "qatest.taran01@gmail.com";
    private String passwordExisted = "QAtest01";
    private String shortPass = "1234567";
    private String longPass = "123456789012345678901";
    private String password = "qatest01";
    private String mainURL = "http://localhost:4200/";
    private String loginUrl = "http://localhost:4200/user/login";
    private String signUpUrl = "http://localhost:4200/user/registration";
    private String confPassword = password;
    private String confPasswordExisted = passwordExisted;
    private String forgotPassUrl = "http://localhost:4200/user/forgot-password";


//    @Before
//    public void init() {
//        driver.get(baseURL);
//        mainPage = loginPage.login(user, password);
//
//    }

//    @Test
//    public void testCreateUser(){
//
//        driver.get(signUpUrl);
//        WebElement loginCreateField = driver.findElement(By.xpath("//*[@id=\"defaultRegisterFormEmail\"]"));
//        loginCreateField.sendKeys(user);
//        WebElement setPassword = driver.findElement(By.xpath("/html/body/app-root/app-registration/form/div[2]/input"));
//        setPassword.sendKeys(password);
//        WebElement confirmPassword = driver.findElement(By.xpath("/html/body/app-root/app-registration/form/div[3]/input"));
//        confirmPassword.sendKeys(password);
//        WebElement signUpBtn = driver.findElement(By.xpath("/html/body/app-root/app-registration/form/button"));
//        signUpBtn.click();
//
//        WebElement confString = driver.findElement(By.xpath("/html/body/app-root/app-activate-email/main/section/div/h4"));
//
//        assertTrue(confString.getText().equals("Please, check your email and activate your account."));
//        assertEquals("http://localhost:4200/user/activate-email", driver.getCurrentUrl());
//        logger.info("Valid login test passed");
//    }


    //       REGISTRATION PAGE
    @Test
    public void testCreateUser() {
        driver.get(signUpUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationConfirmationPage confirmationPage = registrationPage.register(user, password, confPassword);
        assertEquals("Please, check your email and activate your account.", confirmationPage.getConfirmationPageText());
        assertEquals("http://localhost:4200/user/activate-email", driver.getCurrentUrl());
        logger.info("Valid login test passed");
    }

    @Test
    public void testCreateWrongUser() {
        driver.get(signUpUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);  //актуально при наличии id для полей ввода
        RegistrationConfirmationPage confirmationPage = registrationPage.register(wrongUser, password, confPassword);
        assertEquals("Email must be a valid email address.", driver.findElement(By.id("WrongEmailFormat")).getText());

    }

    @Test
    public void testCreateTooShortPass(){
        driver.get(signUpUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationConfirmationPage confirmationPage = registrationPage.register(user, shortPass, confPassword);

        assertEquals("Password must be at least 8 characters long.", driver.findElement(By.id("PasswordMinLength")).getText());
    }

    @Test
    public void testCreateTooLongPass(){
        driver.get(signUpUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationConfirmationPage confirmationPage = registrationPage.register(user, longPass, confPassword);

        assertEquals("Password must be no longer than 20 characters.", driver.findElement(By.id("PasswordMaxLength")).getText());
    }

    @Test
    public void testCreatePassNotMatch(){
        driver.get(signUpUrl);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationConfirmationPage confirmationPage = registrationPage.register(user, password, confPassword + "1");

        assertEquals("Passwords do not match.", driver.findElement(By.id("PasswordNotMatch")).getText());
    }

    //         LOGIN PAGE

    @Test
    public void testLoginTooShortPass(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, shortPass);

        assertEquals("Password must be at least 8 characters.", driver.findElement(By.id("PasswordMinLength")).getText());

    }

    @Test //!!!!!!!!!!!!!!!!!!!! must be reported cause of no id and error text
    public void testLoginTooLongPass(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, longPass);

        assertTrue(driver.findElement(By.xpath("/html/body/app-root/app-login/form/div[3]")).isEnabled());

    }


    @Test
    public void testLoginEmptyLogin(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", passwordExisted);

        assertEquals("Email is required.", driver.findElement(By.id("EmailIsEmpty")).getText());

    }

    @Test
    public void testLoginEmptyPass(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, "");

        assertFalse(driver.findElement(By.id("btnLogin")).isEnabled());

    }


    @Test
    public void testLoginConfirmedUser(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted);

        assertEquals("Logout",driver.findElement(By.xpath("/html/body/app-root/app-user-page/app-header/nav/a[2]")).getText());
        assertEquals(mainURL, driver.getCurrentUrl());
    }

    @Test
    public void testLogout(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted);
        loginPage.logout();

        assertEquals(loginUrl, driver.getCurrentUrl());
        assertEquals("Sign in", driver.findElement(By.xpath("/html/body/app-root/app-login/form/p")).getText());
    }

    @Test // test failed cause of actual result ("Unauthorized" didn't recognized or has no text)
    public void testIncorrectPassword(){
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted + "1");

        assertEquals("Unauthorized", driver.findElement(By.xpath("/html/body/app-root/app-login/form/div[3]")).getText());
        assertEquals(loginUrl, driver.getCurrentUrl());
    }

    //      FORGOT PASS PAGE

    @Test
    public void testRetrievePass(){
        driver.get(loginUrl);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPass(userExisted);

        assertEquals("Forgot Password", driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/form/p")).getText());
        assertEquals("Please check your email and reset your password", driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/form/section/div/h4")).getText());
        assertEquals(forgotPassUrl, driver.getCurrentUrl());

    }

    @Test

    public void testRetrievePassWrongUser(){
        driver.get(loginUrl);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.resetPass(user);

        assertEquals("Forgot Password", driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/form/p")).getText());
        assertEquals(forgotPassUrl, driver.getCurrentUrl());

    }


}