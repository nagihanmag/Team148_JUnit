package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi ="Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle =driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        ReusableMethods.bekle(3);

        String ilkWindowWhd = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        ReusableMethods.bekle(3);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println("Click here'a bastiktan sonra title : " + driver.getTitle());

        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz
         */
        Set<String> tumWhdSeti = driver.getWindowHandles();
        System.out.println("Ilk windowu'un whd :"+ ilkWindowWhd);
        System.out.println("tum window handle degerleri seti:"+tumWhdSeti);
        String ikinciWindowHandle= "";

        for (String each:tumWhdSeti){
            if (!each.equals(ilkWindowWhd)){
                System.out.println("Ikinci Window Handle Degeri :"+ each);
                ikinciWindowHandle =each;
            }

        }
        driver.switchTo().window(ikinciWindowHandle);
        System.out.println("Bulmaca cozdukten sonra title:"+driver.getTitle());


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        yaziElementi = driver.findElement(By.tagName("h3"));
        expectedYazi= "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        //  “The Internet” olduğunu test edin

        driver.switchTo().window(ilkWindowWhd);
        expectedTitle= "The Internet";
        actualTitle= driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);





    }
}
