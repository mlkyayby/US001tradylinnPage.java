package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US001tradylinnPage {



    public US001tradylinnPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //TC001 locates
    @FindBy(xpath = "//span[text()='Üye Ol']")
    public WebElement uyeOlButton;

    @FindBy(xpath = "//a[text()='Satıcı Ol']")
    public WebElement saticiOlButton;

    //TC002 locates
    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='passoword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordBox;

    //TC003 locates
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement emailRequired;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButton;

    //TC004 locates
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement emailExist;

    //TC005 locates
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement succesfulRegistration;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement passwordStrength;


}
