package step_definations;

import cucumberOptions.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@SeleniumTest")
    public void beforeTest() throws IOException {
        Driver.initialize();
    }

    @After("@SeleniumTest")
    public void afterTest(){
        Driver.driver.quit();
    }
}
