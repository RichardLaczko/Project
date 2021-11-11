package screens;

import driver.helper.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage3 {
    private WebDriver driver = Driver.getInstance();

    public CheckOutPage3() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public CheckOutPage3 checkLastCheckOutTitle(String expectedName) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedName, title.getText());
        System.out.println(title.getText());
        return this;
    }

    public InventoryPage goBackToInventoryPage() throws InterruptedException {
        Thread.sleep(1000);
        backToProductsButton.click();
        return new InventoryPage();
    }

}
