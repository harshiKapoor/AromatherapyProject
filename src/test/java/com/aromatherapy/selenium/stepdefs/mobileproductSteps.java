package com.aromatherapy.selenium.stepdefs;

import com.aromatherapy.library.Utility;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import com.aromatherapy.selenium.pages.products;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class mobileproductSteps {
    private WebDriver driver;
    public products products;
    private String pageTitle = "Aromatherapy";

    @Given("^I view site on mobile viewport$")
    public void i_view_site_on_mobile_viewport() throws Throwable {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iphone5");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(capabilities);
        products = new products(driver);
        Utility.captureScreenshot(driver,"mobileScreenShot");
        assertEquals(pageTitle,driver.getTitle());
        driver.quit();

    }
}
