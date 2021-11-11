package tests;

import driver.helper.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getInstance();

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    @Before
    public void beforeTest() {
        Driver.getInstance().get("https://www.saucedemo.com/");
    }

    @After
    public void afterTest() {
        getDriver().quit();
        Driver.setDriverToNull();
    }

}
