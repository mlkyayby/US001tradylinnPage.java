package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    /*
    POM Driver icin TestBase class'ina extends etmek yerine
    Driver classindan static methodlar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver;in kapatilmasi tercih edilir

    POM'da Driver classindaki getDriver() ile obje olusturularak kullanilmasini
    engellemek icin Singleton pattern kullanimi benimsemistir.

    Singleton Pattern: tekli kullanim, bir class'in farkli classlardan
    obje olusturularak kullanimi engellemk icin kullanilir.

    bunu yapmamiz icin obje olusturmak icin kullanilan constructor'i private yaptigimiz zaman
    baska classlardan Driver classindan obje olusturulmasi mumkun olamaz.
     */

    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;//ne olur ne olmaz diyerek eklendi
        }
    }
}
