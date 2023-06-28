package MyPractice.Testler;

import MyPractice.Ayarlar.TestBase;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AmazonTesti extends TestBase {
    // 1-Gerekli Webdriver ayarlamalarını  yapın
    // 2- https://www.amazon.com.tr adresine gidin
    // 3-url’nin “com.tr” içerdiğini test edin
    // 4-Sayfa baslıgının “laptop” içermediğini test edin
    // 5-dropdown menüden ‘bilgisayarlar’ seçeneğini tıklayın
    // 6--arama çubuğuna “dizüstü bilgisayar” yazın ve aratın
    // 7--sol yan menüde bulunan checkboxlardan marka olarak “ASUS” seçeneğini clickleyin
    // 8- çıkan  sonuç sayısın 100 fazla oldgunu test edin
    // 9- 2.urune tıklayın ve markasının Asus oldugunu test edin
    // 10- bu urunu sepete ekleyin ve sepete başarılı bir sekilde eklenip eklenmediğini test edin
    @Test
    public void test01(){
        // 2- https://www.amazon.com.tr adresine gidin
        driver.get("https://amazon.com.tr");

        // 3-url’nin “com.tr” içerdiğini test edin
        String expectedUrl="com.tr";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        System.out.println("url testi");

        // 4-Sayfa baslıgının “laptop” içermediğini test edin
        String unExpectedTitle="laptop";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unExpectedTitle));
        System.out.println("Title check");

        // 5-dropdown menüden ‘bilgisayarlar’ seçeneğini tıklayın
        WebElement dropDownBox= driver.findElement(By.id("searchDropdownBox"));
        Select select =new Select(dropDownBox);
        select.selectByVisibleText("Bilgisayarlar");

        // 6--arama çubuğuna “dizüstü bilgisayar” yazın ve aratın
        WebElement searhTabBox= driver.findElement(By.id("twotabsearchtextbox"));
        searhTabBox.sendKeys("dizüstü bilgisayar");
        searhTabBox.submit();

        // 7--sol yan menüde bulunan checkboxlardan marka olarak “ASUS” seçeneğini clickleyin

        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println("actions");
        driver.findElement(By.xpath("//*[@id=\"n/12601898031\"]/span/a")).click();
        bekle(5);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[4]/ul/li/span/div/a")).click();
        WebElement markaElementi=driver.findElement(By.xpath("//*[@id='p_89/ASUS']/span/a"));
        markaElementi.click();


        // 8- çıkan  sonuç sayısın 50den fazla oldgunu test edin
        String actualSonucStr=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        int expectedSonuc=50;
        String actualSonucstr1=actualSonucStr.substring(0,actualSonucStr.indexOf(" "));
        int sonuc=Integer.parseInt(actualSonucstr1);
        Assert.assertTrue(sonuc>expectedSonuc);
        System.out.println(actualSonucStr);






    }


}
