import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class queryFLsnap {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        //search findlectures for a term and screen snap the results


        driver.get("http://www.findlectures.com");
        String searchtext = ("Testing Your Website");
        WebElement element = driver.findElement(By.className("prompt"));
        element.sendKeys(searchtext);
        element.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = searchtext + new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
        try {
            FileUtils.copyFile(scrFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
