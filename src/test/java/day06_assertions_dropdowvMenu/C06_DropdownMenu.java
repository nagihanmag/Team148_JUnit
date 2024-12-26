package day06_assertions_dropdowvMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.ArrayList;
import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/form adresine gidin.

        driver.get("https://testotomasyonu.com/form");

        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        /*
        DropDown menuyu kullanabilmek icin
        1. adim olarak dropdown menuyu locate edip, bir webelement olarak class'a kaydedelim
         */
        WebElement gunDdm =driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        /*
        2. adim bir select objesi olusturun ve
        parametre olarak dropdown menuyu girin
         */
        Select selectGun = new Select(gunDdm);

        /*
        3.adim olusturdugumuz selectGun objesi sayesinde
        select class'indaki hazuir methodlar ile
        istenen islemleri yappabiliriz
         */
        selectGun.selectByIndex(5);


        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement ayDdm =driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectay = new Select(ayDdm);
        selectay.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm =driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectyil = new Select(yilDdm);
        selectyil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin

        // System.out.println(selectGun);// org.openqa.selenium.support.ui.Select@87083425
        // System.out.println(selectGun.toString()); // org.openqa.selenium.support.ui.Select@9f8b5914
        System.out.println(selectGun.getFirstSelectedOption().getText()); // 5
        System.out.println(selectay.getFirstSelectedOption().getText()); // Nisan
        System.out.println(selectyil.getFirstSelectedOption().getText()); // 1990

        // Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement>ayDdmOptionElementList = selectay.getOptions();
        for (WebElement eachElement :ayDdmOptionElementList){

            System.out.println(eachElement.getText());

        }
        // ay dropdown menusunde "Ocak" degerinin bulundugunu test edin
        //1. yontem
        String expectedAyIcerik = "Ocak";
        String actualAyIcerik= ayDdm.getText();
        System.out.println("actualAyIcerik:"+ actualAyIcerik);
        Assertions.assertTrue(actualAyIcerik.contains(expectedAyIcerik));//1.yontem : dropdown uzerinden olusturdugumuz selectAy.getText()
        //           menudeki tum ay isimlerini getirir


        //2. yontem  tum opsiyonlarin yazilarini olusturdugumuz
        //                   String bir listeye ekleyebiliriz
        //                    sonra list.contains() ile testimizi yapabiliriz
        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eachBaslik: ayDdmOptionElementList){

            tumListeStr.add(eachBaslik.getText());
        }

        String expectedBaslikIsmi = "Ocak";

        Assertions.assertTrue(tumListeStr.contains(expectedBaslikIsmi));

        // 3.yontem ReusableMethods class'indaki method'u kullanalim

        List<String> ayDropdownMenuMetinleri = ReusableMethods.stringListeyeDonustur(ayDdmOptionElementList);
        Assertions.assertTrue(ayDropdownMenuMetinleri.contains("Ocak"));

        // Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedDropDownBoyutu =13;
        int actualDropDownBoyutu = ayDdmOptionElementList.size();

        Assertions.assertEquals(expectedDropDownBoyutu,actualDropDownBoyutu);

        ReusableMethods.bekle(5);

    }


}
