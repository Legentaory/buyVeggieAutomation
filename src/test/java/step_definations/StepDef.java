package step_definations;

import cucumberOptions.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

@RunWith(Cucumber.class)
public class StepDef {

    private final WebDriver driver;
    private final String url;

    public StepDef(){
        driver = Driver.driver;
        url = Driver.props.getProperty("url");
    }

    @Given("User is on GreenCart Landing Page")
    public void userIsOnGreenCartLandingPage() {

        driver.get(url);
    }

    @When("User searched for {string} Vegetable")
    public void userSearchedForVegetable(String input) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        searchBox.sendKeys(input);
    }

    @Then("{string} results are displayed")
    public void resultsAreDisplayed(String product) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> displayedItems = driver.findElements(By.xpath("//div[@class='products']//div[@class='product']"));
        WebElement productName = driver.findElement(By.xpath("//h4[@class='product-name']"));
        assert productName.getText().toLowerCase().contains(product.toLowerCase());
        System.out.println(displayedItems.size());
        assert displayedItems.size() == 1;

    }

    @And("Add items to cart")
    public void addItemsToCart() throws InterruptedException {
        Thread.sleep(1000);
        WebElement inputQuantity = driver.findElement(By.xpath("//input[@type='number']"));
        WebElement addCartBtn = driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
        WebElement plusBtn = driver.findElement(By.xpath("//a[@class='increment']"));
        WebElement minusBtn = driver.findElement(By.xpath("//a[@class='decrement']"));

        inputQuantity.clear();
        inputQuantity.sendKeys("2");
        assert inputQuantity.getAttribute("value").contains("2");
        minusBtn.click();
        assert inputQuantity.getAttribute("value").contains("1");
        plusBtn.click();
        assert inputQuantity.getAttribute("value").contains("2");
        addCartBtn.click();

    }

    @And("User proceed to checkout page for purchase")
    public void userProceedToCheckoutPageForPurchase() {
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='cart-icon']"));
        WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]"));

        cartIcon.click();
        proceedToCheckoutBtn.click();
    }

    @Then("verify selected {string} items are displayed in checkout page")
    public void verifySelectedItemsAreDisplayedInCheckoutPage(String arg0) {
        WebElement productName = driver.findElement(By.xpath("//p[@class='product-name']"));

        assert productName.getText().contains(arg0);
    }
}
