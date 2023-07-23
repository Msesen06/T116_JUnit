package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class P05_iFrame extends TestBaseQuit {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement sayfadakiYazi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfadakiYazi.isDisplayed());
        System.out.println(sayfadakiYazi.getText());
        WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement iFrameYazisi=driver.findElement(By.id("tinymce"));
        String iFramedekiYazi=iFrameYazisi.getText();
        System.out.println(iFramedekiYazi);
        iFrameYazisi.clear();
        iFrameYazisi.sendKeys("have wise quarter");



    }

}
