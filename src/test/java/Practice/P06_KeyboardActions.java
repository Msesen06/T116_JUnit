package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06_KeyboardActions extends TestBase {
    @Test
    public void amazonArama(){
        driver.get("https://www.amazon.com");
        //amazonda iPhone XR aratalım
        Actions actions =new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu)
                .keyUp(Keys.SHIFT).sendKeys("i")
                .keyDown(Keys.SHIFT).sendKeys("p")
                .keyUp(Keys.SHIFT).sendKeys("hone")
                .keyDown(Keys.SHIFT).sendKeys(" xr")
                .keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).perform();

        String expectedIcerik="iPhone XR";
        WebElement sonucElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualSonuc=sonucElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));







    }
}
