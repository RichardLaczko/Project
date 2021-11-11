package tests;

import org.junit.Test;
import screens.*;

public class LoginPageTests extends BaseTest {

    String MessageWrong = "Epic sadface: Username and password do not match any user in this service";
    String MessageBlocked = "Epic sadface: Sorry, this user has been locked out.";
    String[] CorrectUsername = new String[]{"standard_user", "problem_user",
                                            "performance_glitch_user", "locked_out_user"};
    String CorrectPassword = "secret_sauce";
    String ItemHighestPrice = "Sauce Labs Fleece Jacket";
    String ItemLowestPrice = "Sauce Labs Onesie";
    String ItemLastFromABC = "Test.allTheThings() T-Shirt (Red)";
    String ItemFirstFromABC = "Sauce Labs Backpack";

    public <inventoryPage> inventoryPage logIn(int i) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(CorrectUsername[i])
                .enterLoginPassword(CorrectPassword);
        InventoryPage inventoryPage = loginPage.goToInventoryPage();
        Thread.sleep(1000);
        return (inventoryPage) inventoryPage;
    }

    @Test
    public void checkPrices() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.getThePricesOfTheItems();
    }

    @Test
    public void verifyIfCartRemembersYourOrderAfterLogOut() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.clickOnBackPackBuyButton();
        inventoryPage.goBackToTheLoginPage();

        InventoryPage secondLogIN = logIn(0);
        CartPage cartPage = secondLogIN.goToCartPage();
        cartPage.checkItemName("Sauce Labs Backpack");
    }

    @Test
    public void buyTheBackPack() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.clickOnBackPackBuyButton();
        CartPage cartPage = new InventoryPage().goToCartPage();
        cartPage.checkTitle("YOUR CART");

        CheckOutPage1 checkOutPage1= cartPage.goToCheckout1();
        checkOutPage1.enterFirstName("A");
        checkOutPage1.enterLastName("K");
        checkOutPage1.enterPostalCode("44");

        Thread.sleep(1500);

        CheckOutPage3 checkOutPage3 = checkOutPage1.goToCheckout2().goToCheckout3(); // lol
        checkOutPage3.checkLastCheckOutTitle("CHECKOUT: COMPLETE!");
        checkOutPage3.goBackToInventoryPage();

        Thread.sleep(3000);

    }

    @Test
    public void checkOrderByOptions4() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.selectFromSortBy(3);
        inventoryPage.checkFirstItemName(ItemHighestPrice);
    }

    @Test
    public void checkOrderByOptions3() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.selectFromSortBy(2);
        inventoryPage.checkFirstItemName(ItemLowestPrice);
    }

    @Test
    public void checkOrderByOptions2() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.selectFromSortBy(1);
        inventoryPage.checkFirstItemName(ItemLastFromABC);
    }

    @Test
    public void checkOrderByOptions1() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.selectFromSortBy(0);
        inventoryPage.checkFirstItemName(ItemFirstFromABC);
    }

    @Test
    public void checkIncorrectPasswordError() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(CorrectUsername[0])
                .enterLoginPassword("afwfwfff") //entering random password
                .clickLoginButtonStay()
                .checkErrorMessage(MessageWrong)
                .enterLoginPassword(CorrectPassword); //entering the correct password

        //checking that the Login worked correctly
        InventoryPage inventoryPage = loginPage.goToInventoryPage();
        inventoryPage.checkProductsLabel("PRODUCTS");

        Thread.sleep(2000);
    }

    @Test
    public void checkAllTheValidUsernames() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        for(int i=0; i<3; i++){
            InventoryPage inventoryPage = logIn(i);
            inventoryPage.goBackToTheLoginPage();
            Thread.sleep(1000);
        }

        //Checking the Blocked User
        loginPage.enterUsername(CorrectUsername[3])
                .enterLoginPassword(CorrectPassword)
                .clickLoginButtonStay()
                .checkErrorMessage(MessageBlocked);

    }

    @Test
    public void lookABug() throws InterruptedException {
        InventoryPage inventoryPage = logIn(0);
        inventoryPage.clickOnBikeLightBuyButton();
        inventoryPage.goBackToTheLoginPage();

        InventoryPage secondLogIN = logIn(1);  //we are loging in with a different user
        CartPage cartPage = secondLogIN.goToCartPage();
        cartPage.checkItemName("");
    }
}

