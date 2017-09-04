import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class multiqueryFL {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        //search findlectures for a series of search terms and screen snap all the results
        String[] searches = new String[]{"4th Dimension/4D", "ABC", "ActionScript", "Apex", "APL", "AutoLISP", "Bash", "bc", "Bourne shell", "C shell", "CFML", "CL (OS/400)", "Clipper", "Common Lisp", "Eiffel", "Elixir", "Elm", "Euphoria", "Forth", "Icon", "IDL", "Inform", "Io", "J", "Korn shell", "Magic", "Maple", "ML", "MOO", "MQL4", "MUMPS", "NATURAL", "NXT-G", "OCaml", "OpenCL", "OpenEdge ABL", "Oz", "PL/I", "PowerShell", "Q", "REXX", "Ring", "RPG (OS/400)", "Rust", "Scheme", "Smalltalk", "SPARK", "SPSS", "Stata", "Tcl"};

        for (String searchtext : searches) {
            WebDriver driver = new FirefoxDriver(capabilities);
            driver.get("http://www.findlectures.com");
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
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.close();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
