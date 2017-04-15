package Webpage_Methods.Portfolio_Website.Pages;

import Webpage_Methods.Portfolio_Website.Portfolio_Master;

public class Index extends Portfolio_Master {

    public static Index instance = new Index();

    public void clickResumeButton()
    {
        clickElement("//a[@class='resume']");
    }

    public void clickGithubButton()
    {
        clickElement("//a[@class='github']");
        switchToTab(1);
    }

    public void clickLinkedInButton()
    {
        clickElement("//a[@class='linkedin']");
        switchToTab(1);

        if(getCurrentUrl().contains("login_reg_redirect"))
        {
            LinkedIn_Page.clickSignInOnRedirect();
            LinkedIn_Page.setUserNameOnSignIn("codynicholson96@gmail.com");
            LinkedIn_Page.setPasswordOnSignIn("138599");
            LinkedIn_Page.clickSignInOnSignIn();
        }
    }

    public void clickContactMeButton()
    {
        clickElement("//a[@class='email']");
    }

    public String getWelcomeMessage()
    {
        return getTextFromElement("//p[@class='title_super']");
    }

    public boolean isContactMeModelDisplayed()
    {
        return isDisplayed("//div[@class='modal-content']");
    }
}
