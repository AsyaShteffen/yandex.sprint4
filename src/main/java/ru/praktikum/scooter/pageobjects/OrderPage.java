package ru.praktikum.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;
    //  Локатор для верхней кнопки "Заказать"
    private final By orderButtonHeader = By.className("Button_Button__ra12g");
    //  Локатор для нижней кнопки "Заказать"
    private final By orderButtonBottom = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    // Локатор для поля ввода Имя
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    // Локатор для поля ввода Фамилия
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    // Локатор для поля ввода Адрес
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор для поля ввода станции метро
    private final By metroField = By.xpath("//input[@class='select-search__input']");
    // Локатор на выбор станции
    private final By stationSelect = By.xpath("//div[@class='select-search__select']/ul/li/button");
    // Локатор для поля ввода телефона
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //  Локатор для кнопки "далее"
    private final By saveButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    //  Локатор для даты доставки
    private final By deliveryDateField = By.xpath("//div[@class = 'react-datepicker__input-container']/input");
    // Локатор для ячейки даты
    private final By deliveryDateCell = By.xpath("//div[@class='react-datepicker__week'][2]/div[1]");
    //  Локатор для выпадающего меню срок аренды
    private final By durationOrderField = By.xpath("//div[@class='Dropdown-root']");
    // Локатор на ячейку длительности заказа
    private final By durationCell = By.xpath("//div[@class='Dropdown-menu']/div");
    //  Локатор для кнопки "Заказать"
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    //  Локатор на диалог
    private final By yesInDialog = By.xpath("//div[@class = 'Order_Modal__YZ-d3']");
    private final By confirmationDialog = By.className("Order_Modal__YZ-d3");
    // Локатор на кнопку принятия кукис
    private final By confirmCookies = By.id("rcc-confirm-button");

    //конструктор OrderScooter
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод клика на кнопку order
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void confirmCookies() {
        driver.findElement(confirmCookies).click();
    }

    public void scrollToMiddleButton() {
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // метод клика на кнопку Заказать в разделе "Как это работает"
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonBottom).click();
    }

    //ввод имени в поле
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //ввод фамилии в поле
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //ввод адреса в поле
    public void setAdress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //клик и выбор метро
    public void setMetro() {
        driver.findElement(metroField).click();
        driver.findElement(stationSelect).click();
    }

    //ввод номера телефона в поле
    public void setPhoneNumber(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    //клик на кнопку Далее
    public void clickNextButton() {
        driver.findElement(saveButton).click();
    }

    //ввода даты доставки самоката
    public void setDeliveryDate() {
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateCell).click();
    }

    //метод выбора продолжительности заказа
    public void setDurationOrder() {
        driver.findElement(durationOrderField).click();
        driver.findElement(durationCell).click();
    }

    //метод клика на кнопку подтвержения заказа самоката
    public void clickOrderScooterButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesInDialog() {
        driver.findElement(yesInDialog).click();
    }

    public Boolean isPanelVisible() {
        return driver.findElement(confirmationDialog).isDisplayed();
    }
}
