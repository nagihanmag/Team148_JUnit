package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_jsAlerts extends TestBaseEach {

    // 3 tane test methodu olusturup asagidaki gorevleri tamamlayiniz

     /*
        Bir webelement'e click yaptigimizda
        driver objesi ortam degisikligi beklemez

        ayni window'da kalip, farkli bir url'e gitmeyi bekler

        ANCAAKKKK bazi islemler yapildiginda
        farkli bir ortam olusabilir

        driver'i bu farkli ortama gecirmek icin
        driver.switchTo() kullanmamiz gerekir

        Bu durumlardan birisi JavaScript alert'lerdir.
        JsAlert calistiginda normal window uzerinde islem yapamayiz
        sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz

        driver'in jsAlert'e gecmesi ve orada islem yapabilmesi icin
        oncelikle jsAlert evrenine switch yapmasi gerekir
     */

    @Test
    public void jsAlerts(){

        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get(" https://testotomasyonu.com/javascriptAlert");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String exoectedAllertYazisi = "I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assertions.assertEquals(exoectedAllertYazisi,actualAlertYazisi);

        //- OK tusuna basip alert'i kapatin

        driver.switchTo()
                .alert()
                .accept();




    }
    @Test
    public void jsConfirmTest(){
        //2.Test
        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //- Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();



        // cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazisi ="You clicked: Cancel";

        WebElement sonucYazisiElementi =driver.findElement(By.id("result"));

        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(2);



    }
    @Test
    public void jsPrompTest(){//3.Test
        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get(" https://testotomasyonu.com/javascriptAlert");
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        ReusableMethods.bekle(2);

        //- Cikan prompt ekranina "Abdullah" yazdirin

        driver.switchTo().alert().sendKeys("Abdullah");


        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        Actions actions1 =new Actions(driver);
        actions1.sendKeys(Keys.PAGE_DOWN).perform();


        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucYaziIcerigi =" Abdullah";
        WebElement sonucYazisiElementi =driver.findElement(By.id("result"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));


    }
}
