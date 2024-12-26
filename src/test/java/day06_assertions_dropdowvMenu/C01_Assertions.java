package day06_assertions_dropdowvMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {
    int a =10;
    int b = 20 ;
    int c = 30 ;
    String url1="https://www.testotomasyonu.com";
    String url2="https://www.testotomasyonu.com/";

    /*
      assertEquals(a,b) ile assertTrue(a==b)
        eger assertion PASSED olursa yukardaki method'lar arasinda hic bir fark yoktur

        ANCAAAKKK assertion FAILED oldugunda
        assertEquals(a,b) expected (a) ve actual (b) degerlerini karsilastirip
        aradaki farki otomatik olarak bize gosterir

        ama assertTrue(a==b) kullanildiginda
        sadece true bekliyorduk false oldu der

        Bu sebeple MUMKUN OLDUGU surece assertEquals() kullanmayi tercih ederiz

     */

    @Test
    public void test01(){


        // c'nin a ile b'nin toplamina esit oldugunu test edin

        Assertions.assertEquals(c,a+b);
        Assertions.assertTrue(c==a+b);

    }

    @Test
    public void test02(){

        Assertions.assertEquals(b,a+c);
        //Expected :20
        //Actual   :40


    }
    @Test
    public void test03(){
        Assertions.assertTrue(b==a+c);
        //Expected :true
        //Actual   :false


    }
    @Test
    public void test04(){
        // url1 ve url2 nin ayni oldugunu tets edin

        //Expected :https://www.testotomasyonu.com
        //Actual   :https://www.testotomasyonu.com/


    }
    @Test
    public void test05(){
        // url1 ve url2 nin ayni oldugunu tets edin
        Assertions.assertTrue(url1.equals(url2));
        //Expected :true
        //Actual   :false

    }
    @Test
    public void  test06(){
        //url1'in "best" kelimasini icermedigini test edin

        // if (!url1.contains("best")){
        //            System.out.println("Best testi PASSED");
        //        }else System.out.println("Best testi FAILED");

        Assertions.assertFalse(url1.contains("best"));

        Assertions.assertTrue(!url1.contains("best"));
        //'assertTrue()' can be simplified to 'assertFalse()'





    }
}
