package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By removeBackpackFromCart = By.id("remove-sauce-labs-backpack");
    private final By removeFleeceJacketFromCart = By.id("remove-sauce-labs-fleece-jacket");
    private final By removeBikeLightFromCart = By.id("remove-sauce-labs-bike-light");
    private final By removeBoltShirtFromCart = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By backpackName = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private final By fleeceJacketName = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private final By cartItemCounter = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");



    public CartPage(WebDriver driver, Logger log){

        super(driver, log);
    }

    public void cartPage(){

        openUrl("https://www.saucedemo.com/cart.html");
    }

    public void continueShopping(){
        click(continueShoppingButton);
    }

    public void goToCheckout(){
        click(checkoutButton);
    }

    public void removeBackPackCart(){
        click(removeBackpackFromCart);
    }

    public void removeFleeceJacketCart(){
        click(removeFleeceJacketFromCart);
    }

    public String getBackPackNameCart(){
        return find(backpackName).getText();
    }

    public String getFleeceJacketNameCart(){
        return find(fleeceJacketName).getText();
    }

    public String getItemCountCart(){
        return find(cartItemCounter).getText();
    }

    public void removeBikeLightCart(){
        click(removeBikeLightFromCart);
    }

    public void removeBoltShirtCart(){
        click(removeBoltShirtFromCart);
    }

}
