package screens;

import driver.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage2 {
    private WebDriver driver = Driver.getInstance();

    public CheckOutPage2() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckOutPage3 goToCheckout3() throws InterruptedException {
        Thread.sleep(1000);
        finishButton.click();
        return new CheckOutPage3();
    }
}
