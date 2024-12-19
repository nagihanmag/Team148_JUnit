package day04_mavenProjeKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_OzelWebDriverVerilirse {

    public static void main(String[] args) {
        //Sirket tarafindan verilen Webdriver'i kullanarak asagidaki testi yapin

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu sayfasina gidin

        driver.get("https://www.testotomasyonu.com");


        //phone icin arama yapin

        WebElement aramaKutusu =driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        //ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();




        //acilan ilk urun sayfasindaki urun isminde
        //case sensetive olmadan " phone " gectigini test ediniz

        WebElement ilkUrunIsimElemnti =driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsim = ilkUrunIsimElemnti.getText().toLowerCase();//case sensetive olmamamsi icin

        if (actualUrunIsim.contains(expectedUrunIsimIcerik)){
            System.out.printf("Ilk urun isim testi PASSED");
        }else System.out.printf("Ilk urun isim icerigi FAILED");



        // sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();

    }
}
