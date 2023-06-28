package Team4_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q2 extends TestBase {
    //actions.scrollToElement(abajur).perform();
    // actions.moveToElement(abajur).perform();
    @Test
    public void test01(){
        // 1- "https://www.ikea.com.tr" aresine gidin

        //2- mouse u abajur resiminin üzerine getirin

        //3- açılan bilgi alanında bulunan "sepete ekle" butonuna tıklayın

        //4- "Sepete Eklendi" yazısının görünürlüğünü test edin

        //5- sayfanın sağ ust köşesindeki sepet iconuna tıklayın

        //6- acilan bilgi alanındaki çöp kutusu iconuna tıklayın
        // 1- "https://www.ikea.com.tr" aresine gidin
        //     URL nin "ikea" yazısını icerdigini test edin

        driver.get("https://www.ikea.com.tr");
        Assert.assertTrue(driver.getCurrentUrl().contains("ikea"));

        //2- mouse u abajur resiminin üzerine getirin
        Actions actions = new Actions(driver);
        WebElement abajur = driver.findElement(By.xpath("//*[@id='i57vg']"));
        actions.scrollToElement(abajur).perform();
        actions.moveToElement(abajur).perform();
        //3- açılan bilgi alanında bulunan "sepete ekle" butonuna tıklayın
        WebElement sepeteEkle = driver.findElement(By.id("ioin64"));
        sepeteEkle.click();
        //4-  sayfanın sağ ust köşesindeki sepet iconuna tıklayın
        WebElement sepetElementi = driver.findElement(By.xpath("//a[@class='shopping-basket']"));
        sepetElementi.click();

        //5- urunun sepette oldugunu test edin

        WebElement urunSepetteMi = driver.findElement(By.xpath("//a[@id='ctl00_lnkProductProduct']"));
        Assert.assertTrue(urunSepetteMi.isDisplayed());


    }
}
