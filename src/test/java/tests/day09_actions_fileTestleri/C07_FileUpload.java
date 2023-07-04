package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {
    @Test
    public void test01(){

        //choose file butonuna sendkeys ile dosya yolunu gonderiyoruz


        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        WebElement chooseFileButonElementi= driver.findElement(By.id("file-upload"));
        //3.masaustune kaydettigimiz avatar.png dosyasını secelim .
        String dinamikDosyaYolu=System.getProperty("user.home")+"/Desktop/avatar.png";
        chooseFileButonElementi.sendKeys(dinamikDosyaYolu);
        bekle(5);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(4);
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadElementi= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadElementi.isDisplayed());

    }
}
