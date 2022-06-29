package tests;

import Pages.TradylinnPages1;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

public class US_015 {
    TradylinnPages1 tradyLinn=new TradylinnPages1();
    Actions action=new Actions(Driver.getDriver());
    SoftAssert soft=new SoftAssert();
    Faker faker=new Faker();

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        // User goes to tradylinn.com
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        //        User clicks "Giriş Yap"
        tradyLinn.girisyap.click();
        //        User enters email
        tradyLinn.email.sendKeys(ConfigReader.getProperty("userMail"));
        //        User enters password
        tradyLinn.password.sendKeys(ConfigReader.getProperty("userPassword"));
        //        User clicks "Giriş Yap" button
        tradyLinn.login.click();
        //        User clicks "Hesabım"
        //bekleme suresi
        Thread.sleep(3000);
        tradyLinn.hesabim.click();
        //        User clicks "Store Manager"
        tradyLinn.storeManager.click();
        //User"Kuponlar" butonundan "Yeniekle" secenegini tiklar
        tradyLinn.Kuponlar.click();
        // User "Yeni kupon ekle "secenegini tikla
        tradyLinn.yeniKuponEkle.click();
    }
    @Test
    public void Limit(){
        //1)User clicks "Limit"
        tradyLinn.limit.click();
        //2)User "Usage limit per coupon" limit girmeli
        Random rnd=new Random();
        int random= rnd.nextInt(4);
       tradyLinn.usageLimitPerCoupon.sendKeys(" "+random+" ");
        //3)User "Limit usage to X items" sinirlama getirilmeli
        int random1= rnd.nextInt(6);
        tradyLinn.limitUsageToXItems.sendKeys(" "+random1+" ");
        //4)User "Usage limit per user"kullanici basina limit gir
        int random2= rnd.nextInt(3);
        tradyLinn.usageLimitPerUser.sendKeys( " "+random2+" ");
        //5)User "Vendor "SUBMİT" butonuna tiklar
        tradyLinn.submit.click();
        //"6)User"Coupon Successfully Published." yazisinin görünüyor oldugunu test eder"
        String expectedWord="Coupon Successfully Published.";
        String actualYazi=tradyLinn.codeTextbox.getText();
        soft.assertTrue(expectedWord.equals(actualYazi));
        soft.assertTrue(tradyLinn.CouponSuccessfullyPublished.isDisplayed());

    }
}
