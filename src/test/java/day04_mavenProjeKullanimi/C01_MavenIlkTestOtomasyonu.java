package day04_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTestOtomasyonu {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Test otomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");



        // phone icin arama yapin

        WebElement aramaKutusu =driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);




        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanElementleriList =driver.findElements(By.className("prod-img"));


        if (bulunanElementleriList.size()>0){
            System.out.printf("Urun arama testi PASSED");
        }else System.out.printf("Urun arama testi FAILED");



        //sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();


    }
}
