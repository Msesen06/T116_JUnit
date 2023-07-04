package tests.day09_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeybordBaseActions extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement hesapAcButonElementi= driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']"));
        hesapAcButonElementi.click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adElementi= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions =new Actions(driver);
        actions.click(adElementi).sendKeys("Mustafa")
                .sendKeys(Keys.TAB)
                .sendKeys("seren")
                .sendKeys(Keys.TAB)
                .sendKeys("ali123@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ali1232345@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("adim1234")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("1994")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
}
