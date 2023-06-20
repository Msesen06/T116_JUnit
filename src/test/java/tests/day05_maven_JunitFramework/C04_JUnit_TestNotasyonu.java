package tests.day05_maven_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnit_TestNotasyonu {

    /*
    Junitin bize kazandırdıgı en onemli yeniliklerden biri @Test notasyonudur.
    Notasyon annotation kucuk bilgiler meta data barındıran yapılardır.
    sadece bir yazı ya da gosterim degillerdir. yaptıkları islemler vardır

    sıradan bir methodu tek basına calıstırılabilir bir test methoduna donusturur


    Junit ile test mehodları istersek tek basına istersek de class leveldan calıstırıp
    hepsini birlikte calıstırabiliriz

    Junit testleri belirsiz bir sırada calıstırır. test methodlarını hangi  sırayla calısacagını
    ongoremeyiz ve duzenleyemeyiz

     */





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

        String expectedIcerik ="Wise Kuarter";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){

            System.out.println("test passed");
        }else  {
            System.out.println("Test failed");
        }


        //sayfayı  kapatın
        driver.close();

    }
}
