import org.testng.annotations.Test;

public class telerikMain extends initDriver {

    @Test(priority = 1)
    public void verifyTableLoadedTest() {
        telerikMainAPage.verifyTableLoaded();
    }

    @Test(priority = 2)
    public void addRecordTest() {
        telerikMainAPage.addRecord("abc", "15", "100.0");
        telerikMainAPage.verifyRecordShown("abc", "15", "$100.00");
    }

    @Test(priority = 3)
    public void editAddedRecordTest() {
        telerikMainAPage.editLastRecord("qwe", "789", "654");
        telerikMainAPage.verifyRecordShown("qwe", "789", "$654.00");
    }

    @Test(priority = 4)
    public void deleteRecordTest() {
        telerikMainAPage.deleteAddedRecord();
        telerikMainAPage.verifyRecordNotShown("qwe", "789", "$654.00");
    }

    @Test(priority = 5)
    public void dropDownTest() {
        telerikMainAPage.clickOnDropDown20AndVerify();
    }

    @Test(priority = 6)
    public void addIncorrectRecordTest() {
        telerikMainAPage.addRecord("abc", "abc", "abc");
        telerikMainAPage.verifyRecordShown("abc", " ", " ");
        telerikMainAPage.deleteAddedRecord();

    }

}
