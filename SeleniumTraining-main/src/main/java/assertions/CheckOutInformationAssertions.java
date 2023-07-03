package assertions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckOutInformationAssertions {

    public static void assertPageTitle(String actualTitle){
        String expectedTitle = "Checkout: Your Information";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public static void assertIfButtonIsVisible(WebElement button){
        Assert.assertTrue(button.isDisplayed());
    }

    public static void assertMissingFirstNameError(String actualError){
        String expectedError = "Error: First Name is required";
        Assert.assertEquals(actualError,expectedError);
    }

    public static void assertMissingLastNameError(String actualError){
        String expectedError = "Error: Last Name is required";
        Assert.assertEquals(actualError,expectedError);
    }

    public static void assertMissingPostalCodeError(String actualError){
        String expectedError = "Error: Postal Code is required";
        Assert.assertEquals(actualError,expectedError);
    }
}
