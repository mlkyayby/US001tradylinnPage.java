package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradyLinnPages {
    public TradyLinnPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy
    public WebElement x;
}
