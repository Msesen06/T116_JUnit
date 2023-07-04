package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardbaseActions extends TestBase {
    @Test
    public void test01(){
        /*
        her ne kadar klavyede pek cok tus olsada bir tus icin yapılabilecek 3 temel islev vardır
        1-tek seferlik basma sendKeys(Keys.ENTER)
        2-bazen belirli bir sure icin bir tusu basılı tutmak isteriz keyDown()
        3- basılı tuttugumuz tusu serbest tutmak isteriz keyUp
         */

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        Actions actions =new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        //4- aramanin gerceklestigini test edin
        String expectedYazi="Samsung A71";
        WebElement sonucElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualYazi= sonucElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    }
}
