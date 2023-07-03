import Pages.LoginPage;
import assertions.LoginAssertions;
import base.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String username;
    String password;


    @Test
    public void loginTestCorrect(){
        log.info("Performing positive login to application.");

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","secret_sauce");
        String actualURL = driver.getCurrentUrl();
        LoginAssertions.assertThatUserIsRedirectToCorrectURL(actualURL);

    }

    @Test
    public void loginTestPasswordNotProvided(){
        log.info("Performing negative login to application with missing password.");

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("standard_user","");
        String actualErrorText = loginPage.errorField();
        LoginAssertions.assertErrorMissingPasswordTextIsCorrect(actualErrorText);

    }

    @Test
    public void loginTestUserNameNotProvided(){
        log.info("Performing negative login to application with missing user name.");

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("","secret_sauce");
        String actualErrorText = loginPage.errorField();
        LoginAssertions.assertErrorMissingUserTextIsCorrect(actualErrorText);

    }

    @Test
    public void loginTestUserIsDisabled(){
        log.info("Performing negative login to application with disabled user.");

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.loginPage();
        loginPage.loginForm("locked_out_user","secret_sauce");
        String actualErrorText = loginPage.errorField();
        LoginAssertions.assertErrorTextLockedUser(actualErrorText);

    }

}
