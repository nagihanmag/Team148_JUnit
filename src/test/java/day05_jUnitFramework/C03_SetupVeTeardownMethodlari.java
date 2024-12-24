package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_SetupVeTeardownMethodlari {
    /*
    Java da tekrar eden kodlari sevmeyiz

    Bir test methodu olusturuldugun da basta olusturmamiz gereken driver objesi
    ve sondaki kapatma islemi tum methodlar icin lazimdir

    Her test methodun da bunlari tekrar tekrar olusturmak yerine method yapip
    methodCall ile kullanmayi tercih edebiliriz
     */
    WebDriver driver;

    public void setup(){
        //Webdriver olusturupayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test

    public   void  testOtomasyonuTest(){
        setup();

        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //url'nin testotomasyonu icerdigini test edin
        String expectedUrlIcerik ="testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomastonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");

        teardown();



    }
    @Test

    public   void  youtubeOtomasyonuTest(){

       setup();

        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        //url'nin youtube icerdigini test edin
        String expectedUrlIcerik ="youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");


      teardown();
    }
    @Test

    public   void  wisequarterTest(){

      setup();

        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //url'nin wisequarter icerdigini test edin
        String expectedUrlIcerik ="wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarte testi FAILED");


        teardown();
    }
}
