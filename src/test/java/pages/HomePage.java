package pages;

import java.util.*;

import cucumberOptions.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@class='products']//div[@class='product']")
    private List<WebElement> displayedItems;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement inputQuantity;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    private WebElement addCartBtn;

    @FindBy(xpath = "//a[@class='increment']")
    private WebElement plusBtn;

    @FindBy(xpath = "//a[@class='decrement']")
    private WebElement minusBtn;

    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

}
