import org.testng.annotations.Test;

public class telerikMain extends initDriver {

    @Test(priority = 1)
    public void verifyTableLoadedTest() {
        telerikMainAPage.verifyTableLoaded();
    }
    @Test(priority = 2)
    public void addRecordTest() {
        telerikMainAPage.verifyTableLoaded();
        telerikMainAPage.addRecord("abc", "15", "100.0");
        telerikMainAPage.verifyRecordShown("abc", "15", "$100.00");
    }
    @Test(priority = 3)
    public void deleteRecordTest() {
        telerikMainAPage.verifyTableLoaded();
        telerikMainAPage.deleteAddedRecord();
        telerikMainAPage.verifyRecordNotShown("abc", "15", "$100.00");
    }
    @Test(priority = 4)
    public void dropDownTest() {
        telerikMainAPage.verifyTableLoaded();
        telerikMainAPage.clickOnDropDown20();
    }

    @Test(priority = 5)
    public void addIncorrectRecordTest() {
        telerikMainAPage.verifyTableLoaded();
        telerikMainAPage.addRecord("abc", "abc", "abc");
        telerikMainAPage.verifyRecordShown("abc", " ", " ");
    }

}
