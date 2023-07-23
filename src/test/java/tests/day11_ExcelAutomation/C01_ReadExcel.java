package tests.day11_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/tests/day11_ExcelAutomation/ulkeler.xlsx";
        System.out.println(System.getProperty("user.dir"));//C:\Users\HP\Desktop\team116_JUnit
        //Eger excel dosyası proje icerisinde degilse masaustu veya download gibi bir klasorde ise
        //dosya yolu dinamik hale getirilebilir.
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        /*
         olusturdugumuz workbook bizim excelimizi canlı olarak kullanmaz
         19.satır calıstıgında fisteki yani verdigimiz dosya yolunda olan exceldeki
         tum bilgileri alıp bu classta olusturdugumuz workbook objesine yukler


         Yani workbook objesi exceldeki bilgilerin bir kopyasına sahip olur
         workbookta bir degisiklik yaparsak ana excel degismez
         eger ana exxcelin de degismesini istiyorsak islem bitikten sonra yani
         classın en sonunda workbooktaki  yeni halini excele kaydetmemiz gerekir

         */

        Sheet sheet =workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell= row.getCell(2);
        System.out.println(cell);
        //excelde satır ve sutun numaraları index kullanır yani 0dan baslar

        //12.satırda bulunan Azerbaycanın ingilizce baskentinin Baku oldgunu test edin
        Row onIkinciSatir= sheet.getRow(11);
        Cell ingilizceBaskent= onIkinciSatir.getCell(1);

        String actualBaskent=ingilizceBaskent.getStringCellValue();
        String expectedBaskentIsmi="Baku";
        Assert.assertEquals(expectedBaskentIsmi,actualBaskent);
    }
}
