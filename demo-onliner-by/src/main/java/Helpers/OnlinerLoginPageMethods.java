package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlinerLoginPageMethods {
    private WebDriver webDriver;

    public OnlinerLoginPageMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickButton(String button) {

        By by = By.xpath(button);
        WebElement webElement = webDriver.findElement(by);
        webElement.click();
    }

    public void sendKeysInput(String field, String value) {

        By inputNameBy = By.xpath(field);
        WebElement inputWebElement = webDriver.findElement(inputNameBy);
        inputWebElement.sendKeys(value);
    }

    public String getResultErrorText(String textXpath) {
        By textResultErrorBy = By.xpath(textXpath);
        WebElement textResultErrorWebElement = webDriver.findElement(textResultErrorBy);
        return textResultErrorWebElement.getText();
    }
}