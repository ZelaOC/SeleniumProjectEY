package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class CheckoutInformationPage extends BasePage {

    private final By checkoutTitlePage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");
    private final By errorCommunicat = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");



    public CheckoutInformationPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void checkoutPage(){

        openUrl("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void clickContinueButton(){
        click(continueButton);
    }

    public void clickCancelButton(){
        click(cancelButton);
    }

    public String getErrorMessage(){
        return find(errorCommunicat).getText();
    }

    public String checkoutInformationTitle(){
        return find(checkoutTitlePage).getText();
    }

    public void clientForm(String firstname, String lastname, String postalcode){
        type(firstname, firstNameField);
        type(lastname, lastNameField);
        type(postalcode, postalCodeField);
        click(continueButton);
    }

}
