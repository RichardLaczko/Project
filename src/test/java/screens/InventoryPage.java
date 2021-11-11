package screens;

import driver.helper.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage {

    private WebDriver driver = Driver.getInstance();

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productsLabel;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buyBackPack;

     @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement buyBikeLight;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    private WebElement sauceLabsBackpackTitle;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortByList;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement firstItem;

    private List<WebElement> sortBy = driver.findElements(By.xpath("//select[@class='product_sort_container']/option"));

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> prices;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemNames;

    public InventoryPage getThePricesOfTheItems(){
        for(int i=0;i<6;i++){
            System.out.println(itemNames.get(i).getText()+" item's price is: "+prices.get(i).getText());
        }
        return this;
    }

    public InventoryPage clickOnBackPackBuyButton(){
        buyBackPack.click();
        return this;
    }

    public InventoryPage clickOnBikeLightBuyButton(){
        buyBikeLight.click();
        return this;
    }

    //This method will redirect the user to the Cart Page
    public CartPage goToCartPage() throws InterruptedException {
        Thread.sleep(1000);
        cartIcon.click();
        return new CartPage();
    }

    public LoginPage goBackToTheLoginPage() throws InterruptedException {
        menuButton.click();
        Thread.sleep(500);
        logOutButton.click();
        return new LoginPage();
    }

    public InventoryPage checkFirstItemName(String expectedName) {
        Assert.assertEquals(expectedName, firstItem.getText());
        System.out.println(firstItem.getText());
        return this;
    }

    public InventoryPage checkProductsLabel(String expectedName) {
        Assert.assertEquals(expectedName, productsLabel.getText());
        return this;
    }

    public InventoryPage selectFromSortBy(int index) throws InterruptedException {
        sortByList.click();
        Thread.sleep(2000);
        sortBy.get(index).click();
        Thread.sleep(2000);
        return this;
    }

    public InventoryPage clickAllOptionsFromTheBottomUp() throws InterruptedException {

//        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        Select select = new Select((WebElement) driver.findElements
                                                    (By.xpath("//select[@class='product_sort_container']")));

        for(int i=3;i>=0;i--){
            sortByList.click();
            select.selectByIndex(i);
            Thread.sleep(2000);
        }
        return this;
    }

}
