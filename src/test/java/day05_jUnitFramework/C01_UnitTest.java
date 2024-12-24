package day05_jUnitFramework;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class C01_UnitTest {
    public static void main(String[] args) {


        // verilen bir tam sayiyi kontrol edip
        //  3 pozitif bir tam sayi degilse " false"
        // 3 basamakli bir tam sayi ise "true" donduren bir method olusturun
      sayiKontrolMethodunuTestMethodu();


    }

    public static boolean sayiKontrol(int sayi) {

        if (sayi>= 100 && sayi<= 999) {
            return true;
        } else return false;


    }

    // sayiKontrol()' unun dogru calisip calismadigini kontrol ediniz
    //bir test method'u olusturun


    public static void sayiKontrolMethodunuTestMethodu() {
        Random random = new Random();
        boolean testSonucu = true;

        //  true dondurmesi gereken 10 degeri test edin
        for (int i = 1; i <= 10; i++) {

            int randomSayi = 100 + random.nextInt(899);
            if (sayiKontrol(randomSayi) == false){ // urettigimiz sayilar 100-999 arasinda ve
                                                   // sayikontrol methodu true dondurmeliydi
                                                   // demekki sayikontrol method'u dogru calismiyor

                testSonucu = false;
            }

        }

        if (testSonucu== true){
            System.out.println(" 10 farkli sayi uretildi ve method kontrol testi PASSED");
        }else System.out.println("sayiKontrol method'u dogru calismiyor , Test FAILED");


        }

    }


