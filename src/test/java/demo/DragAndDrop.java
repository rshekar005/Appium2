package demo;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

public class DragAndDrop extends BaseTest {

    @Test
    public void dragAndDropTest() throws MalformedURLException, InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.launchAndroid();
        WebElement source = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        Point sourceElement = getCenterOfElement(source.getLocation(), source.getSize());
        Point targetElement = getCenterOfElement(target.getLocation(), target.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElement))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), targetElement))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Collections.singletonList(sequence));

    }

    public static Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.width / 2, location.getY() + size.getHeight() / 2);
    }
}
