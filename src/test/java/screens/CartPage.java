package screens;

import driver.helper.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver = Driver.getInstance();

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemName;


    public CheckOutPage1 goToCheckout1() throws InterruptedException {
        Thread.sleep(1000);
        checkOutButton.click();
        return new CheckOutPage1();
    }

    public CartPage checkTitle(String expectedName) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedName, title.getText());
        System.out.println(title.getText());
        return this;
    }

    public CartPage checkItemName(String expectedName) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedName, itemName.getText());
        System.out.println(itemName.getText());
        return this;
    }

}
