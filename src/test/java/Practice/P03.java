package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement checkbox3= driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        Thread.sleep(3000);
        if (!checkbox1.isSelected()) checkbox1.click();
        Thread.sleep(3000);
        if (!checkbox2.isSelected()) checkbox2.click();
        Thread.sleep(3000);
        if (!checkbox3.isSelected()) checkbox3.click();
        Thread.sleep(3000);
        Assert.assertTrue(checkbox1.isSelected()&&checkbox2.isSelected()&&checkbox3.isSelected());

    }
    @After
    public void teardown(){
        driver.close();
    }
}
