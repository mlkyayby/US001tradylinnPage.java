package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US03_4_Page {
    public US03_4_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwortBox;

    @FindBy(xpath = "//button[text()='Giriş Yap']")
    public WebElement grisYapButton;

    @FindBy(id = "menu-item-1074")
    public WebElement hesabimAnasayfa;

    @FindBy(xpath = "//p[text()='Siparişler']")
    public WebElement siparislerHesabim;

    @FindBy(xpath = "//*[text()='Ürünlere göz at']")
    public WebElement urunlereGozAt;

    @FindBy(className = "ajax_add_to_cart")
    public List<WebElement> urunListIlkSayfa;

    @FindBy(xpath = "//span[@class='cart-count']")
    public WebElement cartCount;

    @FindBy(xpath = "//a[text()='Sepeti görüntüle']")
    public WebElement sepetiGörüntüle;

    @FindBy(xpath = "//button[text()='Temizle']")
    public WebElement sepetiTemizle;

    @FindBy(xpath = "//a[text()='Alışverişe Devam Et']")
    public WebElement sipariseDevam;

    @FindBy(className = "checkout-button")
    public WebElement checkoutButton;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement nameBox;

    @FindBy(id = "place_order")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li")
    public WebElement nameRequired;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li[1]")
    public WebElement lastNameRequired;

    @FindBy(className = "product-wrap")
    public List<WebElement>productList;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li/strong")
    public WebElement streetRequired;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li")
    public WebElement zipRequired;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li/strong")
    public  WebElement districtRequired;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li/strong")
    public WebElement telefonRequired;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li")
    public WebElement deliveryAddressRequired;

    @FindBy(xpath = "//*[text()='Teşekkür ederiz. Siparişiniz alınmıştır.']")
    public WebElement orderOrder;

 }
