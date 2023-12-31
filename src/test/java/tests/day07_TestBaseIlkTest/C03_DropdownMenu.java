package tests.day07_TestBaseIlkTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase {
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunun 4 olduğunu test edin

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownElementi= driver.findElement(By.id("dropdown"));
        Select select =new Select(dropdownElementi);
        select.selectByIndex(1);
        System.out.println("index ile secilen option 1: "+select.getFirstSelectedOption().getText());
        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        bekle(2);
        select.selectByValue("2");
        System.out.println("value ile secilen option 2 : "+select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("text visible ile secilen option 1 : "+select.getFirstSelectedOption().getText());
        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionElementList=select.getOptions();
        System.out.println("==============================");
        for (WebElement element: optionElementList
             ) {
            System.out.println(element.getText());
        }

        // 5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedOptionSayisi=4;
        int actualOptionSayisi=optionElementList.size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
        bekle(3);

    }
}
