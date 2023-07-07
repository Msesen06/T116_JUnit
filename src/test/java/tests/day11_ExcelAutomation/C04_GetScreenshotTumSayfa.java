package tests.day11_ExcelAutomation;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshotTumSayfa extends TestBase {
    @Test
    public void test01() throws IOException {
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //Nutella icin arama yaptırın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //Sonucların Nutella icerdigini test edin
        WebElement sonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik="Nutella";
        String actualYazi= sonucElementi.getText();
        //Tum sayfa fotografını cekmek icin 4 adıma ihtiyac var
        //1- driveri takescreenshota cast edelim
        TakesScreenshot tss= (TakesScreenshot) driver;
        //2- ekran resminin kaydedielecegi  bir file olusturalım
        File tumSayfaSS=new File("target/ekranScreenshot/tumSayfaSS.png");
        //3- tss objesini kullanarak screenshot alalım ve gecici dosyaya kaydedelim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        //4- gecici dosyayı olusturdugumuz tumSayfaSS e kopyalayalım
        FileUtils.copyFile(geciciDosya,tumSayfaSS);
        Assert.assertTrue(actualYazi.contains(expectedIcerik));

    }
}
