package Tests;

import PageObjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainTests {
    MainPage objHomePage;
    WebDriver driver;

    @Before
    public void before() {
        //драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Ищем раздел «Вопросы о важном» и скроллим до него
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //объект класса главной страницы приложения
        objHomePage = new MainPage(driver);
    }
// методы проверки аккордеон-элементов
    @Test
    public void checkAccordionZero() {
        objHomePage.clickPanel(0);
        Assert.assertTrue(objHomePage.isPanelVisible(0));
    }

    @Test
    public void checkAccordionOne() {
        objHomePage.clickPanel(1);
        Assert.assertTrue(objHomePage.isPanelVisible(1));

    }

    @Test
    public void checkAccordionTwo() {
        objHomePage.clickPanel(2);
        Assert.assertTrue(objHomePage.isPanelVisible(2));
    }

    @Test
    public void checkAccordionTree() {
        objHomePage.clickPanel(3);
        Assert.assertTrue(objHomePage.isPanelVisible(3));
    }

    @Test
    public void checkAccordionFore() {
        objHomePage.clickPanel(4);
        Assert.assertTrue(objHomePage.isPanelVisible(4));
    }

    @Test
    public void checkAccordionFive() {
        objHomePage.clickPanel(5);
        Assert.assertTrue(objHomePage.isPanelVisible(5));
    }

    @Test
    public void checkAccordionSix() {
        objHomePage.clickPanel(6);
        Assert.assertTrue(objHomePage.isPanelVisible(6));
    }

    @Test
    public void checkAccordionSeven() {
        objHomePage.clickPanel(7);
        Assert.assertTrue(objHomePage.isPanelVisible(7));
    }
    // Закрыть браузер
    @After
    public void after() {
        driver.quit();
    }
}
