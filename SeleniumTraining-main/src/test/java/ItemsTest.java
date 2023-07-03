import Pages.InventoryPage;
import Pages.LoginPage;
import assertions.InventoryAssertions;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemsTest extends BaseTest {

    @BeforeMethod(groups = "CorrectUser_LogIn")
    public void logIntoApplicationCorrectUser(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");
    }

    @BeforeMethod(groups = "ProblemUser_LogIn")
    public void logIntoApplicationProblemUser(){
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("problem_user","secret_sauce");
    }

    @Test(groups = "CorrectUser_LogIn")
    public void checkBackPackItemName(){
        log.info("Performing adding Back pack action to cart.");

        InventoryPage inventoryPage = new InventoryPage(driver, log);
        String actualBackPackName = inventoryPage.getNameForBackPack();
        InventoryAssertions.assertBackPackName(actualBackPackName);
    }
}
