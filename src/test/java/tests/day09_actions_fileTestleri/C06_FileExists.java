package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExists extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. avatar.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='avatar.png']")).click();
        bekle(5);


        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyayolu =System.getProperty("user.home")+"/Downloads/avatar.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
    @Test
    public void masaustu(){
        //avatar resmini masaustune kaydedin
        // olup olmagını test edin
        String dinamikDosyaYolu=System.getProperty("user.home")+"/Desktop/avatar.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        //https://the-internet.herokuapp.com/upload
    }
}
