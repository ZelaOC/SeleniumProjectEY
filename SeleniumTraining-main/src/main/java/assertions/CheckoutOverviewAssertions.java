package assertions;

import org.testng.Assert;

public class CheckoutOverviewAssertions {
    public static void assertThatUserIsRedirectToCorrectURL(String actualUrl){
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualUrl,expectedURL);
    }
}
