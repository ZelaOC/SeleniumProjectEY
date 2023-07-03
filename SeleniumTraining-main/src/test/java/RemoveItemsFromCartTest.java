import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveItemsFromCartTest extends BaseTest {

    @BeforeMethod(groups = "Correct_RemoveBackPack")
    public void logIntoApplicationAndAddItem(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
    }

    @Test(groups = "Correct_RemoveBackPack")
    public void removeBackPackFromCartTestCorrect(){
        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.removeFromCartBackPack();
        Assert.assertTrue(inventoryPage.isAddBackPackButtonIsDisplayed());
    }

    @Test(groups = "Correct_RemoveBackPack")
    public void removeBackPackFromCartTestIncorrect(){
        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.removeFromCartBackPack();
        Assert.assertTrue(inventoryPage.isDeleteBackPackButtonIsDisplayed());
    }
}
