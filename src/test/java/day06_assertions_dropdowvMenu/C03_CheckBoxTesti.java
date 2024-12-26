package day06_assertions_dropdowvMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckBoxTesti {
    //a. Verilen web sayfasına gidin.
    //https://testotomasyonu.com/form
    //b. Sirt Agrisi ve Carpinti checkbox’larini secin
    //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
    //olduğunu test edin
    //d. Seker ve Epilepsi checkbox’larininin seçili
    //olmadigini test edin\

    WebDriver driver ;

    @BeforeEach
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    public void teardown(){
        driver.quit();

    }
    @Test
    public void checkBoxTesti(){
        //a. Verilen web sayfasına gidin.
        //https://testotomasyonu.com/form
        Actions actions = new Actions(driver);
        actions.sendKeys((Keys.PAGE_DOWN)).perform();




        driver.get("https://testotomasyonu.com/form");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        Actions actions1 = new Actions(driver);
        actions1.sendKeys((Keys.PAGE_DOWN)).perform();
        Actions actions2 = new Actions(driver);
        actions2.sendKeys((Keys.PAGE_DOWN)).perform();




        //b. Sirt Agrisi ve Carpinti checkbox’larini secin

        WebElement sirtaAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
                sirtaAgrisiCheckBox.click();

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.click();

        //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
        //olduğunu test edin

        Assertions.assertTrue(sirtaAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());
        ReusableMethods.bekle(2);

        Actions actions4 = new Actions(driver);
        actions4.sendKeys(Keys.PAGE_DOWN).perform();

        //d. Seker ve Epilepsi checkbox’larininin seçili
        //olmadigini test edin\

        WebElement sekerCheckBox =driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox =driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());



        ReusableMethods.bekle(2);
        driver.quit();

    }
}
