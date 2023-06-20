package tests.day05_maven_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeTest_AfterTestNotasyonlari {

    /*

    Junit ile classdaki her test methodu calısmaya baslamadan once calısmasını istedgimiz methodları
    @Before
    her test methodundan sonra calısmasonı istedgimiz methodları ise @After notasyonu ile isaretleriz

    Boylece test methodu calısmaya baslarken method call yapmaya gerek kalmadan @BEfore notasyonunan
     sahip method calısır

     test methodu bitince de @after notasyonu olan method calısır.
     */
    WebDriver driver;
    @Test
    public  void amazonTesti(){

        //amazona gidelim ve urlin amazon test edip sayfayı kapatın

        driver.get("https://www.amazon.com");

        String expecetdeIcerik ="amazon";
        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expecetdeIcerik)){
            System.out.println("amazon url testi PASSED");
        }else  {
            System.out.println("amazon url testi FAILED");
            throw  new RuntimeException();
        }


    }
    @Test
    public void wiseQuarterTesti(){
        //Wise quarter anasayfaya gidip
        //Title in Wise Quarter icerdigini test edelim
        //sayfayı kapatın

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


    }

    @Test
    public void youTubeTesti(){

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



    }
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.close();
    }
}
