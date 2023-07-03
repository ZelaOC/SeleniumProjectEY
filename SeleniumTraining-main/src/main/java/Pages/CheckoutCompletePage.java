package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    private final By backHome = By.id("back-to-products");
    private final By orderMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private final By orderTitleComplete = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public CheckoutCompletePage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public void checkoutCompletePage(){
        openUrl("https://www.saucedemo.com/checkout-complete.html");
    }

    public void backHomeClick(){
        click(backHome);
    }

    public String orderMessageText(){
        return find(orderMessage).getText();
    }

    public String checkoutCompleteTitle(){
        return find(orderTitleComplete).getText();
    }
}
