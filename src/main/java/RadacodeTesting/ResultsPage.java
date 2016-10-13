package RadacodeTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    private WebDriver driver;

    public ResultsPage(){
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }
    public ResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=".//cite[contains(., \"https://habrahabr\")]/ancestor::div[@class = \"rc\"]/h3/a")
    private WebElement linkToClick;

    @FindBy(css = "svg.icon-svg.icon-svg_logo-habrahabr title")
    private WebElement assertionText;

    public String getTextToAssert(){
        return assertionText.getText();
    }

    public void clickOnLink(){
        linkToClick.click();
    }
}
