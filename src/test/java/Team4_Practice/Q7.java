package Team4_Practice;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q7 {
    //sinifListesi adında yeni excel dosyası olusturun
    //satır sayısı ve fiziki kullanılan satır sayısını bulun ve yazdırın
    //3.satır 2.hucreyi degiskene atayıp yazdırın
    //4.satırdaki ogrencinin ulkesinin "Türkiye" oldugunu test edin
    //Sayfada "Almanya" ülkesinin oldugunu test edin
    // ogrenci adlarını ve sehirlerini map olarak kaydedin
    // sehirler arasında  "Gaziantep" oldugunu test edin
    // 4.hucreye yeni cell olusturun ve "Yas" yazdırın
    //3.satırdaki ogrencinin yasını 17 olarak girin
    //3.satırdaki ogrencinin yasının 17 oldugunu test edin
    //yapılan degisikleri dosyaya isleyin ve dosyayı kapatın
    @Test
    public void excelRead() throws IOException {
        String dosyaYolu="src/test/java/Team4_Practice/sinifListesi.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook =WorkbookFactory.create(fis);
        Sheet sayfa1=workbook.getSheet("Sayfa1");
        //satır sayısı ve fiziki kullanılan satır sayısını bulun ve yazdırın
        System.out.println(sayfa1.getLastRowNum());//4
        System.out.println(sayfa1.getPhysicalNumberOfRows());//5
        //3.satır 2.hucreyi degiskene atayıp yazdırın
        String ikinciHucre=sayfa1.getRow(2).getCell(1).toString();
        System.out.println(ikinciHucre);
        //4.satırdaki ogrencinin ulkesinin "Türkiye" oldugunu test edin
        String expectedUlke="Türkiye";
        String actaulUlke=sayfa1.getRow(3).getCell(3).toString();
        Assert.assertEquals(expectedUlke,actaulUlke);
        //Sayfada "Almanya" ülkesinin oldugunu test edin
        boolean flag =false;
        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {
            String ulkeler=sayfa1.getRow(i).getCell(3).toString();
            if (ulkeler.equals("Almanya")){
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);

        // ogrenci adlarını ve sehirlerini map olarak kaydedin
        Map<String,String> isimSehir=new TreeMap<>();
        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {
            String key=sayfa1.getRow(i).getCell(0).toString();
            String value=sayfa1.getRow(i).getCell(2).toString();
            isimSehir.put(key,value);
        }
        System.out.println(isimSehir);
        // sehirler arasında olarak "Gaziantep" oldugunu test edin
        Assert.assertTrue(isimSehir.containsValue("Gaziantep"));
        // 4.hucreye yeni cell olusturun ve "Yas" yazdırın
        sayfa1.getRow(0).createCell(4).setCellValue("Yas");
        //3.satırdaki ogrencinin yasını 17 olarak girin
        sayfa1.getRow(2).createCell(4).setCellValue(17);
        //3.satırdaki ogrencinin yasının 17 oldugunu test edin
        int expectedYas=17;
        int actualYas=(int) sayfa1.getRow(2).getCell(4).getNumericCellValue();
        Assert.assertEquals(expectedYas,actualYas);
        //yapılan degisikleri dosyaya isleyin ve dosyayı kapatın
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();



    }
}
