package shubhamTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swiping extends BaseTest {


    @Test
    public void swipeGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        RemoteWebElement firstImage = (RemoteWebElement) driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        String focusable = firstImage.getAttribute("focusable");
        Assert.assertEquals(focusable,"true");

        //Swipe logic
        /*driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",firstImage.getId(),
                "direction","left",
                "percent",0.25
                ));*/
        swipeAction(firstImage,"left");
        RemoteWebElement secondImage = (RemoteWebElement) driver.findElement(By.xpath("//android.widget.ImageView[2]"));
        String secondImageFocusable = secondImage.getAttribute("focusable");

        Thread.sleep(2000);
        Assert.assertEquals(secondImageFocusable, "true");
        System.out.println("first image attribute : "+focusable);
        System.out.println("second image attribute : "+secondImageFocusable);

    }
}

