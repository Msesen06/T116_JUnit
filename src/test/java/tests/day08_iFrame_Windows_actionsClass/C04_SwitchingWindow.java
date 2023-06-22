package tests.day08_iFrame_Windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

import java.util.Set;

public class C04_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textelementi= driver.findElement(By.tagName("h3"));

        String expectedText="Opening a new window";
        String actualIcerik=textelementi.getAccessibleName();
        Assert.assertEquals(expectedText,actualIcerik);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle = driver.getTitle();
        //Assert.assertEquals(expectedText,actualTitle);

        String HandleIlkSayfa= driver.getWindowHandle();
        System.out.println("ilk sayfa window hanlde degeri :"+HandleIlkSayfa);
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
        kontrolumuz dısında yeni bir tab veya bir pencere acıldıysa driver otomatik olarak
        oraya gecmez
        Yeni sayfaya gecebilmek icin 2.sayfanın windowhandle degerini  bulmalıyız

            1- ilk sayfada iken ilksayfa handle degerini kaydetmeliyiz
            2- yeni sayfayı acan linki tıklayalım
            3-ilk ve ikinci sayfanın window handle degerlerini bir set olarak kaydedelim
                    Set<String> wHDSeti=driver.getWindowHandles();

            4- bir foreach ile ikinci sayfa handle degerini kaydedelim
            5- ikinci sayfa handle degerini kullanarak diger sayfaya gidlir
         */
        Set<String> wHDSeti=driver.getWindowHandles();
        System.out.println(wHDSeti);

        String ikinciSayfaHandle="";
        for (String each: wHDSeti
             ) {
            if (!each.equals(HandleIlkSayfa)){
               ikinciSayfaHandle=each;
            }
        }
        System.out.println(ikinciSayfaHandle);
        driver.switchTo().window(ikinciSayfaHandle);

        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yazielementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="New Window";
        String actualYazi=yazielementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(HandleIlkSayfa);
        expectedTitle="The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
