package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java8.En;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"json:target/cucumber-report.json", "pretty"},
        tags = "@appium"
)
public class RunCukesTest implements En {
    private AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;
    public RunCukesTest (){

    Before(() -> {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability("systemPort", "8210");
        cap.setCapability(MobileCapabilityType.APP, "src/apps/ApiDemos-debug.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability("appPackage", "io.appium.android.apis");
        cap.setCapability("appActivity", ".ApiDemos");cap.setCapability("noReset", false);
        cap.setCapability("autoGrantPermissions", true);
        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<WebElement>(url, cap);
    });

    After(() -> {
        closeWebDriver();
        service.stop();
    });
}

//    @Override
//    public WebDriver createDriver(DesiredCapabilities cap) {
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////        cap.setCapability("systemPort", "8210");
//        cap.setCapability(MobileCapabilityType.APP, "src/apps/ApiDemos-debug.apk");
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
//        cap.setCapability("appPackage", "io.appium.android.apis");
//        cap.setCapability("appActivity", ".ApiDemos");cap.setCapability("noReset", false);
//        cap.setCapability("autoGrantPermissions", true);
//        URL url = null;
//        try {
//            url = new URL("http://0.0.0.0:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return new AndroidDriver(url, cap);
//    }
}

