package tests.day05_maven_JunitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_MavenIlkTEst {
    public static void main(String[] args) throws InterruptedException {

        /*
        Selenium 4.7.0 ile Selenium kendi Webdriverını olusturma ve kullanabilme imkanı verdi


        Tum sirketler Selenium Webdriverını kullanmayabilir.
        Sirketlerde Eskiden beri kullanılan bir WebDriver varsa onu projemize eklememiz ve kullammamız istenebilir.

        Boyle bir durumda istenen WebDriverı da pom.xml eklememiz gerekir.
        pom.xml'e ekledikten sonra Webdriver objesi olusturmadan once
        webdriver ile ilgili setup u kurmamız gerekir

         */

        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");


        Thread.sleep(3000);
        driver.close();


    }
}
