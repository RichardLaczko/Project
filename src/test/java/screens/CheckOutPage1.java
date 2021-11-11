package screens;

import driver.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage1 {
    private WebDriver driver = Driver.getInstance();

    public CheckOutPage1() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckOutPage1 enterFirstName(String text) {
        firstName.sendKeys(text);
        return this;
    }

    public CheckOutPage1 enterLastName(String text) {
        lastName.sendKeys(text);
        return this;
    }

    public CheckOutPage1 enterPostalCode(String text) {
        postalCode.sendKeys(text);
        return this;
    }

    public CheckOutPage2 goToCheckout2() throws InterruptedException {
        Thread.sleep(1000);
        continueButton.click();
        return new CheckOutPage2();
    }

}
