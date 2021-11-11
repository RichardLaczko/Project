import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    public static void main(String[] args) throws InterruptedException {

        String standardUserName = "standard_user";
        String password = "secret_sauce";

        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();

        String expectedLoginPageTitle = "Swag Labs";
        String actualLoginPageTitle = "";

        String expectedProductsLabel = "PRODUCTS";

        //Opens web page
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        actualLoginPageTitle = driver.getTitle();

        WebElement userNameFieldText = driver.findElement(By.id("user-name"));
        WebElement passwordFieldText = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameFieldText.sendKeys(standardUserName);
        passwordFieldText.sendKeys(password);

        loginButton.click();

        WebElement productsLabel = driver.findElement(By.xpath("//span[@class='title']"));

        Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
        Assert.assertEquals(expectedProductsLabel, productsLabel.getText());


        //Closes driver(chrome)
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Test is successful!!!");
    }

}
