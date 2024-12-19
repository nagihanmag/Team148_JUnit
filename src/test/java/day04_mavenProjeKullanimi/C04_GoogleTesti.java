package day04_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleTesti {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.google.com/ adresine gidin

        driver.get(" https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
       // driver.findElement(By.xpath("//div[.='Accept all']"))
        //.click(); bu kisim bende cikmadigi icin yoruma aldim



        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.printf("Title testi PASSED");
        }else System.out.printf("Title testi FAILED");


        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaCubugu = driver.findElement(By.xpath("//textarea[@name='q']"));
        aramaCubugu.sendKeys("Nutella"+ Keys.ENTER);


        //6- Sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();
    }
}
