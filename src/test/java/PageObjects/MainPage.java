package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //  локатор для аккордеона
    public Boolean isPanelVisible(int index) {
        By locator = By.id("accordion__panel-" + index);
        return driver.findElement(locator).isDisplayed();
    }

    // метод клика на шеврон
    public void clickPanel(int index) {
        By locator = By.id("accordion__heading-" + index);
        driver.findElement(locator).click();
    }
}