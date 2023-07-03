package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage{

    private final By finishButton = By.id("finish");
    private final By totalPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
    private final By bikeLightName = By.id("//*[@id=\"item_0_title_link\"]/div");
    private final By overviewTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By itemCounter = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");



    public CheckoutOverviewPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    public void checkoutOverviewPage(){
        openUrl("https://www.saucedemo.com/checkout-step-two.html");
    }

    public void finishButtonClick(){
        click(finishButton);
    }

    public WebElement itemCounter(){
        return find(itemCounter);
    }

    public String overviewSiteTitle(){
        return find(overviewTitle).getText();
    }

    public String bikeLightNameCart(){
        return find(bikeLightName).getText();
    }

    public String totalCartPrice(){
        return find(totalPrice).getText();
    }

}
