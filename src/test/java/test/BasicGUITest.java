package test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationConfirmationPage;
import pages.RegistrationPage;
import utils.FunctionalTest;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BasicGUITest extends FunctionalTest {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    private String user = System.currentTimeMillis() + ".taran@gmail.com";
    private String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    String password = "qatest01";
    String baseURL = "http://localhost:4200/";
    String signUpUrl = "http://localhost:4200/user/registration";
    private String confPassword = password;


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
        RegistrationPage registrationPage = new RegistrationPage(driver);
        WebElement loginCreateField = driver.findElement(By.xpath("//*[@id=\"defaultRegisterFormEmail\"]"));
        loginCreateField.sendKeys(wrongUser);
//        RegistrationConfirmationPage confirmationPage = registrationPage.register(wrongUser, password, confPassword);
        assertEquals("Email must be a valid email address.", driver.findElement(By.xpath("/html/body/app-root/app-registration/form/div[2]/div")).getText());

    }


}