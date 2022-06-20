package Tests;

import Pages.TradyLinnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_005 {
    TradyLinnPages trd=new TradyLinnPages();
    Actions action=new Actions(Driver.getDriver());
    SoftAssert soft=new SoftAssert();
    @Test
    public void TC01DisableProductList() throws InterruptedException {
        // User goes to tradylinn.com
          Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        //        User clicks "Giriş Yap"
         trd.girisyap.click();
        //        User enters email
        trd.email.sendKeys(ConfigReader.getProperty("userMail"));
        //        User enters password
        trd.password.sendKeys(ConfigReader.getProperty("userPassword"));
        //        User clicks "Giriş Yap" button
        trd.login.click();
        //        User clicks "Hesabım"
        //ReusableMethods.waitForClickablility(trd.hesabim,10);
        Thread.sleep(5000);
        trd.hesabim.click();
        //        User clicks "Store Manager"
        trd.storeManager.click();
        //        User clicks "Ürün"
        trd.choiceContainsElement(trd.myStoreMenu,"Ürün").click();
        //        User scrolls down the page
        action.sendKeys(Keys.DOWN).perform();
        //        User verifies status, stock, price, date column head if displayed
        List<String> arr= Arrays.asList("Status","Stock","Price","Date");
        for(int i=0;i< arr.size();i++){
          soft.assertTrue(trd.choiceElement(trd.tableList, arr.get(i)).isDisplayed());
        }
    }
    @Test (priority = 2)
    public void TC02AddNew(){
        //  User clicks "Yeni ekle" button
        trd.addNewProduct.click();
        //  User verifies "Virtual" checkbox is displayed
        soft.assertTrue(trd.virtualCheckBox.isDisplayed());
        // User click "virtual" checkbox
        trd.virtualCheckBox.click();
        //   User verifies "Downloadable" checkbox is displayed
        soft.assertTrue(trd.dowloadablecheckBox.isDisplayed());
        // User click "virtual" checkbox
        trd.dowloadablecheckBox.click();
    }
    @Test (priority = 3)
    public void TC03UrunEkle(){
        //User enters "Product Name"
        trd.productName.sendKeys("Bursa'daki Kaynana cinayetlerinin sirlari");
        //User enters "Sale Price"
        action.click(trd.productName).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("70").perform();
    }  @Test(priority = 4)
    public void TC04() throws InterruptedException, AWTException {
        // User clicks photo icon
           trd.photo.click();
        // User clicks "Dosya Seçin" button
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,200)");
        trd.uploadFile.click();
        Thread.sleep(2000);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("C:\\Users\\himer\\OneDrive\\Masaüstü\\kaynana.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        // User selects product photo and click open button

        // User waits for uploading file
        Thread.sleep(5000);
        // User clicks "ADD TO GALLERY" button
        trd.sec.click();
    }
    @Test(priority = 5)
    public void TC05Description(){
        //Driver.getDriver().switchTo().frame(trd.iframe);
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
      Driver.getDriver().findElement(By.xpath("//*[@id=\"excerpt\"]")).sendKeys("kvjfjfjjgjgjgjgjhjhjhjhjhjjn");
    }
    @Test (priority = 6)
    public void US_006_TC01 (){

    }

}
