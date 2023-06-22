package tests.day08_iFrame_Windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
     //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    // - Text Box’a “Merhaba Dunya!” yazin.
    // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement anIframeElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElementi.isEnabled());

        System.out.println(anIframeElementi.getText());

        // - Text Box’a “Merhaba Dunya!” yazin.

        /*
        text box elementi gozumuzun onunde olmasına ragmen direkt kullanilemıyor
        iframe icerisinde oldugu icin once ona gecis yapmalıyız
         */


        WebElement IframeElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(IframeElementi);
        WebElement textBoxelementi = driver.findElement(By.tagName("p"));
        textBoxelementi.clear();
        textBoxelementi.sendKeys("Merhaba Dunya");

        // - TextBox’in altinda bulunan “Elemental Selenium”
        // linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin
        /*
        bir iframe e gecis yapıldıysa normal sayfada islem yapılamaz o  yuzden iframeden cıkmak gerekir
        default content
        parentframe
         */
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text() ='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());
        bekle(3);
    }
}
