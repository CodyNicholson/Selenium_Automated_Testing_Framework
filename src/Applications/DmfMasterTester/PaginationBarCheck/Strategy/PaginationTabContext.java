package Applications.DmfMasterTester.PaginationBarCheck.Strategy;

/**
 * Created by cad6025 on 2/13/2017.
 */

public class PaginationTabContext {

    /**************************
    ***   Singelton setup   ***
    **************************/

    private static PaginationTabContext instance = null;

    //protected PaginationTabContext(){}

    public static PaginationTabContext getInstance()
    {
        if (instance == null)
        {
            instance = new PaginationTabContext();
        }
        return instance;
    }

    /***************************
    ***   Set the strategy   ***
    ***************************/

    private PaginationTabStrategy strategy;

    public void setStrategy(PaginationTabStrategy strategy)
    {
        instance.strategy = strategy;
    }

    /******************
    ***   Methods   ***
    ******************/

    public String getDesiredTab()
    {
        return instance.strategy.getDesiredTab();
    }

    public String getPageNumber()
    {
        return instance.strategy.getPageNumber();
    }

    public String getNextPage()
    {
        return instance.strategy.getNextPage();
    }

    public String getPreviousPage()
    {
        return instance.strategy.getPreviousPage();
    }

    public String getFirstPage()
    {
        return instance.strategy.getFirstPage();
    }

    public String getFinalPageButton()
    {
        return instance.strategy.getFinalPageButton();
    }

    public String getFinalPageText()
    {
        return instance.strategy.getFinalPageText();
    }

    public String getFirstElementEntry()
    {
        return instance.strategy.getFirstElementEntry();
    }

    public String getSecondElementEntry()
    {
        return instance.strategy.getSecondElementEntry();
    }

}
