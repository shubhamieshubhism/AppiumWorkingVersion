package shubhamTest;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasicWithAppiumDriverLocalServ extends BaseTest{
    @Test
    public void appiumWithoutTerminal(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String alertText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText,"WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Rishabh");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }
}
