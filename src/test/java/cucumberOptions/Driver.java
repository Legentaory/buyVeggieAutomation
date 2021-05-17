package cucumberOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    public static WebDriver driver;

    public static Properties props;

    public static void initialize() throws IOException {
        WebDriverManager.chromedriver().setup();
        Driver.driver = new ChromeDriver();
        Driver.props = new Properties();
        Driver.props.load(new FileInputStream("src/test/java/cucumberOptions/global.properties"));
    }
}
