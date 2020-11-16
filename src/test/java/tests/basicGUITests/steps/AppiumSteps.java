package tests.basicGUITests.steps;


import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tests.RunCukesTest;

import java.util.List;

public class AppiumSteps extends RunCukesTest implements En {
    public AppiumSteps() {


        When("I click on Content tab on the first screen", () -> {
            List<WebElement> searchParametersElement = (List<WebElement>) driver.findElementsByAccessibilityId("Content");
            searchParametersElement.get(0).click();
        });

        Then("I should see Assets tab", () -> {
            List<WebElement> assets = (List<WebElement>) driver.findElementsByAccessibilityId("Assets");
            Assert.assertEquals(assets.size(), 1);
        });

    }
}
