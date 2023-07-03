import Pages.*;
import assertions.CheckOutInformationAssertions;
import assertions.CheckoutCompleteAssertions;
import assertions.CheckoutOverviewAssertions;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @BeforeMethod(groups = "CorrectUser_LogIn")
    public void logIntoApplication(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");
    }

    @Test(groups = "CorrectUser_LogIn")
    public void fillCheckoutInformation(){
        log.info("Positive test for adding items to cart");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        inventoryPage.addbikeLightToCart();
        inventoryPage.addboltShirtToCart();

        CartPage cartPage = new CartPage(driver, log);
        cartPage.cartPage();
        cartPage.goToCheckout();


        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver,log);
        CheckOutInformationAssertions.assertPageTitle(checkoutInformationPage.checkoutInformationTitle());
        checkoutInformationPage.clientForm("Adam","Leszy","11-098");

        CheckoutOverviewAssertions.assertThatUserIsRedirectToCorrectURL(driver.getCurrentUrl());
    }

    @Test(groups = "CorrectUser_LogIn")
    public void makeOrderTest(){
        log.info("Positive test for adding items to cart");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        inventoryPage.addBackPackToCart();
        inventoryPage.addbikeLightToCart();
        inventoryPage.addboltShirtToCart();

        CartPage cartPage = new CartPage(driver, log);
        cartPage.cartPage();
        cartPage.goToCheckout();


        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver,log);
        CheckOutInformationAssertions.assertPageTitle(checkoutInformationPage.checkoutInformationTitle());
        checkoutInformationPage.clientForm("Adam","Leszy","11-098");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver, log);
        checkoutOverviewPage.finishButtonClick();

        CheckoutCompleteAssertions.assertThatUserIsRedirectToCorrectURL(driver.getCurrentUrl());

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver, log);
        String actualOrderMessage = checkoutCompletePage.orderMessageText();

        CheckoutCompleteAssertions.assertIfOrderWasCreated(actualOrderMessage);
    }
}
