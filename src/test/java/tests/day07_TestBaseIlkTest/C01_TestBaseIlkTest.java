package tests.day07_TestBaseIlkTest;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseIlkTest extends TestBase {
    /*
    Bir classın test case i olarak kullanabilmesi icin
    oncelikle Webdriver ayarlarının yapılması ve obje olusturulması gerekir

     Java OOP consept cercevesinde Webdriver objesinin illa da bu classta olması gerekmez

     Baska classtaki ozellikleri sah
     */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        bekle(3);
    }
}
