package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists {
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/download
        //"C:\Users\HP\Downloads\avatar.png"
        //C:\Users\PC\Downloads
        //C:\Users\Monster\Downloads\avatar.png

        /*
        bir dosyanın pc mizde oldugunu test etmek cok kolaydır
        Ancak testimizin dinamik olmasını saglamak icin yani hangi pc de  calıstırılırsa calıstırılsın
        dosya yoluyla calısmak gerekir
         */
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\HP\\Downloads\\avatar.png")));

    }
    @Test
    public void dinamikTest(){
        //"C:\Users\HP\Downloads\avatar.png"
        //C:\Users\PC\Downloads
        //C:\Users\Monster\Downloads\avatar.png

        //Javada dosya yolunu bize veren 2 tane kod var

        //1- calıstıgımız klasorun dosya yolunu almak istersek
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\HP\Desktop\team116_JUnit
        //"C:\Users\HP\Desktop\team116_JUnit\src\test\java\tests\day09_actions_fileTestleri\C05_FileExists.java"

        //2- pc nin ana dosya yolu
        System.out.println(System.getProperty("user.home"));
        //C:\Users\HP
        /*
        indirdigimiz dosyanın dinamik dosya yolunu elde etmek istersek
        iki parcada elde edebiliriz
         */
        String dinamikDosyaYolu=System.getProperty("user.home")+ "\\Downloads\\avatar.png";
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }
}
