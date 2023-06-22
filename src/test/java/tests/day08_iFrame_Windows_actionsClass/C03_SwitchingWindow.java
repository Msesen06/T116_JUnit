package tests.day08_iFrame_Windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        bekle(2);
        String windowHandleAmazon= driver.getWindowHandle();

        //yeni bir tab olarak wise quartera gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        bekle(2);
        String windowHandleWise= driver.getWindowHandle();

        //yeni bir sayfada youtube a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        bekle(2);
        String windowHandleYoutube= driver.getWindowHandle();

        //amazonun acık oldugu sayfaya ve url'in amazon icerdigini test edin
        driver.switchTo().window(windowHandleAmazon);
        bekle(1);
        String expectedIcerik="amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // sonra wise quarterin acık oldugu sayfaya gidin ve title in wise icerdigini test edin
        driver.switchTo().window(windowHandleWise);
        bekle(1);
        String expectedTitleIcerik ="Wise";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // sonra da youtube oldugu sayfaya gidin ve url in youtube icerdgini test edin
        driver.switchTo().window(windowHandleYoutube);
        bekle(2);
        expectedIcerik ="youtube";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

    }
}
