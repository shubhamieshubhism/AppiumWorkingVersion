package shubhamTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogPress extends BaseTest{
    @Test
    public void longPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        RemoteWebElement longPress = (RemoteWebElement) driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(longPress);
        String text = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(text,"Sample menu");
        boolean textIsdisplayed = driver.findElement(AppiumBy.id("android:id/title")).isDisplayed();
        Assert.assertTrue(textIsdisplayed,"Text needs to be displayed");


    }
}
