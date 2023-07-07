package tests.day12_screenshot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReasubleMethods;
import utilities.TestBase;

import static utilities.ReasubleMethods.tumSayfaFotoCek;

public class C01_ReasubleMethodsTumsayfaSS extends TestBase {
    @Test
    public void test01(){
        //Wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");
        //url in wise icerdginin test edelim
        String expectedUrl="wise";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //tumsayfaya ss alalım
        ReasubleMethods.tumSayfaFotoCek(driver);

    }
}
