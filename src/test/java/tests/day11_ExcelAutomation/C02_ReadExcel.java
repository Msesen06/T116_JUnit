package tests.day11_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/test/java/tests/day11_ExcelAutomation/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row birinciSatir= sheet.getRow(0);
        Cell ikinciHucre= birinciSatir.getCell(1);
        System.out.println(ikinciHucre);
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String ikinciHucreStr= ikinciHucre.getStringCellValue();
        System.out.println(ikinciHucreStr);
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        Row ikinciSatir=sheet.getRow(1);
        Cell dorduncuHucre=ikinciSatir.getCell(3);
        String expectedBaskent="Kabil";
        String actualBaskent=
                sheet.getRow(1).getCell(3).getStringCellValue();
        Assert.assertEquals(expectedBaskent,actualBaskent);
        // - Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum());//190 inex
        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows());//satır sayısı 191
        //Sayfa2 icin satır sayısı ve index sayısını yazdırın
        Sheet sayfa2 =workbook.getSheet("Sayfa2");
        System.out.println(sayfa2.getLastRowNum());
        System.out.println(sayfa2.getPhysicalNumberOfRows());
        //Listede Togo isminde bir ulke oldugunu test edin
        boolean flag=false;
        for (int i = 0; i <=sheet.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi=sheet.getRow(i).getCell(0).getStringCellValue();
            if (satirdakiUlkeIsmi.equals("Togo")){
                System.out.println("Exelde Togo var");
                flag = true;
                break;
            }

        }
        Assert.assertTrue(flag);

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap=new TreeMap<>();
        for (int i = 1; i <=sheet.getLastRowNum(); i++) {
            String key=sheet.getRow(i).getCell(0).toString();
            String value=sheet.getRow(i).getCell(1).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);
        //Ulkede Benin isminde bir ulke oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Benin"));
        //Ankara isminde bir baskent oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsValue("Ankara"));
    }
}
