package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_iFrame extends TestBaseEach {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur oldugunu test edin
        /*
        electronics yazisini locate etmemize ragmen kullanamadik
        HTML kodlari inceleyince kullanmak istedigimiz webelementin
        bir iframe(gomulu HTML sayfa) icerisinde oldugunu belirledik
        bir iframe icerisindeki bir elementi kullanabilmek icin once o
        iframe gecis yapmamiz gerekir
         */


        WebElement electronicsIframeElementi =
                driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(electronicsIframeElementi);


        WebElement electronicsProductsYaziElementi=
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement dellElementi = driver.findElement(By.id("pictext1"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin

          /*
        iframe icine gecis yapinca biz driveri oradan cikarincaya kadar
        driver iframe'in icinde kalir
        driver'i icinde oldugu iFrame'den cikarmak icin
         */

        //(ONEMLI)
        //driver.switchTo().parentFrame();

        /*
          ic ice birden fazla katman olarak iFrame'ler varsa
         bir ust katman'a cikartir
         */

       driver.switchTo().defaultContent();
       /*
          ic ice birden fazla katman olarak iFrame'ler varsa
         direk anasayfaya cikartir

        */

        WebElement saleYazisi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));
        Assertions.assertTrue(saleYazisi.isDisplayed());

        //5- Fashion bolumundeki ilk urun isminde "Men Slim Fit" gevtigini test  edin
        /*
           fashion bolumu ayri bir IFrame icerisinde oldugundan , once o iFrame'e gecis yapmaliyiz
         */
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIframe);
        WebElement fashionIlkElement = driver.findElement(By.xpath("(//*[@class='overlay'])[1]"));

        /* bu xpath 3 element bulabiliyor
        ANNCAAAKKK biz fashion iframe icinde oldugumuzdan
        o iframe icinde olan tek bir elementi bize getirir

         */

        //ve urun isminde  "Men Slim Fit " gectigini test edin


        String expectedIsimIcerik = "Men Slim Fit";
        String actualIsim = fashionIlkElement.getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));


        ReusableMethods.bekle(3);

    }

}
