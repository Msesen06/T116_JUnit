package tests.day08_iFrame_Windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Actions extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions =new Actions(driver);
        WebElement dragmeElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropmeElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        bekle(5);
        actions.dragAndDrop(dragmeElementi,dropmeElementi).perform();
        bekle(7);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropYaziElementi=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedDropYazi="Dropped!";
        String actualDropYazisi=dropYaziElementi.getText();
        Assert.assertEquals(expectedDropYazi,actualDropYazisi);
    }
}
