package com.aromatherapy.selenium.stepDefs;

import com.aromatherapy.selenium.pages.products;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class productSteps {
    private WebDriver driver;
    public products products;
    private String selectedCurrency;
    private String defaultSelectedCurrency;
    private String alertMessage;
    private String pageTitle = "Aromatherapy";


    @Given("^I land on products page$")
    public void i_land_on_products_page() throws Throwable {
        driver = new ChromeDriver();
        products = new products(driver);
        assertEquals(pageTitle,driver.getTitle());
    }
    @When("^I select currency$")
    public void i_select_currency() throws Throwable {
        selectedCurrency = products.selectCurrencyFromCurrencyOptions();
    }

    @Then("^I should see prices displayed in the selected currency$")
    public void i_should_see_prices_displayed_in_the_selected_currency() throws Throwable {
        String currency_CountryAbbrevation = selectedCurrency.substring(0,2);
        ArrayList<String> priceInSelectedCurrency = products.getPriceAndCurrencyForProducts();
        for(String curr: priceInSelectedCurrency) {
            boolean foundCurrency_countryAbbrevation = curr.contains(currency_CountryAbbrevation);
            assertEquals(true,foundCurrency_countryAbbrevation);
        }
        driver.quit();
    }

    @When("^I dont change the currency$")
    public void i_dont_change_the_currency() throws Throwable {
        defaultSelectedCurrency = products.getDefaultCurrencyFromCurrencyOptions();
    }

    @Then("^I should see prices displayed out in AU Dollars$")
    public void i_should_see_prices_displayed_out_in_AU_Dollars() throws Throwable {
        String currency_CountryAbbrevation = defaultSelectedCurrency.substring(0,2);
        ArrayList<String> defaultCurrencyPrice = products.getPriceAndCurrencyForProducts();
        for(String curr : defaultCurrencyPrice) {
            boolean foundCurrency_countryAbbrevation =  curr.contains(currency_CountryAbbrevation);
            assertEquals(true,foundCurrency_countryAbbrevation);
        }
        driver.quit();
    }

    @When("^I click buy button$")
    public void i_click_buy_button() throws Throwable {
        alertMessage = products.clickBuyButton();
    }

    @Then("^I should get an alert with product purchased$")
    public void i_should_get_an_alert_with_product_purchased() throws Throwable {
        boolean alertMessageContainsProductName  = alertMessage.contains("Essential Oils");
        assertEquals(true,alertMessageContainsProductName);
        driver.switchTo().alert().accept();
        driver.quit();
    }


}
