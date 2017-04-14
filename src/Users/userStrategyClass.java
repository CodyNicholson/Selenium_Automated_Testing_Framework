package Users;

/**
 * Created by cad6025 on 2/2/2017.
 */

public interface userStrategyClass {
    // Chrome Web Application
    String getChromeApplicationPath();
    String getIEApplicationPath();

    //Applications
    String getCreatePolicyPath();
    String getCreateAccountPath();
    String getAddDocumentPath();
    String getCreateTestResultSpreadsheetPath();
    String getTestCheckInCheckOutPath_DMF_Smoke_Test();
    String getTestDistributePath_DMF_Smoke_Test();
}