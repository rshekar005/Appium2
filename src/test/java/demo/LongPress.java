package demo;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
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
import java.util.List;

public class LongPress extends BaseTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void longPress() throws MalformedURLException, InterruptedException {
        baseTest.launchAndroid();
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
       WebElement longElement=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

       Point point=new Point(longElement.getLocation().getX() + longElement.getSize().getWidth()/2,
               longElement.getLocation().getY()+ longElement.getSize().getHeight()/2);
       /*//Using Javascript
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) longElement).getId(),"duration",3000
        ));*/

        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence= new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),point))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(3000)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));


    }
}
