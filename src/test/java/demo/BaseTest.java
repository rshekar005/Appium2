package demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

   static AndroidDriver androidDriver;
    @Test
    public void launchAndroid() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Raja_Test_device");
        options.setApp(System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        androidDriver=new AndroidDriver(
                new URL("http://127.0.0.1:4723"),options);
    }
}
