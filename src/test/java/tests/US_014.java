package tests;

import Pages.TradylinnPages1;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class US_014 {
    TradylinnPages1 tradyLinn=new TradylinnPages1();
    Actions action=new Actions(Driver.getDriver());
    SoftAssert soft=new SoftAssert();
    Faker faker=new Faker();
    @BeforeTest
            public void BeforeTest() throws InterruptedException {
        // User goes to tradylinn.com
        Driver.getDriver().get(ConfigReader.getProperty("trandylinnUrl"));
        //        User clicks "Giriş Yap"
        tradyLinn.girisyap.click();
        //        User enters email
        tradyLinn.email.sendKeys(ConfigReader.getProperty("vendorValidMail"));
        //        User enters password
        tradyLinn.password.sendKeys(ConfigReader.getProperty("vendorValidPassWord"));
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
    }
    @Test
    public void TC01Kuponlar() throws InterruptedException {
        // User "Yeni kupon ekle "secenegini tikla
        tradyLinn.yeniKuponEkle.click();
        //User "Code" satirina uniq bir deger girerek Enter'a tıklar
        tradyLinn.codeTextbox.sendKeys(faker.internet().password());
        //User "submit"butonuna basar
        tradyLinn.submit.click();

        }
        @Test
    public void Restriction(){
             action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        //User "Minimum spend" secenegine en fazla alma miktarini girer
            tradyLinn.minimumSpend.sendKeys("200");
            //User "Maximum spend" secenegine en az alma miktarini girer
            tradyLinn.maximumSpend.sendKeys("500");

            //User "Individual use only"secenegini isaretler
            tradyLinn.individualUseOnly.click();
            //User "Exclude sale items"secenegini isaretle
            tradyLinn.excludeSaleItems.click();
            //User "Exclude categories"dan random bir kategori secer
            Random rnd=new Random();
            Select select=new Select(tradyLinn.excludeCategories);
            select.getOptions();
            List<WebElement> list=select.getOptions();
            int random= rnd.nextInt(list.size()-1);
            list.get(random).click();

            //User "submit"butonuna basar
            tradyLinn.submit.click();
            //User "Coupon Successfully Published." yazisinin görünüyor oldugunu test eder.
            String expectedWord="Coupon Successfully Published.";
            String actualYazi=tradyLinn.codeTextbox.getText();
            soft.assertTrue(expectedWord.equals(actualYazi));
            soft.assertTrue(tradyLinn.codeTextbox.isDisplayed());

        }

}
