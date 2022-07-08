import org.testng.annotations.Test;

public class telerikMain extends initDriver {

    @Test
    public void verifyTableLoaded() {
        telerikMainAPage.verifyTableLoaded();
    }

    @Test
    public void addRecord() {
        telerikMainAPage.verifyTableLoaded();
        telerikMainAPage.addRecord("abc", "15", "100.0");
        telerikMainAPage.verifyRecordShown("abc", "15", "$100.00");

    }

}
