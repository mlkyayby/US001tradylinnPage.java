package tests;

import Pages.TradyLinnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class US_005 extends TestBaseRapor {
    TradyLinnPages trd=new TradyLinnPages();
    Actions action=new Actions(Driver.getDriver());
    SoftAssert soft=new SoftAssert();
    @BeforeTest
    public void extentReports(){
        extentTest=extentReports.createTest("E2E","stepConfigration");
    }

    @Test
    public void TC01DisableProductList() throws InterruptedException {
        //extentTest=extentReports.createTest("E2E","stepConfigration");
        // User goes to tradylinn.com
        extentTest.info("User goes to tradylinn.com");
          Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        //        User clicks "Giriş Yap"
        extentTest.info("User clicks \"Giriş Yap\"");
         trd.girisyap.click();
        //        User enters email
        extentTest.info("User enters email");
        trd.email.sendKeys(ConfigReader.getProperty("userMailOrtak"));
        //        User enters password
        extentTest.info("User enters password");
        trd.password.sendKeys(ConfigReader.getProperty("userPasswordOrtak"));
        //        User clicks "Giriş Yap" button
        extentTest.info("User clicks \"Giriş Yap\" button");
        trd.login.click();
        //        User clicks "Hesabım"
        Thread.sleep(5000);
        extentTest.info("User clicks \"Hesabım\"");
        trd.hesabim.click();
        //        User clicks "Store Manager"
        extentTest.info("User clicks \"Store Manager\"");
        trd.storeManager.click();
        //        User clicks "Ürün"
        extentTest.info("User clicks \"Ürün\"");
        trd.choiceContainsElement(trd.myStoreMenu,"Ürün").click();
        //        User scrolls down the page
        extentTest.info("User scrolls down the page");
        action.sendKeys(Keys.DOWN).perform();
        //        User verifies status, stock, price, date column head if displayed
        extentTest.pass("User verifies status, stock, price, date column head if displayed");
        List<String> arr= Arrays.asList("Status","Stock","Price","Date");
        Thread.sleep(5000);
        for(int i=0;i< arr.size();i++){
          soft.assertTrue(trd.choiceElement(trd.tableList, arr.get(i)).isDisplayed());
        }
    }
    @Test (priority = 2)
    public void TC02AddNew(){
        //extentTest=extentReports.createTest("E2E","stepConfigration");
        //  User clicks "Yeni ekle" button
        extentTest.info("User clicks \"Yeni ekle\" button");
        trd.addNewProduct.click();
        //  User verifies "Virtual" checkbox is displayed
        extentTest.pass("User verifies \"Virtual\" checkbox is displayed");
        soft.assertTrue(trd.virtualCheckBox.isDisplayed());
        // User click "virtual" checkbox
        extentTest.info("User click \"virtual\" checkbox");
        trd.virtualCheckBox.click();
        //   User verifies "Downloadable" checkbox is displayed
        extentTest.pass("User verifies \"Downloadable\" checkbox is displayed");
        soft.assertTrue(trd.dowloadablecheckBox.isDisplayed());
        // User click "virtual" checkbox
        extentTest.info("User click \"virtual\" checkbox");
        trd.dowloadablecheckBox.click();
    }
    @Test (priority = 3)
    public void TC03UrunEkle(){
       // extentTest=extentReports.createTest("E2E","stepConfigration");
        //User enters "Product Name"
        extentTest.info("User enters \"Product Name\"");
        trd.productName.sendKeys("Hasortman");
        //User enters "Sale Price"
        extentTest.info("User enters \"Sale Price\"");
        action.click(trd.productName).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("70").perform();
    }  @Test(priority = 4)
    public void TC04() throws InterruptedException, AWTException {
        // User clicks photo icon
        extentTest.info("User clicks photo icon");
           trd.photo.click();
        // User clicks "Dosya Seçin" button
        extentTest.info("User clicks \"Dosya Seçin\" button");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,200)");
        trd.uploadFile.click();
        Thread.sleep(2000);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("\"C:\\Users\\himer\\OneDrive\\Masaüstü\\hasortman.jpg\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        // User selects product photo and click open button

        // User waits for uploading file
        extentTest.info("User waits for uploading file");
        Thread.sleep(10000);
        // User clicks "ADD TO GALLERY" button
        extentTest.info("User clicks \"ADD TO GALLERY\" button");
        trd.sec.click();
    }
    @Test(priority = 5)
    public void TC05Description(){
        // short description
        extentTest.info("User fill in short description in textarea");
        Driver.getDriver().switchTo().frame(trd.iframe);
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        trd.description.sendKeys("Ürün Özelliği\n" +
                "\n" +
                "   S-M Bel 29 cm Boy 93 cm\n" +
                "  M-L Bel 30 cm Boy 95 cm\n" +
                " (Ürün Ölçüleri 1-2 cm farklılık gösterebilir.)\n");
        Driver.getDriver().switchTo().defaultContent();
        //description
        extentTest.info("User fill in long description in textarea");
        Driver.getDriver().switchTo().frame(trd.iframe2);
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        trd.description.sendKeys("Şık ve hoş görünümlü eşofmanlar ile tüm dikkatleri üzerinde olacak. Kalıpları normaldir.\n" +
                "\n" +
                "İstediğin gibi kombinle bütün gözler senin üzerinde olsun.\n" +
                "\n" +
                "Birbirinden Farklı Renk Ve Modelleriyle Kendine Uygun Olanı\n" +
                "\n" +
                "Al-Giy Ve Çık .\n");
        Driver.getDriver().switchTo().defaultContent();

    }
    @Test (priority = 6)
    public void US_006_TC01AssertDisplayedCategories () throws InterruptedException {
        //User scrol down page for make visible to categories
        extentTest.info("User scrol down page for make visible to categories");
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        //User verifies product categories are displayed
        Thread.sleep(5000);
        extentTest.pass("User verifies product categories are displayed");
         boolean ifdisplayedAllmatch=trd.categories.stream().allMatch(t->t.isDisplayed());
         soft.assertTrue(ifdisplayedAllmatch);
    }
    @Test (priority = 7)
    public void US_006_TC02selectproductCategoriesRandomly (){
        //User selects "Product Categories"
        extentTest.info("User selects \"Product Categories\"");
        Random rnd=new Random();
        for(int i=0;i<5;i++){
            int random= rnd.nextInt(trd.categories2.size()-1);
            System.out.println(random);
            trd.categories2.get(random).click();
        }
    }

    @Test (priority = 8)
    public void US_007_TC01ProductBrandDisplayed () throws InterruptedException {
        // user scroll down page for make visible to categories
        extentTest.info("user scroll down page for make visible to categories");
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        //User verifies product categories are displayed
        int x=5;
        Thread.sleep(5000);
        extentTest.pass("User verifies product categories are displayed");
        boolean ifdisplayedAllmatch=trd.productBrand.stream().allMatch(t->t.isDisplayed());
        Thread.sleep(5000);
        soft.assertTrue(ifdisplayedAllmatch);
        soft.assertAll();
    }
     @Test(priority = 9)
    public void US_007_TC02ProductBrandChoices(){
         //User selects "Product Categories"
         extentTest.info("User selects \"Product Categories\"");
         Random rnd=new Random();
         for(int i=0;i<5;i++){
             int random= rnd.nextInt(trd.productBrand.size()-1);
             System.out.println(random);
             trd.productBrand.get(random).click();
            // Driver.closeDriver();
         }
     }
}
