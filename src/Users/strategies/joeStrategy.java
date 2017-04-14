package Users.strategies;

import Users.userStrategyClass;

/**
 * Created by cad6025 on 2/2/2017.
 */

public class joeStrategy implements userStrategyClass {

    // Chrome Web Application
    String chromeApplicationPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
    String IEApplicationPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";

    // Application Paths
    String createPolicyPath = "C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\excelDocs\\AddPolicies.xls";
    String createAccountPath = "C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\excelDocs\\CreateAccounts.xls";
    String addDocumentPath = "C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\src\\Applications\\DmfMasterTester\\DmfSmokeTest\\docsToAdd\\testAddDoc.txt";
    String createTestResultSpreadsheetPath = "Results/TestResults/";
    String testCheckInCheckOutPath_DMF_Smoke_Test = "C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\src\\Applications\\DmfMasterTester\\DmfSmokeTest\\docsToAdd\\testCheckOutCheckIn.txt";
    String testDistributePath = "C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\src\\Applications\\DmfMasterTester\\DmfSmokeTest\\docsToAdd\\testDistribute.txt";

    @Override
    public String getChromeApplicationPath()
    {
        return chromeApplicationPath;
    }

    public String getIEApplicationPath() {
        return IEApplicationPath;
    }

    public String getCreatePolicyPath() { return createPolicyPath; }

    public String getCreateAccountPath() { return createAccountPath; }

    public String getAddDocumentPath() { return addDocumentPath; }

    public String getCreateTestResultSpreadsheetPath()
    {
        return createTestResultSpreadsheetPath;
    }

    public String getTestCheckInCheckOutPath_DMF_Smoke_Test()
    {
        return testCheckInCheckOutPath_DMF_Smoke_Test;
    }

    @Override
    public String getTestDistributePath_DMF_Smoke_Test() {
        return testDistributePath;
    }
}
