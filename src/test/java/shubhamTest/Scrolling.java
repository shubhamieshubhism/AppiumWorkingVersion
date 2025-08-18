package shubhamTest;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Scrolling extends BaseTest{
    @Test
    public void scrollingGestureUsingAndroidUIAutomator(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textToBeScrolled+"\"));"));
        //above line of code is now converted into a below method
        scrollUsingUiAutomator("WebView");

    }

    @Test
    public void scrollGestureUsingAppium(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToEnd("down");


        /*boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 3.0
        ));*/

    }
}

