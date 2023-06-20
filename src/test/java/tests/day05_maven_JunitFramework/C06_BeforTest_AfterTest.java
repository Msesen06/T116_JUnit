package tests.day05_maven_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforTest_AfterTest {
    /*
    Bir classın icinde birden fazla test methodu varsa hepsi bagımsız olarak da calsıtırılabilsin diye
    her methoda mahserin 4 atlısını eklememiz gerekir
    Ancak bu islem test methodlarını gereksiz yere uzatır.
    Bunun yerine stupt methodu olusturup ilgili ayarlari  burada yaparsak test methodlarında
    sadece teste odaklanabiliriz

    bu yontemde scope dan kaynaklı bir sorun olusur

    eger webdriver objesini class levelda olusturup
    method icerisinde deger atayabiliriz

     */
    WebDriver driver;
    @Test
    public  void amazonTesti(){

        //amazona gidelim ve urlin amazon test edip sayfayı kapatın
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        String expecetdeIcerik ="ramazon";
        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expecetdeIcerik)){
            System.out.println("amazon url testi PASSED");
        }else  {
            System.out.println("amazon url testi FAILED");
            throw  new RuntimeException();
        }

        driver.close();

    }
    @Test
    public void wiseQuarterTesti(){
        //Wise quarter anasayfaya gidip
        //Title in Wise Quarter icerdigini test edelim
        //sayfayı kapatın

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");

        //Title in Wise Quarter icerdigini test edelim

        String expectedIcerik ="Wise Quarter";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){

            System.out.println("test passed");
        }else  {
            System.out.println("Test failed");
            throw new RuntimeException();
        }


        //sayfayı  kapatın
        driver.close();

    }

    @Test
    public void youTubeTesti(){

        setup();
        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        //Title ın Youtube  gorundugunu test edin
        String expectedTitle ="YouTube";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("You tube testi PASSED");
        }else {
            System.out.println("You tube testi PASSED");
            throw new RuntimeException();
        }

        driver.close();


    }

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

}
