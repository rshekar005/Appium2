package demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Login extends BaseTest{

    @Test()
    public void loginTest() throws MalformedURLException, InterruptedException {
        BaseTest baseTest=new BaseTest();
        baseTest.launchAndroid();
        androidDriver.findElement(AppiumBy.accessibilityId("open menu")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
        androidDriver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        androidDriver.findElement(AppiumBy.accessibilityId("Login button")).click();
    }
}
