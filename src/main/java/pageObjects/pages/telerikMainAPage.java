package pageObjects.pages;

import configuration.common;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

@Getter
public class telerikMainAPage extends common {

    @FindBy(xpath = "//button[@title='Previous Page']")
    private WebElement previousPageButton;

    @FindBy(xpath = "//button[@title='Next Page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//button[@title='First Page']")
    private WebElement firstPageButton;

    @FindBy(xpath = "//button[@title='Last Page']")
    private WebElement lastPageButton;

    @FindBy(xpath = "//button[@title='Add new record']")
    private WebElement addNewRecordButton;

    @FindBy(xpath = "//button[@title='Refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//*[@class='t-button rgActionButton rgEdit']")
    private List<WebElement> editButtons;

    @FindBy(xpath = "//*[@class='t-button rgActionButton rgDel']")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00_ctl02_ctl03_TB_ProductName']")
    private WebElement productNameInput;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00_ctl02_ctl03_TB_UnitsInStock']")
    private WebElement unitsInStockInput;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00_ctl02_ctl03_TB_UnitPrice']")
    private WebElement priceInput;

    @FindBy(xpath = "//button[@class='t-button rgActionButton rgUpdate']")
    private WebElement updateButton;

    @FindBy(xpath = "//button[@class='t-button rgActionButton rgCancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='RadWindow RadWindow_Silk']//button[@class='rwOkBtn']")
    private WebElement okButton;
    @FindBy(xpath = "//button[@class='rcbActionButton']")
    private WebElement pageSizeButton;

    private String xpathRow = "//tr[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00__";
    private String dropDownOptions = "//*[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown']";


    public telerikMainAPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class).withTimeout(Duration.ofSeconds(30));
    }

    public void verifyTableLoaded() {
        verifyElementDisplayed(getFirstPageButton());
        verifyElementDisplayed(getLastPageButton());
        verifyElementDisplayed(getAddNewRecordButton());
        verifyElementDisplayed(getNextPageButton());
        verifyElementDisplayed(getPreviousPageButton());
        verifyElementDisplayed(getRefreshButton());
        Assert.assertTrue(getEditButtons().size() == 10);
        Assert.assertTrue(getDeleteButtons().size() == 10);
    }

    public void addRecord(String name, String units, String price) {
        clickOnElement(getAddNewRecordButton());
        inputText(getProductNameInput(), name);
        inputText(getUnitsInStockInput(), units);
        inputText(getPriceInput(), price);
        sleepFor(200);
        clickOnElement(getUpdateButton());
    }

    public void verifyRecordShown(String name, String units, String price) {
        sleepFor(2500);
        scrollDown();
        clickOnElement(getLastPageButton());
        sleepFor(2500);
        Assert.assertTrue(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[3]")).getText().equals(name));
        Assert.assertTrue(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[4]")).getText().equals(units));
        Assert.assertTrue(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[5]")).getText().equals(price));
    }
    public void verifyRecordNotShown(String name, String units, String price) {
        sleepFor(2500);
        scrollDown();
        clickOnElement(getLastPageButton());
        sleepFor(2500);
        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[3]")).getText().equals(name));
        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[4]")).getText().equals(units));
        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[5]")).getText().equals(price));
    }

    public void clickOnDropDown20() {
        scrollDown();
        clickOnElement(pageSizeButton);
        fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(dropDownOptions + "/div/ul/li[2]")))).click();
        sleepFor(2500);
        Assert.assertTrue(getDeleteButtons().size() == 20);
    }

    public void deleteAddedRecord() {
        scrollDown();
        clickOnElement(getLastPageButton());
        sleepFor(2500);
        clickOnElement(getDeleteButtons().get(getDeleteButtons().size() - 1));
        clickOnElement(getOkButton());
//        sleepFor(2500);
//        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[3]")).getText().equals(name));
//        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[4]")).getText().equals(units));
//        Assert.assertFalse(driver.findElement(By.xpath(xpathRow + String.valueOf(getDeleteButtons().size() - 1) + "']/td[5]")).getText().equals(price));
    }


}
