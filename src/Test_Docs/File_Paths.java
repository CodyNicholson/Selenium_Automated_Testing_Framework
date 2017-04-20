package Test_Docs;

public class File_Paths
{
    private String chromeApplicationPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
    private String IEApplicationPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
    private String testResultsPath = "src\\Results\\Test_Results\\"; // System.getProperty("user.dir")

    public String getChromeApplicationPath() {
        return chromeApplicationPath;
    }

    public String getIEApplicationPath() {
        return IEApplicationPath;
    }

    public String getTestResultsPath() {
        return testResultsPath;
    }
}
