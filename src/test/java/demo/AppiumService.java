package demo;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumService {

    public AppiumDriverLocalService appiumDriverLocalService;

    public void startServer() {
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\hi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();
    }

    public void stopServer(){
        appiumDriverLocalService.stop();
    }
}
