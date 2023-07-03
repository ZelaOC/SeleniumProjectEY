import Pages.CartPage;
import Pages.CheckoutInformationPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import assertions.CartAssertions;
import assertions.CheckOutInformationAssertions;
import assertions.InventoryAssertions;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @BeforeMethod(groups = "CorrectUser_LogIn")
    public void logIntoApplication(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");
    }

    @Test(groups = "CorrectUser_LogIn")
    public void addItemsToCart(){
        log.info("Positive test for adding items to cart");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        inventoryPage.addbikeLightToCart();
        inventoryPage.addboltShirtToCart();
        Assert.assertTrue(inventoryPage.isDeleteBackPackButtonIsDisplayed());
        Assert.assertTrue(inventoryPage.isDeleteBikeLightButtonIsDisplayed());
        Assert.assertTrue(inventoryPage.isDeleteBoltShirtButtonIsDisplayed());
        Assert.assertEquals(inventoryPage.getValueOfCoutedItems(),String.valueOf(3));
    }

    @Test(groups = "CorrectUser_LogIn")
    public void deleteItemFromCart(){
        log.info("Positive test for adding items to cart");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        inventoryPage.addbikeLightToCart();
        inventoryPage.addboltShirtToCart();
        Assert.assertTrue(inventoryPage.isDeleteBackPackButtonIsDisplayed());
        Assert.assertTrue(inventoryPage.isDeleteBikeLightButtonIsDisplayed());
        Assert.assertTrue(inventoryPage.isDeleteBoltShirtButtonIsDisplayed());

        CartPage cartPage = new CartPage(driver,log);
        cartPage.cartPage();
        cartPage.removeBackPackCart();
        Assert.assertFalse(inventoryPage.isDeleteBackPackButtonIsDisplayed());
        Assert.assertEquals(inventoryPage.getValueOfCoutedItems(),String.valueOf(2));
        cartPage.continueShopping();

        InventoryAssertions.assertIfAddButtonIsVisible(inventoryPage.addBackPackToCartButton());

    }

    @Test(groups = "CorrectUser_LogIn")
    public void firstNameIsMissing(){
        log.info("Negative test for missing First Name");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();

        CartPage cartPage = new CartPage(driver,log);
        cartPage.cartPage();
        cartPage.goToCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver,log);
        checkoutInformationPage.clientForm("","Leszy","11-098");
        String actualErrorMessage = checkoutInformationPage.getErrorMessage();

        CheckOutInformationAssertions.assertMissingFirstNameError(actualErrorMessage);

    }

    @Test(groups = "CorrectUser_LogIn")
    public void lastNameIsMissing(){
        log.info("Negative test for missing Last Name");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();

        CartPage cartPage = new CartPage(driver,log);
        cartPage.cartPage();
        cartPage.goToCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver,log);
        checkoutInformationPage.clientForm("Kryspin","","11-098");
        String actualErrorMessage = checkoutInformationPage.getErrorMessage();

        CheckOutInformationAssertions.assertMissingLastNameError(actualErrorMessage);

    }

    @Test(groups = "CorrectUser_LogIn")
    public void postalCodeIsMissing(){
        log.info("Negative test for missing Last Name");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();

        CartPage cartPage = new CartPage(driver,log);
        cartPage.cartPage();
        cartPage.goToCheckout();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver,log);
        checkoutInformationPage.clientForm("Kryspin","Dyzio","");
        String actualErrorMessage = checkoutInformationPage.getErrorMessage();

        CheckOutInformationAssertions.assertMissingPostalCodeError(actualErrorMessage);

    }

}
