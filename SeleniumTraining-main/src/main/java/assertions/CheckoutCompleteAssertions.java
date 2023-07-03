package assertions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutCompleteAssertions {
    public static void assertThatUserIsRedirectToCorrectURL(String actualUrl){
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(actualUrl,expectedURL);
    }

    public static void assertIfOrderWasCreated(String actualMessage){
        String exprectedMessage = "Thank you for your order!";
        Assert.assertEquals(actualMessage, exprectedMessage);
    }

    public static void assertIfSiteTitleIsCorrect(String actualTitle){
        String expectedTitle = "Checkout: Complete!";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
