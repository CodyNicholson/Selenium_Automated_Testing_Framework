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
        //waitFor(2); // Wait for model to close after clicking submit button
        return isDisplayed("//div[@class='modal-content']");
    }

    public void setNameInContactMe(String name)
    {
        sendTextToElement("//input[@id='Name']", name);
    }

    public void setMessageInContactMe(String message)
    {
        sendTextToElement("//textarea[@id='Message']", message);
    }

    public void setEmailInContactMe(String email)
    {
        sendTextToElement("//input[@id='Contact']", email);
    }

    public void setFeedbackInContactMe(String feedback)
    {
        sendTextToElement("//textarea[@id='Feedback']", feedback);
    }

    public void clickSubmit()
    {
        clickElement("//input[@name='submit']");
    }

    public void clickIAmNotARobot()
    {
        clickElement("//span[@id='recaptcha-anchor']");
        waitFor(3);
    }
}
