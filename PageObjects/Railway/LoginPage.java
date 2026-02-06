package Railway;

import org.openqa.selenium.By;
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

    public String getLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();
    }

    // Methods
    public HomePage login(User user) {
        Utilities.safeSendKeys(txtUsername, user.getEmail());
        Utilities.safeSendKeys(txtPassword, user.getPassword());
        Utilities.safeClick(btnLogin);
        return new HomePage();
    }
}
