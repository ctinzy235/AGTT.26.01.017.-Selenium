package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.Utilities;
import DataObjects.User;


public class LoginPage extends GeneralPage {
    // Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    // Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }
    
    public String getLoginErrorMsg() {
        return getLblLoginErrorMsg().getText();
    }

    // Methods
    public HomePage login(User user) {
        this.getTxtUsername().sendKeys(user.getEmail());
        this.getTxtPassword().sendKeys(user.getPassword());
        Utilities.safeClick(btnLogin);
        return new HomePage();
    }
}
