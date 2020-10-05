package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constants {

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

    public static String forgotPassUrl = "http://dev.phonebook-1.telran-edu.de/user/forgot-password";

//    ------------------  LoginPage  -------------------

    public static String userExisted = "qatest.taran01@gmail.com";
    public static String passwordExisted = "QAtest01";
    public static String wrongUser = System.currentTimeMillis() + ".tarangmail.com";
    public static String shortPass = "1234567";
    public static String longPass = "123456789012345678901";
    public static String loginUrl = "http://dev.phonebook-1.telran-edu.de/user/login";
    public static String contactsUrl = "http://dev.phonebook-1.telran-edu.de/contacts";


//    ----------------  RegistrationPage  -------------------

    public static String newRandomUser = System.currentTimeMillis() + ".taran@gmail.com";
    public static String newRandomPass = "QAtest01";
    public static String registrationUrl = "http://dev.phonebook-1.telran-edu.de/user/registration";
    public static final String confirmRegUrl = "http://dev.phonebook-1.telran-edu.de/user/activate-email";

//  -----------------  APITests  -------------------------

    public static String basicUrl = "http://dev.phonebook-1.telran-edu.de/api/";
    public static String loginAPIUrl = basicUrl + "user/login";
    public static String passChangeAPIUrl = basicUrl + "user/auth-password";
    public static String registrationAPIUrl = basicUrl + "user";
    public static String passForgotAPIUrl = basicUrl + "user/password/recovery";
    public static String passRenewAPIUrl = basicUrl + "user/password";


















}
