package tests.day08_iFrame_Windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C02_SwitchingWindows extends TestBaseQuit {
    @Test
    public void test01(){
        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin
        String expectedIcerik="amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        bekle(2);


        // Yeni bir tab olarak wise quarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");


        // title'in Wise icerdigini test edin
        String expectedTitleIcerik ="Wise";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        bekle(2);
        // yeni bir window acarak youtube sayfasina gidin
        // url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        expectedIcerik ="youtube";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // acilan tum sayfalari kapatin
        driver.quit();
    }

}
