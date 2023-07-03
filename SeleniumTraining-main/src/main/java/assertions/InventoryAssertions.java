package assertions;

import Pages.InventoryPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InventoryAssertions {
    public static void assertThatUserOnCorrectURL(String actualUrl){
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl,expectedURL);
    }

    public static void assertBackPackDescritpion(String actualDescription){
        String expectedDescritpion = "carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertTrue(actualDescription.contains(expectedDescritpion),
                "Selector does not contain the expected phrase");
    }

    public static void assertBackPackName(String actualName){
        String expectedName = "Sauce Labs Backpack";
        Assert.assertTrue(actualName.contains(expectedName),
                "Selector does not contain the expected phrase");
    }

    public static void assertIfAddButtonIsVisible(WebElement button){
        Assert.assertTrue(button.isDisplayed());
    }
}
