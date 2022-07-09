package configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import pageObjects.pages.telerikMainAPage;

import java.time.Duration;

import static java.lang.System.getProperty;

public class common {
    public WebDriver driver;

    public Actions actions;
    public FluentWait<WebDriver> fluentWait;
    public telerikMainAPage telerikMainAPage;

    public void sleepFor(int sleep) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(sleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyElementDisplayed(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void inputText(WebElement element, String text) {
        fluentWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void clickOnElement(WebElement element) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void clearAndInsertInputText(WebElement element, String text) {
        fluentWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        fluentWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }

    public void scrollDown() {
        sleepFor(2500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

}
