package day06_assertions_dropdowvMenu;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.security.Key;
import java.time.Duration;
import java.util.Stack;

public class C04_RadioButton {

    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

     static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterAll
    public  static void teardown(){
        driver.quit();

    }
    @Test
    public void yazidanSecimTesti(){

        driver.get(" https://testotomasyonu.com/form");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        WebElement kadinButtonYazisi = driver.findElement(By.xpath("//*[@for='inlineRadio1']"));

     //c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        kadinButtonYazisi.click();

     //   	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(kadinButton.isSelected());
        Assertions.assertFalse(erkekButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusableMethods.bekle(2);

    }
    @Test
    public void butondanSecimTesti(){
        driver.get(" https://testotomasyonu.com/form");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement kadinButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerButton = driver.findElement(By.id("inlineRadio3"));

        kadinButton.click();
        Assertions.assertTrue(kadinButton.isSelected());
        Assertions.assertFalse(erkekButton.isSelected());
        Assertions.assertFalse(digerButton.isSelected());
        ReusableMethods.bekle(2);

    }
}
