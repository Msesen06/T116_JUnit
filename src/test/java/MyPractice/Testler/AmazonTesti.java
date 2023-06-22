package MyPractice.Testler;

import MyPractice.Ayarlar.TestBase;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AmazonTesti extends TestBase {
    // 1-Gerekli Webdriver ayarlamalarını yapın
    // 2- https://www.amazon.com.tr adresine gidin
    //3-url’nin “com.tr” içerdiğini test edin
    //4-Sayfa baslıgının “laptop”( case sensitive olacak sekilde) içermediğini test edin
    //5-dropdown menüden ‘dizüstü bilgisayarlar’ seçeneğini tıklayın
    //6--arama çubuğuna “dizüstü bilgisayar” yazın ve aratın
    //7--sol yan menüde bulunan checkboxlardan marka olarak “apple” seçeneğini
        // ve Ram bellek boyutu olarak 8GB seçeneğini clickleyin
    //8- çıkan  sonuç sayısın 2Den fazla oldgunu test edin
    //9- 2.urune tıklayın ve ozelliklerinin 8gb ram olup olmadığını test edin
    //10- bu urunu sepete ekleyin ve sepete başarılı bir sekilde eklenip eklenmediğini test edin

    @Test
    public void test01(){
        // 2- https://www.amazon.com.tr adresine gidin
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click();
        //3-url’nin “com.tr” içerdiğini test edin
        String expectedIcerikUrl ="com.tr";
        String actualIcerikUrl =driver.getCurrentUrl();
        Assert.assertTrue(actualIcerikUrl.contains(expectedIcerikUrl));
        //4-Sayfa baslıgının “laptop”( case sensitive olacak sekilde) içermediğini test edin
        String expectedTitle="laptop";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        //5-dropdown menüden ‘dizüstü bilgisayarlar’ seçeneğini tıklayın
        WebElement dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));
        Select select =new Select(dropdownMenuElementi);
        select.selectByVisibleText("Bilgisayarlar");
        bekle(2);
        //6--arama çubuğuna “dizüstü bilgisayar” yazın ve aratın
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("dizüstü bilgisayar"+ Keys.ENTER);
        //7--sol yan menüde bulunan checkboxlardan marka olarak “apple” seçeneğini
        // ve Ram bellek boyutu olarak 8GB seçeneğini clickleyin

        driver.findElement(By.xpath("(//span[text()='Apple'])[1]")).click();
        bekle(2);
        driver.findElement(By.xpath("//span[text()='8 GB']")).click();
        bekle(2);
        //8- çıkan  sonuç sayısın 2'den fazla oldgunu test edin
        String sonucElementi = driver.findElement(By.xpath("//div[@class ='a-section a-spacing-small a-spacing-top-small']")).getText();
        String sonucSayisiStr =sonucElementi.substring(0,sonucElementi.indexOf(" "));
        int sonucSayisInt =Integer.parseInt(sonucSayisiStr);
        Assert.assertTrue(sonucSayisInt>2);

        //9- 2.urune tıklayın ve ozelliklerinin 8gb ram icerdigini test edin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[2]")).click();
        String expectedOzellik ="8GB RAM";
        String  actualurunOzellikleri= driver.findElement(By.id("productTitle")).getText();

        Assert.assertTrue(actualurunOzellikleri.contains(expectedOzellik));
        //10- bu urunu sepete ekleyin ve sepete başarılı bir sekilde eklenip eklenmediğini test edin
        driver.findElement(By.id("add-to-cart-button")).click();
        bekle(3);
        WebElement sepetEklendiElementi=driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(sepetEklendiElementi.isDisplayed());
        bekle(2);


    }

}
