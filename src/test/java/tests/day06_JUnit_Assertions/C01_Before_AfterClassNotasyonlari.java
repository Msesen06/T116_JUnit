package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_AfterClassNotasyonlari {
    static WebDriver driver;

    /*
    bir classtaki  test methodları birbiri ile baglantılı ise birinin  calısabilmesi icin onceki test
    methodunun claısması gerekiyorsa yani bagımsız calıstırılmayacaksa
    @beforeclass ve @Afterclass notasyonlarını kullanmalıyız

        ANCAK,....
        bu notasyonlara sahip method'larin static olmasi gerekir

     */

    //Amazon anasayfasına gidin
    //3 farklı test methodu olusturup verilen testleri yapın
    //1- Url amazon icerdigini test edin
    //2-Nutella arattırın ve sonucların nutella icerdigini test edin
    //3- ilk urune click yapıp urun isminin Nutella icerdigini test edin

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1- Url amazon icerdigini test edin
       String expectedUrlIcerik="amazon";
       String actualUrl = driver.getCurrentUrl();

       if (actualUrl.contains(expectedUrlIcerik)){
           System.out.println("url testi  PASSED");
       }else {
           System.out.println("url testi  FAILED");
           throw new RuntimeException();
       }

    }

    @Test
    public void test02(){
        //h1[@class='a-size-base s-desktop-toolbar a-text-normal']
        // 2- Nutella arattirin ve sonuclarin Nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik ="Nutella";
        String actualYazi = sonucYaziElementi.getText();
        if (actualYazi.contains(expectedIcerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
            throw new RuntimeException();
        }

    }

    @Test
    public void test03(){
        //3- ilk urune click yapıp urun isminin Nutella icerdigini test edin
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        WebElement urunIsimElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik ="Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("urun isim testi PASSED");
        }else {
            System.out.println("urun isim testi FAILED");
            throw  new RuntimeException();
        }


    }


}
