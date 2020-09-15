package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    private static final String ERROR_START = "\n\nElement not found in: ";
    private static final String ERROR_MIDDLE = " within: ";
    private static final String ERROR_END = " seconds!\n\n";
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForElementIsDispalyed(int seconds, WebElement element) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, seconds)
                .ignoring(StaleElementReferenceException.class);
        wait.withMessage(ERROR_START + element + ERROR_MIDDLE + seconds + ERROR_END);
        wait.until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() == true);
    }
}
