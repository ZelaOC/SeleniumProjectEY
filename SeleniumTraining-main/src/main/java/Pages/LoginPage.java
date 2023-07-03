package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage{

    private final By userNameField = By.id("user-name");
    private final By userPasswordField = By.id("password");
    private final By loginButton = By.cssSelector("[name='login-button']");
    private final By errorMessageField = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void loginPage(){
        openUrl("https://www.saucedemo.com/");
    }

    public void loginForm(String username, String password){
        type(username, userNameField);
        type(password, userPasswordField);
        click(loginButton);
    }

    public String errorField(){
        return find(errorMessageField).getText();
    }

}
