package tests.day12_screenshot_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutor extends TestBase {
    @Test
    public void test01(){
        //wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");
        //Jsexecutor kullanarak
        WebElement contactElementi= driver.findElement(By.xpath("//a[text()='Contact']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",contactElementi);
        bekle(2);
        //asagıda buluna submit butonuna kadar inin ve tıklyaın
        driver.navigate().back();
        WebElement goToCareer= driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",goToCareer);
        bekle(5);
        jse.executeScript("alert('yasasinnnn');");
        bekle(3);
        driver.switchTo().alert().accept();
    }
}
