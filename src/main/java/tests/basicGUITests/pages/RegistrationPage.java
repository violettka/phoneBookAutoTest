package tests.basicGUITests.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {


    public  RegistrationPage(){}

    //locators

    private By username = By.name("email");
    private By password = By.name("password");
    private By pwdConfirm = By.name("confirm-password");
    private By signUpBtn = By.xpath("//button[contains(text(),'Sign up')]");

    public void insertUserData(String username, String password, String confirmPwd){
        $(this.username).setValue(username);
        $(this.password).setValue(password);
        $(pwdConfirm).setValue(confirmPwd);
    }

    public RegistrationConfirmationPage clickSignUpBtn(){
        $(signUpBtn).click();
        return new RegistrationConfirmationPage();
    }

}
