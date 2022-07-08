package configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import pageObjects.pages.telerikMainAPage;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import static java.lang.System.getProperty;

public class common {
    public WebDriver driver;
    public FluentWait<WebDriver> fluentWait;
    public telerikMainAPage telerikMainAPage;

    public void sleepFor(int sleep) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(sleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeFullScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            /// change directory to your computer
            String tempDir = getProperty("java.io.tmpdir");
            File destFile = new File(Paths.get(tempDir, fileName + ".png").toString());
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("screenshot " + fileName + " was saved on " + tempDir);
        } catch (Exception e) {
            System.out.println("couldn't take screen shot");
        }
    }

    public void verifyElementDisplayed(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void inputText(WebElement element , String text) {
        fluentWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void clickOnElement (WebElement element) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

    }


}
