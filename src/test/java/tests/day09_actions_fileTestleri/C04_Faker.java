package tests.day09_actions_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Faker extends TestBase {
    @Test
    public void test01(){
        /*
        Faker kutuphanesi testlerimizi yazarken ihtiyac duyabilecegimiz isim soyisim, email, password
        username... gibi bilgileri fake olarak kullanabilmemizi saglar

         */
        Faker faker=new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().avatar());
    }
    @Test
    public void facebookTest(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement hesapAcButonElementi= driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']"));
        hesapAcButonElementi.click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adElementi= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions =new Actions(driver);
        Faker faker =new Faker();
        String emailadres=faker.internet().emailAddress();
        actions.click(adElementi)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailadres)
                .sendKeys(Keys.TAB)
                .sendKeys(emailadres)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("1994")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        bekle(3);

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        bekle(4);

    }
}
