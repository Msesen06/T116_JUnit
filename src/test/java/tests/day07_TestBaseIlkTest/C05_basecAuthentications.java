package tests.day07_TestBaseIlkTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_basecAuthentications extends TestBase {
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //Html komutu : https://username:password@URL
    // Username    : admin
    //  password     : admin
    //4- Basarili sekilde sayfaya girildigini dogrulayin

    @Test
    public void test01(){
        //2- https://admin:admin@the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(5);
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basariliGirisYazisi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(basariliGirisYazisi.isDisplayed());
        bekle(3);
    }
}
