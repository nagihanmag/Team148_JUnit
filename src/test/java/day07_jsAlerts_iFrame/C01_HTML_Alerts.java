package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_HTML_Alerts extends TestBaseEach {

    @Test
    public void test01(){
        //google.com anasayfaya gidin
        driver.get("https://www.google.com");

        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//div[text()='Accepall']"))
                .click();
        ReusableMethods.bekle(1);
    }



}
