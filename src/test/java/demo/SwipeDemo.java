package demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

public class SwipeDemo extends BaseTest {

    @Test
    public void swipeTest() throws MalformedURLException, InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.launchAndroid();
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        // Before perform swipe
        WebElement element = androidDriver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        String firstTimeValue = element.getAttribute("focusable");
        Assertions.assertEquals("true", firstTimeValue);

        // Using Javascript Perform swipe
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

}
