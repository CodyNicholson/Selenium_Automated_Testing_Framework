package Webpage_Methods.Portfolio_Website;

import Webpage_Methods.Portfolio_Website.Pages.Index;
import Webpage_Methods.Portfolio_Website.Pages.LinkedIn;
import Webpage_Methods.Portfolio_Website.Pages.Resume;

public class Portfolio_Master extends Webpage_Methods.Selenium_Master
{
    public Index Index_Page = Index.instance;
    public Resume Resume_Page = Resume.instance;
    public LinkedIn LinkedIn_Page = LinkedIn.instance;

    public void goToPortfolioWebsite()
    {
        goToUrl("https://codynicholson.github.io/");
    }
}
