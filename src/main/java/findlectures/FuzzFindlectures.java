import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Random;


public class FuzzFindlectures {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);


        for (int i = 0; i < 4; i++) {
            driver.get("http://www.findlectures.com");
            List<WebElement> elements = driver.findElements(By.tagName("a"));
            elements.get(new Random().nextInt(elements.size())).click();
        }
    }
}
