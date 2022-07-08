import configuration.common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.factories.telerikMainPageAFactory;

public class initDriver extends common {
    public String URL = "https://demos.telerik.com/aspnet-ajax/grid/examples/data-editing/manual-crud-operations/defaultcs.aspx";

    @BeforeMethod
    public void driverStart() {
        driver = getWebDriver();
        telerikMainAPage = new telerikMainPageAFactory().getPageObject(driver);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) driver.quit();
    }

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;

    }

}
