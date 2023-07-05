package tests.day10_waits_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
    @Test
    public void test01(){
        //((//div[@role=‘row’])[2]/div[@role=‘gridcell’])[5]

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementleriList=driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (int i = 0; i < headerElementleriList.size(); i++) {
            System.out.println(i+1+".sutun baslıgı :"+headerElementleriList.get(i).getText());
        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun baslıgı :"+headerElementleriList.get(2).getText());
        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumElementler=driver.findElements(By.xpath("//div[@role='gridcell']"));
        int sayac=0;
        for (WebElement eachData:tumElementler
             ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                sayac++;
            }
        }

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("bos olmayan satır element sayısı :"+sayac);
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarSayisiList=driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Tablodaki satir sayisi: "+satirlarSayisiList.size());
        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayısı :"+headerElementleriList.size());
        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri=driver.findElements(By.xpath("//div[@role='row']/div[@role='gridcell'][3]"));
        System.out.println("================ucuncu sutun elementleri==============");
        for (WebElement eachData:ucuncuSutunElementleri
        ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
            }
        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        WebElement isimElementi;
        WebElement maasElementi;
        for (int i = 2; i <= satirlarSayisiList.size() ; i++) {
          isimElementi=
                  driver.findElement(By.xpath("(//div[@role='row'])["+i+"]/div[@role='gridcell'][1]"));
          maasElementi =
                  driver.findElement(By.xpath("(//div[@role='row'])["+i+"]/div[@role='gridcell'][5]"));
            if (isimElementi.getText().equals("Kierra")){
                System.out.println("Kierra'nın maası:"+maasElementi.getText());
            }

        }
        //10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        hucreBilgisiYazdir(3,5);
    }
    public void hucreBilgisiYazdir(int satirNo,int sutunNo){
        //"(//div[@role='row'])["+i+"]/div[@role='gridcell'][1]"
        String dinamikXpath="(//div[@role='row'])["+satirNo+"]/div[@role='gridcell']["+sutunNo+"]";
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXpath));
        System.out.println("İstenen hucredeki element :"+istenenElement.getText());
    }
}
