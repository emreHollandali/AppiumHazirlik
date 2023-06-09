package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Arama {
    @Test
    public void test_2() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emre");//AndroidEmulator
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //   desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\IT PROJE\\APPIUM\\AppiumHazirlik\\src\\APPS\\Calculator.apk");

        desiredCapabilities.setCapability("appPackage", "com.android.dialer");
        desiredCapabilities.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);
        /*
        arama ac
        tuslara ulasalim
        1122 ara
        sonra aramayi sonlandir
         */
        Thread.sleep(3000);
        driver.findElementById("com.android.dialer:id/fab").click();
        Thread.sleep(3000);

        WebElement num1 = driver.findElementById("com.android.dialer:id/one");
        WebElement num2 = driver.findElementById("com.android.dialer:id/two");

        num1.click();
        num1.click();
        num2.click();
        num2.click();
        Thread.sleep(2000);

        driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();

        Thread.sleep(5000);


        driver.findElementById("com.android.dialer:id/incall_end_call").click();


        //app kapat
        driver.quit();

    }
}