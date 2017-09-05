package findlectures;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Findlectures {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Set driver properties to use geckodriver
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Read in list of search terms from file
        FileInputStream stream = new FileInputStream("src/main/java/findlectures/seconds.csv");
        String data = IOUtils.toString(stream);
        String data1[] = data.split(",");

        //iterate through search terms
        for (String str : data1) {
            driver.get("http://www.findlectures.com");
            WebElement element = driver.findElement(By.className("prompt"));
            element.sendKeys(str);
            element.sendKeys(Keys.RETURN);


            //TODO Get Selenium explicitly wait for results to load
            Thread.sleep(2000);

            //WebElement element2 = wait.until(ExpectedConditions.visibilityOf(element));
            //element2.submit();

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filename = "screenshots/" + str + new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
            try {
                FileUtils.copyFile(scrFile, new File(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
    }
}
