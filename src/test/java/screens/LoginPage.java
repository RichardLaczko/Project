package screens;

import driver.helper.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver = Driver.getInstance();

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameFieldText;

    @FindBy(id = "password")
    private WebElement passwordFieldText;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement ErrorMessage;


    //This method is checking if the Error Message is correct
    public LoginPage checkErrorMessage(String Message) throws InterruptedException {
        String text = ErrorMessage.getText();
        Assert.assertEquals(Message, text);

        System.out.println(text);
        Thread.sleep(1000);
        return this;

    }//This method will enter the username
    public LoginPage enterUsername(String username) {
        userNameFieldText.clear();
        userNameFieldText.sendKeys(username);
        return this;
    }

    //This method will enter the password
    public LoginPage enterLoginPassword(String password) {
        passwordFieldText.clear();
        passwordFieldText.sendKeys(password);
        return this;
    }

    //This method will redirect the user to inventory page after successful login
    public InventoryPage goToInventoryPage() throws InterruptedException {
        Thread.sleep(1000);
        loginButton.click();
        return new InventoryPage();
    }

    public LoginPage clickLoginButtonStay(){
        loginButton.click();
        return this;
    }

}
