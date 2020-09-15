package test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BasicAPITest extends FunctionalTest {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    String user = "cepera_hawk@ukr.net";
    String password = "";
    String baseURL = "http://localhost:4200/";


    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);

    }










}