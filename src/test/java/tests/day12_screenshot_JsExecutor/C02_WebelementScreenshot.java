package tests.day12_screenshot_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReasubleMethods;
import utilities.TestBase;

public class C02_WebelementScreenshot extends TestBase {
    @Test
    public void test01(){
        //google gidelim
        driver.get("https://www.google.com");
        bekle(4);
        //Nutella aratalım
       WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@name='q']"));
       aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuc sayısının ssini alalım
        WebElement sonucElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        ReasubleMethods.webElementFotoCek(driver,sonucElementi);

    }
}
