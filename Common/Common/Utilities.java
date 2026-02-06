package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import org.openqa.selenium.By;


public class Utilities {

	
	public static void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].click();", element);
    }
	
	public static void scrollToElement(By locator) {
        WebElement element = Constant.WEBDRIVER.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public static void safeClick(By locator) {

		WaitUtils.waitForClickable(locator);
	    
	    WebElement element = Constant.WEBDRIVER.findElement(locator);
	    
	    scrollToElement(element);
	    
	    element.click();
	}
	
}
