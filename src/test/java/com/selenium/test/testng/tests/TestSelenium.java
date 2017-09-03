package com.selenium.test.testng.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class TestSelenium {
    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        WebDriver driver = new FirefoxDriver(capabilities);

        driver.get("http://www.findlectures.com");
    }
}

