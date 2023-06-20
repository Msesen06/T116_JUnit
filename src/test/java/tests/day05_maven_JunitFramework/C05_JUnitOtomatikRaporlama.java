package tests.day05_maven_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_JUnitOtomatikRaporlama {
    /*
    Junit Frameworkunde bir class veya test methodu calıstırıldıgında Junit tum class veya istenen
    methodun sorunsuz calısıp calısmadıgını kontrol eder

    eger if else ile yaptıgımız testlerde Junitin raporlarının da test sonucları ile uyumlu olmasını
    isterseniz FAILED durumlarında throw keyword ile herhangi bir exeption olusturtulabiliriz
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
}
