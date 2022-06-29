package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TradyLinnPages {
    public TradyLinnPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"header\"]/div/div[1]/div/div[2]/div/div[3]/div/div/a[1]/span")
    public WebElement girisyap;

    @FindBy(xpath = "//*[@id=\"wcfm-followers\"]/tbody/tr/td")
    public List<WebElement> takipcilerTableBody;
    @FindBy(xpath = "(//input[@id=\"username\"])[1]")
    public WebElement email;
    @FindBy(xpath = "(//input[@id=\"password\"])[1]")
    public WebElement password;
    @FindBy(xpath = "(//button[@value=\"Giriş Yap\"])[1]")
    public WebElement login;

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;
    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;
    @FindBy(xpath = "//a[@data-tip=\"Add New Product\"]")
    public WebElement addNewProduct;
    @FindBy(xpath = "//input[@id=\"is_virtual\"]")
    public WebElement virtualCheckBox;
    @FindBy(xpath = "//input[@id=\"is_downloadable\"]")
    public WebElement dowloadablecheckBox ;
    @FindBy(xpath = "//input[@id=\"pro_title\"]")
    public WebElement productName;
    @FindBy(xpath = "//img[@id=\"featured_img_display\"]")
    public WebElement photo;
    //*[@id="wcfm_menu"]/div/a
    //*[@id="wcfm_menu"]/div
    @FindBy(xpath = "//*[@id=\"wcfm_menu\"]/div")
    public List<WebElement> myStoreMenu;
    @FindBy(xpath = "//*[@id=\"wcfm-products\"]/thead/tr/th")
    public List<WebElement> tableList;
    @FindBy(xpath = "//*[@id=\"wcfm-products\"]/tbody/tr/td")
    public WebElement emptyBody;
    @FindBy(id = "__wp-uploader-id-1")
    public WebElement uploadFile;
    @FindBy(xpath = "//*[@id=\"__wp-uploader-id-0\"]/div[4]/div/div[2]/button")
    public WebElement sec;
    @FindBy(xpath = "//iframe[@id=\"excerpt_ifr\"]")
    public WebElement iframe;
    @FindBy(xpath = "//iframe[@id=\"description_ifr\"]")
    public WebElement iframe2;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p/br")
    public WebElement description;
    @FindBy(xpath = "//ul[@id=\"product_cats_checklist\"]//li")
    public List<WebElement> categories;
    @FindBy(xpath = "//*[@id=\"product_cats_checklist\"]/li/input")
    public List<WebElement> categories2;
    @FindBy(xpath = "//*[@id=\"product_brand\"]/li/input")
    public List<WebElement> productBrand;
    //hatice hanm

    @FindBy(xpath = "//*[@id=\"wcfm-shop-customers\"]/thead/tr/th")
    public List<WebElement> tableBaslik;

    @FindBy(xpath = "//*[@id=\"wcfm-shop-customers\"]/tbody/tr\n")
    public List<WebElement> tableBody;

    //saniye hanim
    @FindBy(xpath = "//nav[@class=\"woocommerce-MyAccount-navigation col-md-3 mb-8\"]/ul/li/a")
    public List<WebElement> pano;
    @FindBy(xpath = "    @FindBy(xpath = \"//*[@id=\\\"product_brand\\\"]/li/input\")\n" +
            "    public List<WebElement> productBrand;")
    public List<WebElement> siparislerTble;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/p")
    public WebElement indirmeler;
    @FindBy(xpath = "//table[@class=\"address-table\"]//tbody[1]//tr")
    public List<WebElement> faturaAdresleri;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[2]/div/address/table/tbody/tr")
    public List<WebElement> gönderimAdresi;

    @FindBy(xpath = "//button[@value=\"Değişiklikleri kaydet\"]")
    public WebElement degisiklikUpdate;
    @FindBy(xpath = "(//form[@method=\"post\"])[1]//p//label")
    public List<WebElement> hesapDetaylariForm;


    //US_22
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/section/div/div[2]/div/div/div/h2/a")
    public List<WebElement> tumunuGor;
    @FindBy(xpath = "//ul[@class='breadcrumb']/li[3]")
    public List<WebElement> homePageCategories;

    @FindBy(xpath = "//select[@name=\"orderby\"]")
    public WebElement dde;

    @FindBy(xpath = "//span[@class=\"price\"]")
    public List<WebElement> allPrices;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div[2]/div/div/div/section/div/div[1]/div/div/div/h2/a")
    public List<WebElement> allCategories;
    //span[@class="price"]
    @FindBy(xpath = "/html/body/div[2]/div[1]/ul/li[3]")
    public WebElement check;
    //US_012
    @FindBy(xpath = "//img[@id=\"gallery_img_gimage_0_display\"]")
    public WebElement littleImage;
    @FindBy(xpath = "(//button[@id=\"menu-item-upload\"])[5]")
    public WebElement accessFileDowload;
    @FindBy(xpath = "//*[@id=\"__wp-uploader-id-4\"]")
    public WebElement file2Dowload;
