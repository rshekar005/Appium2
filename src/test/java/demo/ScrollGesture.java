package demo;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

public class ScrollGesture extends BaseTest {

    @Test
    public void scroll() throws MalformedURLException, InterruptedException {
        BaseTest baseTest= new BaseTest();
        baseTest.launchAndroid();
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        Dimension size = androidDriver.manage().window().getSize();
        int startx = size.getWidth() / 2;
        int starty = size.getHeight() / 2;

        int endx=startx;
        int endy= (int)(size.getHeight() * 0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endx, endy))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

}
