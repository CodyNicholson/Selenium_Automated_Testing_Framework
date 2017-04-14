package Applications.DmfMasterTester.PaginationBarCheck.Strategy.TabStrategies;

import Applications.DmfMasterTester.PaginationBarCheck.Strategy.PaginationTabStrategy;

/**
 * Created by cad6025 on 2/13/2017.
 */
public class MyRenewalsStrategy implements PaginationTabStrategy{

    /*************
     *   XPaths   *
     *************/

    String desktopWestTab = "//span[@id = 'westPanel-outerCt']//div[@id = 'Desktop:MenuLinks-body']//span[text() = 'My Renewals']";

    String pageNumber = "//input[@id = 'DesktopRenewals:DesktopRenewalsScreen:DesktopRenewalsLV:_ListPaging-inputEl']";

    String nextPage = "//span[@class = 'x-btn-icon-el x-tbar-page-next ']";

    String previousPage = "//span[@class = 'x-btn-icon-el x-tbar-page-prev ']";

    String firstPage = "//span[@class = 'x-btn-icon-el x-tbar-page-first ']";

    String finalPageButton = "//span[@class = 'x-btn-icon-el x-tbar-page-last ']";

    String finalPageText = "//div[starts-with(@id, 'tbtext-')][2]";

    String firstElementEntry = "//table[starts-with(@id, 'gridview-')] //tr[1] //td[3]";

    String secondElementEntry = "//table[starts-with(@id, 'gridview-')] //tr[1] //td[12]";

    /************************
     *   Overriden methods   *
     ************************/

    @Override
    public String getDesiredTab ()
    {
        return desktopWestTab;
    }

    public String getPageNumber()
    {
        return pageNumber;
    }

    public String getNextPage()
    {
        return nextPage;
    }

    public String getPreviousPage()
    {
        return previousPage;
    }

    public String getFirstPage()
    {
        return firstPage;
    }

    public String getFinalPageButton()
    {
        return finalPageButton;
    }

    public String getFinalPageText()
    {
        return finalPageText;
    }

    public String getFirstElementEntry() {
        return firstElementEntry;
    }

    public String getSecondElementEntry() {
        return secondElementEntry;
    }

}
