package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C02_TestNotasyonu {
    /*
    @Test notasyonu siradan bir method'u tek basina Run edilebilir hale getirir.

    @Test notasyonu sayersinde her bir
    testi bagimsiz olarak calistirabilicegimiz gibi class isminin yanindaki run tusu ile
    class'daki TUM test methodlarini toplu olarakda calistirabiliriz

    JUnit @Test method'larinin calisma sirasini kendine gore duzenler
    belirlenmis bir siralama duzeni yoktur
    siralamayi ongoremeyiz ve kontrol edemeyiz

    Eger sirali calismasini istediginiz test methodlari olursa
    isimlarini test01, test02, test03 diye belirlemek gerekir

     */

    @Test

    public   void  testOtomasyonuTest(){

        //Webdriver olusturupayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //url'nin testotomasyonu icerdigini test edin
        String expectedUrlIcerik ="testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomastonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");


        driver.quit();
    }
    @Test

    public   void  youtubeOtomasyonuTest(){

        //Webdriver olusturupayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        //url'nin youtube icerdigini test edin
        String expectedUrlIcerik ="youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");


        driver.quit();
    }
    @Test

    public   void  wisequarterTest(){

        //Webdriver olusturupayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //url'nin wisequarter icerdigini test edin
        String expectedUrlIcerik ="wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarte testi FAILED");


        driver.quit();
    }


}
