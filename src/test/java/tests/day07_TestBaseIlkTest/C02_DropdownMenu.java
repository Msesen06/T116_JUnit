package tests.day07_TestBaseIlkTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropdownMenu extends TestBase {
    @Test
    public void test01(){
        //Amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        // arama kutusunun yanındaki dropdown menude 28 secenek oldugunu test edin
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(dropDown);
        int expectedOptionSayisi =28;
        int actualOptionSayisi=select.getOptions().size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
        bekle(3);
        // dropdown menuden baby kategorisini  secin
        select.selectByVisibleText("Baby");

        // arama kutusuna nutella yazın aratın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // bulunan sonuc sayısının 10 dan fazla oldugunu test edin
        String sonucYazisi =driver.findElement(By.xpath("//div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[1]")).getText();
        String sonucSayisiStr=sonucYazisi.substring(0,sonucYazisi.indexOf(" "));//"18"
        int sonucSayisiInt =Integer.parseInt(sonucSayisiStr);//

        Assert.assertTrue(sonucSayisiInt>=10);
        //sectigimiz opsiyonu yazdırın

        //Biz daha once dropdown menuyu locate edip bunu kullanarak select objesi  olusturmustuk
        //ancak arama yaptırdıgımızda html kodlar yenilendigi icin eski elementleri bulamayabilir
        //bu durumda stale element bayat element uyarısı verir
        // yapmamız gereken yeni obje olsuturmak degil objelere yeniden deger atamak
        dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select =new Select(dropDown);
        System.out.println(select.getFirstSelectedOption().getText());
        // sectigimiz opsiyonun baby oldugunu test edin
        bekle(3);
        String expectedSeciliOption="Baby";
        String actualSeciliOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSeciliOption,actualSeciliOption);
    }

}
