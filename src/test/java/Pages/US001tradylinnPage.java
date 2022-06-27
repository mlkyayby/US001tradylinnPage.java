package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US001tradylinnPage {

    //TC001 locates

    public US001tradylinnPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Üye Ol']")
    public WebElement uyeOlButton;

    @FindBy(xpath = "//a[text()='Satıcı Ol']")
    public WebElement saticiOlButton;

}
