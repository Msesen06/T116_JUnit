package Team4_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q6 extends TestBase {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız
    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=driver.findElements(By.tagName("iframe"));
        System.out.println(iframeList.get(0).getText());
        System.out.println(iframeList.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeElementi= driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(youtubeElementi);
        //WebElement oynatElementi= driver.findElement(By.xpath("//button[@aria-label=\"Oynat\"]"));
        //oynatElementi.click();
        bekle(5);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2= driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//a[@href='https://www.guru99.com/live-selenium-project.html']")).click();




    }


}
