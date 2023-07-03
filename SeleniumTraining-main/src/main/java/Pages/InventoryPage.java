package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage{

    private final By backPackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By boltShirtAddToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By fleeceJacketAddToCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By backPackRemoveFromCartButton = By.id("remove-sauce-labs-backpack");
    private final By bikeLightRemoveFromCartButton = By.id("remove-sauce-labs-bike-light");
    private final By boltShirtRemoveFromCartButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By fleeceJacketRemoveFromCartButton = By.id("remove-sauce-labs-fleece-jacket");
    private final By shoppingCartContainer = By.id("shopping_cart_container");
    private final By backpackName = By.xpath("//*[@id=\"item_4_title_link\"]/div");




    public InventoryPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void addBackPackToCart(){
        click(backPackAddToCartButton);
    }

    public void addbikeLightToCart(){
        click(bikeLightAddToCartButton);
    }

    public void addboltShirtToCart(){
        click(boltShirtAddToCartButton);

    }
    public void addfleeceJacketToCart(){
        click(fleeceJacketAddToCartButton);
    }

    public void removeFromCartBackPack(){
        click(backPackRemoveFromCartButton);
    }

    public void removeFromCartBikeLight(){
        click(bikeLightRemoveFromCartButton);
    }

    public void removeFromCartBoltShirt(){
        click(boltShirtRemoveFromCartButton);
    }

    public void removeFromCartFleeceJacket(){
        click(fleeceJacketRemoveFromCartButton);
    }

    public void goToCart(){
        click(shoppingCartContainer);
    }

    public boolean isAddBackPackButtonIsDisplayed(){
        try{
            return find(backPackAddToCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean isDeleteBackPackButtonIsDisplayed(){
        try{
            return find(backPackRemoveFromCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean isAddBikeLightButtonIsDisplayed(){
        try{
            return find(backPackAddToCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean isDeleteBikeLightButtonIsDisplayed(){
        try{
            return find(backPackRemoveFromCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean isAddBoltShirtButtonIsDisplayed(){
        try{
            return find(backPackAddToCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean isDeleteBoltShirtButtonIsDisplayed(){
        try{
            return find(backPackRemoveFromCartButton).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }

    }

    public String getValueOfCoutedItems(){

        return find(shoppingCartContainer).getText();
    }

    public String getNameForBackPack(){

        return find(backpackName).getText();
    }

    public WebElement addBackPackToCartButton(){

        return find(backPackAddToCartButton);
    }

    public void inventoryPage(){
        openUrl("https://www.saucedemo.com/inventory.html");
    }

}
