import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemsToCartTest extends BaseTest {

    @BeforeMethod(groups = "CorrectUser_LogIn")
    public void logIntoApplication(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBackPackToCartTestCorrect(){
        log.info("Performing adding Back pack action to cart.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        Assert.assertTrue(inventoryPage.isDeleteBackPackButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBackPackToCartTestIncorrect(){
        log.info("Checking if button Add to cart for Back pack is visible should be not.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        Assert.assertTrue(inventoryPage.isAddBackPackButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBikeLightToCartTestCorrect(){
        log.info("Performing adding Bike Light action to cart.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addbikeLightToCart();
        Assert.assertTrue(inventoryPage.isDeleteBikeLightButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBikeLightToCartTestIncorrect(){
        log.info("Checking if button Add to cart for Bike Light is visible should be not.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addbikeLightToCart();
        Assert.assertTrue(inventoryPage.isAddBikeLightButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBoltShirtToCartTestCorrect(){
        log.info("Performing adding Bolt shirt action to cart.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addboltShirtToCart();
        Assert.assertTrue(inventoryPage.isDeleteBoltShirtButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addBoltShirtToCartTestIncorrect(){
        log.info("Checking if button Add to cart for Bolt shirt is visible should be not.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addboltShirtToCart();
        Assert.assertTrue(inventoryPage.isAddBoltShirtButtonIsDisplayed());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void countItemsInCartTestCorrect(){
        log.info("Checking if cart counter will change when we add item.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        Assert.assertEquals(Integer.parseInt(inventoryPage.getValueOfCoutedItems()), 1);
    }


}
