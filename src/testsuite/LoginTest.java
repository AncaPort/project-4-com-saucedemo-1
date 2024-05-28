package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * * 3. Write down the following test into ‘LoginTest’ class
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userSholdLoginSuccessfullyWithValid Credentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify the text “PRODUCTS”
        String expectedResult = "Products";
        String actualResult = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("user is not login successfully", expectedResult, actualResult);
    }

    /**
     * 2. verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on
     * page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Total Number of products are on page: " + productList.size());
        int expectedResult = 6;
        int actualResult = productList.size();
        Assert.assertEquals("Number of product did not match!", expectedResult, actualResult);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


