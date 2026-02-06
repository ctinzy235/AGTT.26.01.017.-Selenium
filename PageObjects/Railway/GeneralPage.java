package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Tab;
import Constant.Constant;


public class GeneralPage {

	private final String tabXpath = "//div[@id='menu']//span[text()='%s']";
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    
    protected WebElement getTabByText(String tabName) {
        String xpath = String.format(tabXpath, tabName);
        return Constant.WEBDRIVER.findElement(By.xpath(xpath));
    }
        
    
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }
    
    public boolean isTabLogoutDisplayed() {
        try {
            return getTabByText("Log out").isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; 
        }
    }
    
    public void gotoPage(Tab tab) {
        switch (tab) {
            case LOGIN:
                getTabByText("Login").click();
                break;
            case REGISTER:
                getTabByText("Register").click();
                break;
            case LOGOUT:
                getTabByText("Log out").click();
                break;
            case FAQ:
                getTabByText("FAQ").click();
                break;
            case TIMETABLE: 
                getTabByText("Timetable").click();
                break;
            case CONTACT:
            	getTabByText("Contact").click();
            	break;
            case TICKETPRICE:
            	getTabByText("Ticket Price").click();
            	break;
            case BOOKTICKET:
            	getTabByText("Book Ticket").click();
            	break;
            default:
                System.out.println("Tab name is not defined!");
                break;
        }
    }
    
    
    
}
