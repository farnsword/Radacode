package RadacodeTesting;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RunTest {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Job\\Testing\\chromedriver\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "D:\\Job\\Testing\\geckodriver\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void googlePageTesting(){
        FrontPage google = new FrontPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("hplogo")));
        Assert.assertEquals("Google", google.getLogo());

        google.setSearchBar("habrahabr");

        ResultsPage results = new ResultsPage(driver);
        results.clickOnLink();

        HabrPage habr = new HabrPage(driver);
        Assert.assertEquals("Хабрахабр", results.getTextToAssert());
        habr.clickAllTopicsLink();
        habr.clickSecondPage();
    }
}
