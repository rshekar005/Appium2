package demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;

public class ScrollDemo extends BaseTest{

    @Test
    public void swipeTest() throws MalformedURLException, InterruptedException {
        BaseTest baseTest= new BaseTest();
        baseTest.launchAndroid();


        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Scroll till the element visible

        /*androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                                "scrollIntoView(text(\"Visibility\"));")).click();*/


        //Scroll as long as the element present
        boolean canScrollMore;
        do {
             canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 3.0
                    ));
        }while( canScrollMore);
      /*  androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();*/


    }
}
