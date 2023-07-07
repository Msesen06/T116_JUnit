package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReasubleMethods extends TestBase{
    public static String HandleDegeriBul(String ilkSayfaHandleDegeri, WebDriver driver) {

        ilkSayfaHandleDegeri = driver.getWindowHandle();

        Set<String> wHDSeti = driver.getWindowHandles();

        String ikinciSayfaHandleDegeri = "";

        for (String each : wHDSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri = each;
            }
        }
        return ikinciSayfaHandleDegeri;

    }
    public static String hucredekiYaziyiGetir(int satirNo,int sutunNo, WebDriver driver){
        ////tbody/tr[5]/td[1]

        String dinamikXpath="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));
        return istenenHucredekiElement.getText();
    }

    public static void tumSayfaFotoCek(WebDriver driver){
        TakesScreenshot tss= (TakesScreenshot) driver;
        //Dosya adını dinamik hale getirmek icin time stamp kullanalım
        LocalDateTime ldt =LocalDateTime.now();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("YYMMddhhmm");
        String dinamikDosyaYolu="target/Screenshots/Tumsayfa"+ldt.format(dtf)+".png";

        File tumSayfaFoto=new File(dinamikDosyaYolu);
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void webElementFotoCek(WebDriver driver,WebElement istenenElement) {

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddhhmm");
        String dinamikDosyaYolu="target/Screenshots/Tumsayfa/WebElement"+ldt.format(dtf)+".png";
        File webElementFoto=new File(dinamikDosyaYolu);
        File geciciDosya=istenenElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,webElementFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
