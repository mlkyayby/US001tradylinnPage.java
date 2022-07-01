package tests;

import Pages.US03_4_Page;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.US03_4_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US_003 {
    //1- "https://tradylinn.com/wp-admin" adresine gidiniz
    //2- giris yap linkine tiklayin
    //3- gecerli mail adresi ve passwort girerek oturum acin
    //4- sayfanin acilmasini bekleyin
    //5- acilan sayfada sparislere tiklayiniz
    //6- ürünlere göz at linkine tiklayiniz
    //7- secilen ürün e tiklanir
    //8- ürün stokta varsa sepete eklernir
    //9- sepete 5 ürün eklenmeli
    US03_4_Page us03Us04Page=new US03_4_Page();
    //WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Faker faker =new Faker();
    Actions actions =new Actions(Driver.getDriver());

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("tradyUrl"));
        us03Us04Page.girisYap.click();
        us03Us04Page.userNameBox.sendKeys(ConfigReader.getProperty("vendorValidMail"));
        us03Us04Page.passwortBox.sendKeys(ConfigReader.getProperty("vendorValidPassWort"));
        us03Us04Page.grisYapButton.click();
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu-item-1074")));
        us03Us04Page.hesabimAnasayfa.click();
        us03Us04Page.siparislerHesabim.click();

        //us03Us04Page.urunlereGozAt.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", us03Us04Page.sipariseDevam);
        jse.executeScript("arguments[0].click();", us03Us04Page.sipariseDevam);
        Thread.sleep(2000);
        //us03Us04Page.sipariseDevam.click();
        //us03Us04Page.urunListIlkSayfa.get(1).click();
        //jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.urunListIlkSayfa.get(1));
        //jse.executeScript("arguments[0].click();",us03Us04Page.urunListIlkSayfa.get(1));
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void test01_LoginBrowseProducs() {
        Assert.assertTrue(us03Us04Page.productList.size()>0);
    }


    @Test(priority = 2)
    public void test02_addtoCart() throws InterruptedException {
       String textOfCartCountFirst =  us03Us04Page.cartCount.getText();
       int cartCountFirst =Integer.valueOf(textOfCartCountFirst);

       for (int i = 0; i < 5; i++) {
           Thread.sleep(2000);
           jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.urunListIlkSayfa.get(i));
           jse.executeScript("arguments[0].click();",us03Us04Page.urunListIlkSayfa.get(i));
       }
       Thread.sleep(5000);
       int expectedCartcount = 5 +cartCountFirst;
       String textOfCartCount =  us03Us04Page.cartCount.getText();
       int actualCartCount =Integer.valueOf(textOfCartCount);
       Assert.assertEquals(actualCartCount,expectedCartcount);
    }
    @Test(priority = 3)
    public void test03_sepeteveCheckout() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.cartCount);
        jse.executeScript("arguments[0].click();",us03Us04Page.cartCount);
        us03Us04Page.sepetiGörüntüle.click();
        //actions.sendKeys(Keys.PAGE_DOWN);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.checkoutButton);
        Assert.assertTrue(us03Us04Page.checkoutButton.isDisplayed());
        jse.executeScript("arguments[0].click();",us03Us04Page.checkoutButton);

        //us03Us04Page.checkoutButton.click();
        Thread.sleep(3000);
        us03Us04Page.nameBox.isDisplayed();
    }


    @Test(priority = 4)
    public void test04_RequiredFieldWarning() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.cartCount);
        jse.executeScript("arguments[0].click();",us03Us04Page.cartCount);
        //us03Us04Page.cartCount.click();
        Thread.sleep(2000);
        us03Us04Page.sepetiGörüntüle.click();
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.checkoutButton);
        jse.executeScript("arguments[0].click();",us03Us04Page.checkoutButton);
        Thread.sleep(2000);
        us03Us04Page.nameBox.click();
        us03Us04Page.nameBox.clear();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        //actions.sendKeys(faker.internet().emailAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ").perform();
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.placeOrder);
        jse.executeScript("arguments[0].click();",us03Us04Page.placeOrder);
        //us03Us04Page.placeOrder.click();
        Thread.sleep(5000);
        Assert.assertTrue(us03Us04Page.nameRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.lastNameRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.districtRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.streetRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.zipRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.telefonRequired.isDisplayed());
        Assert.assertTrue(us03Us04Page.deliveryAddressRequired.isDisplayed());

    }

    @Test(priority = 5)
    public void test05_PlaceOrder() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.cartCount);
        jse.executeScript("arguments[0].click();",us03Us04Page.cartCount);
        //us03Us04Page.cartCount.click();
        us03Us04Page.sepetiGörüntüle.click();
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.checkoutButton);
        jse.executeScript("arguments[0].click();",us03Us04Page.checkoutButton);
        Thread.sleep(2000);
        us03Us04Page.nameBox.click();
        actions.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.name().lastName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.company().name());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().streetAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().fullAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().zipCode());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().cityName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.phoneNumber().cellPhone());
        actions.sendKeys(Keys.TAB);
        //actions.sendKeys(faker.internet().emailAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().fullAddress()).perform();

         jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.placeOrder);
        jse.executeScript("arguments[0].click();",us03Us04Page.placeOrder);
        //us03Us04Page.placeOrder.click();
        Thread.sleep(15000);
        Assert.assertTrue(us03Us04Page.orderOrder.isDisplayed());
    }
/*
    @Test(priority = 3)
    public void testSoyad() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.nameBox);
        jse.executeScript("arguments[0].click();",us03Us04Page.nameBox);
        us03Us04Page.nameBox.sendKeys(faker.name().firstName());
        //actions.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(" ");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().streetAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().zipCode());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().cityName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.phoneNumber().cellPhone());
        actions.sendKeys(Keys.TAB);
        //actions.sendKeys(faker.internet().emailAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.address().fullAddress()).perform();

        jse.executeScript("arguments[0].scrollIntoView(true);",us03Us04Page.placeOrder);
        jse.executeScript("arguments[0].click();",us03Us04Page.placeOrder);

        //us03Us04Page.placeOrder.click();
        Thread.sleep(2000);
        Assert.assertTrue(us03Us04Page.lastNameRequired.isDisplayed());

    }*/
}
