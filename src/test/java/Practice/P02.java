package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin x den kucuk oldugu test edilir
    // yorum yapılabilir
    WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void paraKarsilastir(){
        driver.get("https://www.google.com");
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        aramaKutusu.sendKeys("usd to tl"+ Keys.ENTER);
        WebElement sonucElementi= driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        String sonucStr= sonucElementi.getText();
        String str1=sonucStr.replace(",",".");
        double sonuc =Double.parseDouble(str1);
        Assert.assertTrue(sonuc<30);

    }
    @After
    public void teardown(){
        driver.close();
    }

}
