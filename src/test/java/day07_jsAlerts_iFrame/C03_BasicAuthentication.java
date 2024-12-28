package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

public class C03_BasicAuthentication extends TestBaseEach {

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //

        // driver.get("https://testotomasyonu.com/basicauth");
        // sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
        // ancak otomasyon ile gittigimizde
        // kullanici adi ve sifresi bolumunu locate edemedigimizden kullanamayiz
        // bunun yerine kullandigimiz url'in sahibi olan sirketin
        // bize verecegi kullanici adi ve sifresini
        // yine sirketin bize tarif edecegi yontemle URL'e eklemeliyiz
    }
}
