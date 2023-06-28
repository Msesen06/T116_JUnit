package Team4_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.accessibility.AccessibleEditableText;

public class Q1 extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions =new Actions(driver);
        WebElement accountListElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountListElementi).perform();

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi="Your Lists";
        String actualYazi=driver.findElement(By.id("my-lists-tab")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
