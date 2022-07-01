package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradylinnPages1 {
    public TradylinnPages1(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"header\"]/div/div[1]/div/div[2]/div/div[3]/div/div/a[1]/span")
    public WebElement girisyap;
    @FindBy(xpath = "(//input[@id=\"username\"])[1]")
    public WebElement email;
    @FindBy(xpath = "(//input[@id=\"password\"])[1]")
    public WebElement password;
    @FindBy(xpath = "(//button[@value=\"Giriş Yap\"])[1]")
    public WebElement login;
    @FindBy(xpath = "(//a[text()='Hesabım'])[1]")
    public WebElement hesabim;
    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;
    @FindBy(xpath = "(//span[@class='text'])[1]")
    public WebElement Kuponlar;
    @FindBy(xpath ="(//*[.='Yeni ekle'])[1]")
    public WebElement yeniKuponEkle;
    @FindBy(xpath = "//*[@id=\"title\"]\n")
    public WebElement codeTextbox;
    @FindBy(xpath = "//div[@id='coupons_manage_restriction']")
    public WebElement restriction;
     @FindBy(xpath = "//input[@id=\"minimum_amount\"]\n")
    public WebElement minimumSpend;
     @FindBy(xpath = "//input[@id=\"maximum_amount\"]\n")
    public WebElement maximumSpend;
     @FindBy(xpath = "//input[@id=\"individual_use\"]\n")
    public WebElement individualUseOnly;
     @FindBy(xpath = "//input[@id=\"exclude_sale_items\"]\n")
    public WebElement excludeSaleItems;
     @FindBy(xpath = "(//ul[@class=\"select2-selection__rendered\"])[4]\n")
    public WebElement excludeCategories;
     @FindBy(xpath = "//div[@class='wcfm-tabWrap']")
     public WebElement CouponSuccessfullyPublished;
   @FindBy(xpath = "//div[@id=\"coupons_manage_limit\"]\n")
    public WebElement limit;
   @FindBy(xpath = "//input[@id=\"usage_limit\"]\n")
    public WebElement usageLimitPerCoupon;
   @FindBy(xpath ="//input[@id=\"limit_usage_to_x_items\"]\n" )
    public WebElement limitUsageToXItems;
   @FindBy(xpath = "//input[@id='usage_limit_per_user']\n")
    public WebElement usageLimitPerUser;
   @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submit;
}
