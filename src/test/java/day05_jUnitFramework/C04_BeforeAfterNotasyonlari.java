package day05_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_BeforeAfterNotasyonlari {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        //Webdriver olusturupayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test @Disabled  // calistirmaz
    public   void  testOtomasyonuTest(){
        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //url'nin testotomasyonu icerdigini test edin
        String expectedUrlIcerik ="testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomastonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");





    }

    @Test
    public   void  youtubeOtomasyonuTest(){
        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        //url'nin youtube icerdigini test edin
        String expectedUrlIcerik ="youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");



    }

    @Test
    public   void  wisequarterTest(){
        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //url'nin wisequarter icerdigini test edin
        String expectedUrlIcerik ="wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarte testi FAILED");



    }
}
