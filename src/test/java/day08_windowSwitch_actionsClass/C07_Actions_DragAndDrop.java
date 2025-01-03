package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_Actions_DragAndDrop extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");


        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);

        WebElement acceptableButonu = driver.findElement(By.xpath("//*[.='Acceptable']"));
        WebElement dropHereButonu = driver.findElement(By.xpath("//*[.='Drop Here']"));

        actions.dragAndDrop(acceptableButonu,dropHereButonu).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYaziElementi ="Dropped!";
        String actualYaziElementi = driver.findElement(By.id("droppable2")).getText();

        Assertions.assertEquals(expectedYaziElementi,actualYaziElementi);


        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(3);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElementi = driver.findElement(By.xpath("//*[.='Not Acceptable']"));
        dropHereButonu = driver.findElement(By.xpath("//*[.='Drop Here']"));

        actions.dragAndDrop(notAcceptableElementi,dropHereButonu).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        expectedYaziElementi = "Drop Here";
        actualYaziElementi = dropHereButonu.getText();
        Assertions.assertEquals(expectedYaziElementi,actualYaziElementi);


        ReusableMethods.bekle(3);
    }
}
