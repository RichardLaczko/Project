package tests;

import driver.helper.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getInstance();

    @Before
    public void beforeTest() {
        driver = Driver.getInstance();
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void afterTest() {
//        driver=null;
        driver.quit();
        driver=null;
    }

}
