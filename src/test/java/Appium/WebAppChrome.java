package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Set;

public class WebAppChrome {
    @Test
    public void test_1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        //Driver'i yukluyoruz,Telefondaki Driver hangisi ile onu yukluyoruz
        desiredCapabilities.setCapability("chromedriverExecutable","C:\\IT PROJE\\APPIUM\\AppiumHazirlik\\.idea\\driver\\chromedriver.exe");



        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        driver.get("https://amazon.com");

        //Hangi turde ygulama kullandigimizi ogrenecegiz

        Set context=driver.getContextHandles();
        System.out.println(context);

        for(Object contextName : context){
            System.out.println(contextName);
            Thread.sleep(5000);
            //Native_App
            if(contextName.toString().contains("CHROMIUM")){
                driver.context((String)contextName);
            }
        }
        System.out.println("uygulama her iki durumda da kullanilabilir");
        System.out.println("son drum :"+driver.getContext());


        driver.findElementByXPath("//*[@name='k']").sendKeys("glasses");
        Thread.sleep(3000);
        driver.findElementByXPath("//*[@class='nav-input']").click();



    }
}