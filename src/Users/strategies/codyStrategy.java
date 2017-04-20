package Users.strategies;

import Users.userStrategyClass;

public class codyStrategy implements userStrategyClass {

    // Chrome Web Application
    private String chromeApplicationPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
    private String IEApplicationPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
    private String testResultsPath = "src\\Results\\Test_Results\\"; // System.getProperty("user.dir")

    @Override
    public String getChromeApplicationPath()
    {
        return chromeApplicationPath;
    }

    public String getIEApplicationPath() {
        return IEApplicationPath;
    }

    @Override
    public String getTestResultsPath() {
        return testResultsPath;
    }

}