//hakanhoca

    @FindBy(xpath = "//*[@id=\"orders_details_general_expander\"]/table/tbody/tr/td")
    public List<WebElement> takipciteslimatBilgileri;

    @FindBy(xpath = "//*[@id=\"wcfm-orders\"]/tbody/tr[2]/td[9]/a[2]/span")
    public WebElement emirlerViewDetails;
    @FindBy(xpath = "//*[@id=\"orders_details_general_expander\"]/p[3]/a")
    public WebElement teslimatAdresi;

    @FindBy(xpath = "//*[@id=\"wcfm-refund-requests\"]/thead/tr/th")
    public List<WebElement> tableHead;
    public void getSpecificRow(String ... str){
        List<Integer> nums=new ArrayList<>();
        for (String each:str) {
            for(int i=0;i<tableHead.size();i++){
                if(tableHead.get(i).getText().equalsIgnoreCase(each)){
                    nums.add(i);
                }
            }
        }
        System.out.println(nums);
        for(int i=0;i<nums.size();i++){
            System.out.println(Driver.getDriver().findElement(By.xpath("//*[@id=\"wcfm-refund-requests\"]/tbody/tr/td[" + nums.get(i) + "]")).getText());
        }
    }
    public WebElement selecto(String str){
        List<WebElement> element=Driver.getDriver().findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/section/div/div[1]/div/div/div/h2/a"));
        WebElement elemento=null;
        for(int i=0;i<element.size();i++){
            if(element.get(i).getText().trim().equalsIgnoreCase(str)){
               elemento= Driver.getDriver().findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/section/div/div[2]/div/div/div/h2/a")).get(i);
            }
        }
           return elemento;
    }
    public List<Integer> makeStringToInt(List<WebElement> list){
        List<Integer> priceList=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            priceList.add(i,Integer.parseInt(list.get(i).getText().trim().replaceAll("[^0-9]","")));
        }
        return priceList;
    }

    public WebElement choiceElement(List<WebElement> myStoreMenu,String str){
        WebElement element=null;
        for (WebElement w:myStoreMenu) {
            if(w.getText().trim().equalsIgnoreCase(str)){
                   element=w;
            }
        }
        return element;
    }
    public WebElement choiceContainsElement(List<WebElement> a,String str){
        WebElement element=null;
        for (WebElement w:a) {
            if(w.getText().trim().toLowerCase().contains(str.toLowerCase())){
                element=w;
            }
        }
        return element;
    }
    public void list(List<WebElement> list ){
        list.stream().forEach(t-> System.out.println(t.getText()));
    }

    public WebElement check(List<WebElement> list){
        WebElement element=null;
        for (WebElement w:myStoreMenu) {
           element=w;
        }
        return element;
    }



}
