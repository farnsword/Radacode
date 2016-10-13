package RadacodeTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {
    private WebDriver driver;
    private static final String URL_ADRESS = "https://www.google.com.ua/";

    public FrontPage(){
        this.driver = new ChromeDriver();
        driver.get(URL_ADRESS);
        PageFactory.initElements(driver, this);
    }

    public FrontPage(WebDriver driver){
        this.driver = driver;
        driver.get(URL_ADRESS);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "lst-ib")
    private WebElement searchBar;

    @FindBy (id = "hplogo")
    private WebElement logo;

    public void setSearchBar(String text) {
        this.searchBar.sendKeys(text);
    }

    public String getLogo() {
        return logo.getAttribute("title");
    }

}
