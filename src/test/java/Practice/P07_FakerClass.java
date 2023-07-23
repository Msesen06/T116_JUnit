package Practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P07_FakerClass extends TestBase {
    @Test
    public void faker() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement ilkLoginElementi=driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        ilkLoginElementi.click();
        WebElement nameElementi=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailElementi=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        WebElement signOlElementi=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));

        Actions actions=new Actions(driver);
        Faker faker =new Faker();
        String isim =faker.name().fullName();
        String email=faker.internet().emailAddress();
        actions.click(nameElementi).sendKeys(isim)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("id_gender1")).click();
        WebElement passwordkutusu= driver.findElement(By.id("password"));
        actions.click(passwordkutusu).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).perform();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        String ecpectedword="CREATED";
        WebElement actualword= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String testWord=actualword.getText();
        Assert.assertTrue(testWord.contains(ecpectedword));






    }
}
