package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    @Test
    public void test_2() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

//        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
//        desiredCapabilities.setCapability("platformName","Android");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emre");//AndroidEmulator
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\IT PROJE\\APPIUM\\AppiumHazirlik\\src\\APPS\\Calculator.apk");

        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);



        WebElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        WebElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        WebElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        WebElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        WebElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        WebElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        WebElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        WebElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        WebElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        WebElement plus = driver.findElementById("com.google.android.calculator:id/op_add");//Arti
        WebElement minus = driver.findElementById("com.google.android.calculator:id/op_sub");//eksi
        WebElement point = driver.findElementById("com.google.android.calculator:id/dec_point");//nokta,virgul
        WebElement mul = driver.findElementById("com.google.android.calculator:id/op_mul");//bolme
        WebElement div = driver.findElementById("com.google.android.calculator:id/op_div");//carpma
        WebElement del = driver.findElementById("com.google.android.calculator:id/del");//silme
        WebElement equal = driver.findElementById("com.google.android.calculator:id/eq");//esittir

        //   35+24 = 59

        num3.click();//3
        num5.click();//5
        plus.click();//+
        num2.click();//2
        num4.click();//4
        Thread.sleep(2000);

        WebElement preResult=driver.findElementById("com.google.android.calculator:id/result_preview");
        String ilkSonuc="59";

        equal.click();
        Thread.sleep(2000);

        WebElement sonSonuc=driver.findElementById("com.google.android.calculator:id/result_final");
        Thread.sleep(5000);

        Assert.assertEquals(ilkSonuc,sonSonuc.getText());

       driver.close();


    }
    //com.google.android.calculator/com.android.calculator2.Calculator
}