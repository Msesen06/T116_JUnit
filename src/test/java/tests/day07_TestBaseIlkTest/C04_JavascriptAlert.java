package tests.day07_TestBaseIlkTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_JavascriptAlert extends TestBase {

    /*
    bir testi calıstırırken web sayfası bize uyarı verebilir. buna alert denir

    Eger bu uyarıyı sag click yapıp inspect edebiliyorsak bu html alertidir ve locate edilebilir.
    ancak sag click yapıp inspect edemiyorsak bunlar javascrip alertidirler ve
    locate edilemezler.
     */

    //1. Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin
    //2.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    //3.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 1.alert’e tiklayin
        bekle(1);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actualAlertYazisi =driver.switchTo().alert().getText();
        String expectedAlertYazisi="I am a JS Alert";

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
        bekle(3);

    }

    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        bekle(2);
        driver.switchTo().alert().dismiss();
        String expectedSonucYazisi ="You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        bekle(3);
    }

    @Test
    public void test03(){

        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        bekle(2);
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        bekle(2);
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedIcerik ="Abdullah";
        String actualIcerik=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        bekle(3);
    }
}
