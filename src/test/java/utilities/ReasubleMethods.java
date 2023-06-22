package utilities;

import org.openqa.selenium.WebDriver;

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
}
