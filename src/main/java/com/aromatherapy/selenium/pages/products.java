package com.aromatherapy.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class products {
    private WebDriver driver;
    private String baseUrl;
    private String NZDollar = "NZ Dollar";
    //locators
    @FindBy(id = "product_currencies")
    private WebElement productCurrencies;

    @FindBy(id= "product_details")
    private WebElement productDetails ;

    private String productBuyButton = "product_buy";

    public products(WebDriver driver) {
        this.driver = driver;
        baseUrl = "http://localhost:3000/src/main/resources/";
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.get(baseUrl);
        waitForPageToLoad();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);");
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product")));
    }

    // get default currency
    public String getDefaultCurrencyFromCurrencyOptions() {
        Select dropDownList = new Select(productCurrencies);
        return (dropDownList.getFirstSelectedOption().getText());
    }

    // select currency from options
    public String selectCurrencyFromCurrencyOptions() {
        Select dropDownList = new Select(productCurrencies);
        dropDownList.selectByValue(NZDollar);
        return dropDownList.getFirstSelectedOption().getText();
    }

    // get price with currency for all products
    public ArrayList<String> getPriceAndCurrencyForProducts() {
        WebElement product_list = productDetails;
        List<WebElement> products = product_list.findElements(By.tagName("p"));
        ArrayList<String> values = new ArrayList<String>();
        for (WebElement p : products) {
            values.add(p.getText());
        }
        return values;
    }

    // buy product
    public String clickBuyButton() {
        List<WebElement> buyButton = driver.findElements(By.className(productBuyButton));
        buyButton.get(0).click();
        return driver.switchTo().alert().getText();
    }

}
