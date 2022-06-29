package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US001tradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;


public class US001 {
    US001tradylinnPage US001tradylinnPage = new US001tradylinnPage();
    @Test
    public void TC001() throws InterruptedException {





        //user goes to the website.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user verifies uye ol button
        US001tradylinnPage.uyeOlButton.isDisplayed();
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user verifies if satici ol button is visible
        US001tradylinnPage.saticiOlButton.isDisplayed();

    }

    @Test
    public void TC002() throws InterruptedException {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //Emailbox is displayed
        US001tradylinnPage.emailBox.isDisplayed();
        waitFor(2);
        //Password box is displayed
        US001tradylinnPage.passwordBox.isDisplayed();
        waitFor(2);
        //Confirm is displayed
        US001tradylinnPage.confirmPasswordBox.isDisplayed();
        waitFor(2);
    }

    @Test
    public void TC003() {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //user leaves email box empty
        //user clicks on register button
        US001tradylinnPage.registerButton.click();
        //user should be able to display "Email:this field is required" text
        US001tradylinnPage.emailRequired.isDisplayed();
        //user enters valid email to email box
        US001tradylinnPage.emailBox.sendKeys(ConfigReader.getProperty("vendorValidMail"));

    }

    @Test
    public void TC004() {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //user clicks on email box
        US001tradylinnPage.emailBox.click();
        //user enters previously used email to email box
        US001tradylinnPage.emailBox.sendKeys(ConfigReader.getProperty("vendorValidMail"));
        //user clicks on password box
        US001tradylinnPage.passwordBox.click();
        //user enters password data
        US001tradylinnPage.passwordBox.sendKeys(ConfigReader.getProperty("vendorValidPassWort"));
        //user clicks on required password box
        US001tradylinnPage.confirmPasswordBox.click();
        //user enters password again
        US001tradylinnPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("vendorValidPassWort"));
        //user clicks on register
        US001tradylinnPage.registerButton.click();
        waitFor(2);
        //user should display "This Email already exists. Please login to the site and apply as vendor."
        US001tradylinnPage.emailExist.isDisplayed();

    }

    @Test
    public void TC005() {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //user verifies if email, password, confirm boxes are visible.
        US001tradylinnPage.emailBox.isDisplayed();
        US001tradylinnPage.passwordBox.isDisplayed();
        US001tradylinnPage.confirmPasswordBox.isDisplayed();
        //user clicks on email box
        US001tradylinnPage.emailBox.click();
        //user enters a unique and valid email
        US001tradylinnPage.emailBox.sendKeys(ConfigReader.getProperty("newEmail"));
        // user clicks on password box
        US001tradylinnPage.passwordBox.click();
        //user should enter a password that contain capital, small letter, number and special character
        US001tradylinnPage.passwordBox.sendKeys(ConfigReader.getProperty("newEmailPassword"));
        //User should be able to display "Strong" text
        String expectedStrength ="Strong";
        String actualStrength =US001tradylinnPage.passwordStrength.getText();
        Assert.assertEquals(expectedStrength, actualStrength);

    }

    @Test
    public void TC006() {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //user clicks on email box
        US001tradylinnPage.emailBox.click();
        //user enters a unique and valid email
        US001tradylinnPage.emailBox.sendKeys(ConfigReader.getProperty("newEmail"));
        // user clicks on password box
        US001tradylinnPage.passwordBox.click();
        //user should enter a password that contain capital, small letter, number and special character
        US001tradylinnPage.passwordBox.sendKeys(ConfigReader.getProperty("newEmailPassword"));
        //user clicks on confirm password box
        US001tradylinnPage.confirmPasswordBox.click();
        //user should enter the previous password again.
        US001tradylinnPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("newEmailPassword"));

    }

    @Test
    public void TC007() {
        //user goes to the website
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(2);
        //user clicks uye ol button
        US001tradylinnPage.uyeOlButton.click();
        waitFor(2);
        //user clicks on satici ol button is visible
        US001tradylinnPage.saticiOlButton.click();
        waitFor(2);
        //user clicks on email box
        US001tradylinnPage.emailBox.click();
        //user enters a unique and valid email
        US001tradylinnPage.emailBox.sendKeys(ConfigReader.getProperty("newEmail"));
        // user clicks on password box
        US001tradylinnPage.passwordBox.click();
        //user should enter a password that contain capital, small letter, number and special character
        US001tradylinnPage.passwordBox.sendKeys(ConfigReader.getProperty("newEmailPassword"));
        //user clicks on confirm password box
        US001tradylinnPage.confirmPasswordBox.click();
        //user should enter the previous password again.
        US001tradylinnPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("newEmailPassword"));
        //user should click on register button
        US001tradylinnPage.registerButton.click();

    }
}