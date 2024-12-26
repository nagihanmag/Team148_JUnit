package day06_assertions_dropdowvMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_DropdownMenu extends TestBaseEach {

    @Test
    public void test01(){

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get(" http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();
        //3. Login kutusuna “username” yazin
        WebElement loginBox =driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        //4. Password kutusuna “password” yazin
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        //5. Sign in tusuna basin,

        driver.findElement(By.xpath("//*[@class='btn btn-primary']"))
                .click();

        // back tusuna basarak sayfaya donun
        driver.navigate().back();

        //6. Online banking menusunden
        driver.findElement(By.xpath("//strong[.='Online Banking']"))
                .click();

        //Pay Bills sayfasina gidin

        driver.findElement(By.id("pay_bills_link"))
                .click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency"))
                .click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.id("pc_currency"));
        Select select =new Select(ddm);

        select.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        WebElement amoundKutusu = driver.findElement(By.id("pc_amount"));
        amoundKutusu.sendKeys("50");

        //10. “US Dollars” in secilmedigini test edin

        WebElement dollarsUs = driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assertions.assertFalse(dollarsUs.isSelected());
         ReusableMethods.bekle(2);

        //11. “Selected currency” butonunu secin
        WebElement selectedCurrency = driver.findElement(By.xpath("(//*[@class='radio inline'])[3]"));
        selectedCurrency.click();

        //12. “Calculate Costs” butonuna basin
        WebElement calculateButton = driver.findElement(By.id("pc_calculate_costs"));
        calculateButton.click();

        // sonra “purchase” butonuna basin
        WebElement purchoseButton = driver.findElement(By.id("purchase_cash"));
        purchoseButton.click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin
        WebElement yaziCiktisi = driver.findElement(By.id("alert_content"));

        //String expectedYazi ="Foreign currency cash was successfully purchased.";
       // String actualYazi = driver.getCurrentUrl();
        Assertions.assertTrue(yaziCiktisi.isDisplayed());

        ReusableMethods.bekle(2);


    }
}
