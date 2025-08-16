package shubhamTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws FileNotFoundException, URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723)
                .build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9");
        // Use absolute path or verify relative path exists
        File appFile = new File("src/test/java/Resources/ApiDemos-debug.apk");
        if (!appFile.exists()) {
            throw new FileNotFoundException("APK file not found at: " + appFile.getAbsolutePath());
        }
        options.setApp(appFile.getAbsolutePath());
        // Optional: Add more capabilities for stability
        options.setAutomationName("UIAutomator2");
        options.setPlatformName("Android");
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        //URL appiumServerURL = new URI("http://localhost:4723").toURL();
        URL appiumServerURL = new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(appiumServerURL, options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPressAction(RemoteWebElement element){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", element.getId(),
                "duration", 800   // duration in ms
        ));
    }

    public void scrollUsingUiAutomatior(String textToBeScrolled){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textToBeScrolled+"\"));"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

}
