package assertions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartAssertions {

    public static void assertBackPackNameCart(String actualName){
        String expectedName = "Sauce Labs Backpack";
        Assert.assertTrue(actualName.contentEquals(expectedName));
    }

    public static void assertIfAddButtonIsVisible(WebElement button){

        Assert.assertTrue(button.isDisplayed());
    }
}
