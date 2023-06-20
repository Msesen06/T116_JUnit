package tests.day05_maven_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebApp {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
        WebElement usernameElement =driver.findElement(By.xpath("//input[@id='user_login']"));
        usernameElement.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()=\"Online Banking\"]")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("200");
        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement subimittedElement = driver.findElement(By.id("alert_content"));
        String expecetedmesaj ="The payment was successfully submitted.";
        String actualMesaj =subimittedElement.getText();

        if (expecetedmesaj.equals(actualMesaj)){
            System.out.println("odeme testi PASSED");
        }else {
            System.out.println("odeme testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
