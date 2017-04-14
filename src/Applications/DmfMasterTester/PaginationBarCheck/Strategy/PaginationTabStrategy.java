package Applications.DmfMasterTester.PaginationBarCheck.Strategy;

/**
 * Created by cad6025 on 2/13/2017.
 */
public interface PaginationTabStrategy {
    String getDesiredTab();
    String getPageNumber();
    String getNextPage();
    String getPreviousPage();
    String getFirstPage();
    String getFinalPageButton();
    String getFinalPageText();
    String getFirstElementEntry();
    String getSecondElementEntry();
}
