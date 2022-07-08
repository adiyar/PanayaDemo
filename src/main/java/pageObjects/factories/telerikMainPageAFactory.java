package pageObjects.factories;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.telerikMainAPage;

public class telerikMainPageAFactory {
    public telerikMainAPage getPageObject(WebDriver driver) {
        return new telerikMainAPage(driver);
    }
}
