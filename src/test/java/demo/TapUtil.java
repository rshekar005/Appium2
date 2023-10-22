package demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

public class TapUtil extends BaseTest {


    @Test
    public void openMenuUsingTap() throws MalformedURLException, InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.launchAndroid();
        WebElement openMenu = androidDriver.findElement(AppiumBy.accessibilityId("open menu"));
        tap(openMenu,androidDriver);
    }
    public void tap(WebElement element, AndroidDriver driver) throws MalformedURLException, InterruptedException {
        Point location = element.getLocation();
        Dimension dimension = element.getSize();
        Point centerOfElement = getCenterOfElement(location, dimension);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence=
                new Sequence(finger1,1)
                        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger1, Duration.ofMillis(200)))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));

    }

    // This method is used to get the center of an element.
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2,
                location.getY() + size.getHeight() / 2);
    }


}
