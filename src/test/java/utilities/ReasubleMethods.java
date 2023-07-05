package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ReasubleMethods extends TestBase{
    public static String HandleDegeriBul(String ilkSayfaHandleDegeri, WebDriver driver) {

        ilkSayfaHandleDegeri = driver.getWindowHandle();

        Set<String> wHDSeti = driver.getWindowHandles();

        String ikinciSayfaHandleDegeri = "";

        for (String each : wHDSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri = each;
            }
        }
        return ikinciSayfaHandleDegeri;

    }
    public static String hucredekiYaziyiGetir(int satirNo,int sutunNo, WebDriver driver){
        ////tbody/tr[5]/td[1]

        String dinamikXpath="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));
        return istenenHucredekiElement.getText();
    }
}
