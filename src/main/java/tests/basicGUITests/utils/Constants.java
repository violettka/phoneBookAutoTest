package tests.basicGUITests.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constants {

//    ------------  Commons  ---------------
    public static String baseUrl = "http://dev.phonebook-1.telran-edu.de";

//    ------------  EmailPage  ---------------
    @FindBy(id = "identifierId")
    public static WebElement loginFieldGmail;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[2]")
    public static WebElement nextBtn;
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    public static WebElement passwordFieldGmail;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[2]")
    public static WebElement nextBtn2;
    @FindBy(css = "#\\:2k > span > span")
    public static WebElement confTokenLetter;
    @FindBy(css = "#\\:5y > a")
    public static WebElement tokenLink;
    public static String emailUrl = "https://mail.google.com/mail";

//    ------------------- ForgotPasswordPage --------------------------

    public static String forgotPassUrl = baseUrl + "/user/forgot-password";
    public static String nonExistingUserMessage = "Error! This user doesn't exist in our DB";


//    ------------------  LoginPage  -------------------

    public static String userExisted = "qatest.taran01@gmail.com";
    public static String passwordExisted = "QAtest01";
    public static String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    public static String shortPass = "1234567";
    public static String longPass = "123456789012345678901";
    public static String loginUrl = baseUrl + "/user/login";
    public static String contactsUrl = baseUrl + "/contacts";


//    ----------------  RegistrationPage  -------------------

    public static String newRandomUser = System.currentTimeMillis() + ".taran@gmail.com";
    public static String newRandomPass = "QAtest01";
    public static String registrationUrl = baseUrl + "/user/registration";
    public static final String confirmRegUrl = baseUrl + "/user/activate-email";

//  -----------------  APITests  -------------------------

    public static String loginAPIUrl = baseUrl + "/api/user/login";
    public static String passChangeAPIUrl = baseUrl + "/api/user/auth-password";
    public static String registrationAPIUrl = baseUrl + "/api/user";
    public static String passForgotAPIUrl = baseUrl + "/api/user/password/recovery";
    public static String passRenewAPIUrl = baseUrl + "/api/user/password";
















}
