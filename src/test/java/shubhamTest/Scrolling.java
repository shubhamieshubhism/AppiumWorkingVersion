package shubhamTest;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Scrolling extends BaseTest{
    @Test
    public void longPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textToBeScrolled+"\"));"));
        //above line of code is now converted into a below method
        scrollUsingUiAutomatior("WebView");

    }
}
