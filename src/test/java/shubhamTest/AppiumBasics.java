package shubhamTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AppiumBasics {
    private AndroidDriver driver;
    @Test
    public void appiumTest() throws MalformedURLException, FileNotFoundException, URISyntaxException {

        //appium code -> appium server -> Mobile
        try {
            // Setup capabilities

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

            // Initialize driver
            URL appiumServerURL = new URI("http://localhost:4723").toURL();
            driver = new AndroidDriver(appiumServerURL, options);

            // Add a simple test to verify connection
            System.out.println("Session created successfully!");

        } catch (Exception e) {
            System.err.println("Failed to create session: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        driver.quit();
    }
}
