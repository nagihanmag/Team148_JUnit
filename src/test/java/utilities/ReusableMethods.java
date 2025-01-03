package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public  static  void  bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.printf("Thread.sleep calismadi");
        }
    }

    public  static List<String>stringListeyeDonustur(List<WebElement>webElementList){

        List<String>tumLIsteStr = new ArrayList<>();

        for (WebElement eacgBaslik:webElementList){
            tumLIsteStr.add(eacgBaslik.getText());
        }
        return tumLIsteStr;
    }

    public static void urlIleWindowDegistir(WebDriver driver, String hedefUrl){
        Set<String> tumWindowWhdSeti =driver.getWindowHandles();


        for (String eachWhd:tumWindowWhdSeti){
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }
        }
    }

    public static void titleIleWindowDegistir(WebDriver driver, String hedefTitle){
        Set<String> tumWindowWhdSeti =driver.getWindowHandles();


        for (String eachWhd:tumWindowWhdSeti){
            driver.switchTo().window(eachWhd);

            if (driver.getTitle().equals(hedefTitle)){
                break;
            }
        }
    }

}
