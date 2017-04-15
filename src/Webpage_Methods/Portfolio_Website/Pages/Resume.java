package Webpage_Methods.Portfolio_Website.Pages;

import Webpage_Methods.Portfolio_Website.Portfolio_Master;

public class Resume extends Portfolio_Master {

    public static Resume instance = new Resume();

    public String getTitleHeader()
    {
        return getTextFromElement("//h1[@id='name']");
    }
}
