package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

}
