package assertions;

import org.testng.Assert;

public class LoginAssertions {
    public static void assertThatUserIsRedirectToCorrectURL(String actualUrl){
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl,expectedURL);
    }

    public static void assertErrorMissingPasswordTextIsCorrect(String actualMissingErrorText){
        String expectedMissingPasswordError = "Epic sadface: Password is required";
        Assert.assertTrue(actualMissingErrorText.contains(expectedMissingPasswordError),
                "Selector does not contain the expected phrase");
    }

    public static void assertErrorMissingUserTextIsCorrect(String actualMissingErrorText){
        String expectedMissingPasswordError = "Epic sadface: Username is required";
        Assert.assertTrue(actualMissingErrorText.contains(expectedMissingPasswordError),
                "Selector does not contain the expected phrase");
    }

    public static void assertErrorTextLockedUser(String actualMissingErrorText){
        String expectedMissingPasswordError = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertTrue(actualMissingErrorText.contains(expectedMissingPasswordError),
                "Selector does not contain the expected phrase");
    }
}
