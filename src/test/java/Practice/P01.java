package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    //@Test yapacagımız test kodlarını calsıtıracak
    //@BeforeClass sadece bir kere calısır
    //@Before her test basında bir kere calısacak
    //@AfterClass Butun testler bitince bir kez calısırç
    //@After her test sonunda calısacak

    //Assertions İslemi

    //https://www.google.com adresine gidin title in google icerdigini test edin

    @Test
    public void testTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");
        String expectedIcerik="google";
        String expectedIcerik1="Google";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedIcerik));
        Assert.assertTrue(actualTitle.contains(expectedIcerik1));
        driver.close();

    }
}
