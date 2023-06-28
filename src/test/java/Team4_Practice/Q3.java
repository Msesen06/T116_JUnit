package Team4_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q3 extends TestBase {
    @Test
    public void test01(){
        //     https://the-internet.herokuapp.com/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/");
        // Available Examples altinda 10dan fazla kategori oldugunu test edin
        // Infinite Scroll menusune tiklayin
        // acilan sayfada cursor'i 4. paragrafa getirin
        // bir onceki sayfaya geri gidin
        // JavaScript Alert menusuna tiklayin
        // acilan sayfada Click for JS Prompt'a tiklayin
        // acilan yere "AMAzon" ifadesini girin
        // "AMAzon" yazisinin gorunur oldugunu test edin
        // Available Examples altinda 10dan fazla kategori oldugunu test edin
        List<WebElement> kategoriListesi = driver.findElements(By.tagName("li"));
        int kategoriSayisi = kategoriListesi.size();
        Assert.assertTrue(kategoriSayisi > 10);
        System.out.println("kategori testi yapıldı");
        // Infinite Scroll menusune tiklayin
        driver.findElement(By.xpath("//a[@href=\"/infinite_scroll\"]")).click();
        System.out.println("infinite menu tiklandi");
        bekle(2);
        // acilan sayfada cursor'i 4. paragrafa getirin
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
         bekle(5);
        //WebElement dorduncuParagraf = driver.findElement(By.xpath("(//div[@class='jscroll-added'])[7]"));

        System.out.println("dorduncu paragrafa gidildi");
        // bir onceki sayfaya geri gidin
        driver.navigate().back();
        System.out.println("onceki sayfaya gidildi");
        // JavaScript Alert menusuna tiklayin
        driver.findElement(By.xpath("//*[text()='JavaScript Alerts']")).click();
        System.out.println("JavaScript Alert  tiklandi");
        // acilan sayfada Click for JS Prompt'a tiklayin
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        // acilan yere "AMAzon" ifadesini girin
        String expectedString = "AMAzon";
        driver.switchTo().alert().sendKeys("AMAzon");
        driver.switchTo().alert().accept();
        System.out.println("metin girildi");
        // "AMAzon" yazisinin gorunur oldugunu test edin
        String sonucYazi = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(sonucYazi.contains(expectedString));


    }


}
