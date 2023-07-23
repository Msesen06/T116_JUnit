package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04_Switchto extends TestBase {
    /*
    1- Gerekli ayarlamaları yapın
    2- google.com sayfasına gidin
    3- google titleın Google icerdigini test edin
    4- yeni pencerede wisequarter sayfasına gidelim
    5- wise quarter sayfasının title ının wise icerdigini test edin

     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.google.com");
        String ilkSayfaWHD= driver.getWindowHandle();
        System.out.println("ilk acılan sayfanın window handle degeri:"+ilkSayfaWHD);
        String expectedWords="Google";
        String actualTitle= driver.getTitle();
        Thread.sleep(3000);
        Assert.assertTrue(actualTitle.contains(expectedWords));

        //4- yeni pencerede wisequarter sayfasına gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.wisequarter.com");
        String ikinciPencereWHD=driver.getWindowHandle();
        System.out.println("ikinci sayfa window handle degeri:"+ikinciPencereWHD);
        String expectedWord2="Wise";
        String actualTitle2= driver.getTitle();
        Assert.assertTrue(actualTitle2.contains(expectedWord2));

        driver.switchTo().window(ilkSayfaWHD);
        driver.get("https://www.amazon.com");
        String expectedWord3="Amazon";
        String actualTitle3= driver.getTitle();
        Assert.assertTrue(actualTitle3.contains(expectedWord3));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedWord4="Amazon";
        String actualTitle4= driver.getTitle();
        Assert.assertFalse(actualTitle4.contains(expectedWord4));



    }

}
