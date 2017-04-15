package Webpage_Methods.Portfolio_Website.Pages;

import Webpage_Methods.Portfolio_Website.Portfolio_Master;

public class LinkedIn extends Portfolio_Master {

    public static LinkedIn instance = new LinkedIn();

    public void clickSignInOnRedirect()
    {
        clickElement("//a[@class='sign-in-link']");
    }

    public void setUserNameOnSignIn(String username)
    {
        sendTextToElement("//input[@id='session_key-login']", username);
    }

    public void setPasswordOnSignIn(String password)
    {
        sendTextToElement("//input[@id='session_password-login']", password);
    }

    public void clickSignInOnSignIn()
    {
        clickElement("//input[@name='signin']");
        waitFor(5);
    }
}
