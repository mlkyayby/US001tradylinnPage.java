package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.US001tradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US001 {
    @Test
    public void TC001() throws InterruptedException {


        US001tradylinnPage US001tradylinnPage = new US001tradylinnPage();

        Faker fake = new Faker();
//user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        Thread.sleep(2000);
        //user verifies uye ol button
        US001tradylinnPage.uyeOlButton.isDisplayed();
        Thread.sleep(2000);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        Thread.sleep(2000);
        //user verifies if satici ol button is visible
        US001tradylinnPage.saticiOlButton.isDisplayed();

    }


}