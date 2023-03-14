package ru.praktikum.scooter.tests;

import ru.praktikum.scooter.pageobjects.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderTests {
    OrderPage orderPage;
    WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderTests(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static String[][] gerOrderData() {
        return new String[][]{
                {"Ася", "Штеффен", "Омск", "89134652586"},
                {"Ляля", "Митрофанова", "Тара", "89236652576"}
        };
    }

    @Before
    public void before() {
        //драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу приложения
        driver.get("https://qa-scooter.praktikum-services.ru");
        //объект класса главной страницы
        orderPage = new OrderPage(driver);
    }

    @Test
    public void orderPositiveOne() {
        orderPage.clickOrderButtonHeader();
        createOrder();
    }

    @Test
    public void orderPositiveMiddleButton() {
        orderPage.scrollToMiddleButton();
        orderPage.clickOrderButtonMiddle();
        createOrder();
    }
    //метод для заполнения информации о пользователе
    private void setUserInfo() {
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAdress(address);
        orderPage.setMetro();
        orderPage.setPhoneNumber(phone);
    }
    // метод для заполнения информации о заказе
    private void setOrderInfo() {
        orderPage.setDeliveryDate();
        orderPage.setDurationOrder();
    }
    // метод для заказа + проверки успешности
    private void checkOrderConfirmation() {
        orderPage.clickOrderScooterButton();
        orderPage.clickYesInDialog();
        orderPage.isPanelVisible();
    }
    private void createOrder() {
        orderPage.confirmCookies();
        setUserInfo();
        orderPage.clickNextButton();
        setOrderInfo();
        checkOrderConfirmation();
    }

    // Закрыть браузер
    @After
    public void after() {
        driver.quit();
    }
}