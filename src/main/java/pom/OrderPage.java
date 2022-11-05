package pom;

import org.openqa.selenium.*;

public class OrderPage {

    private WebDriver driver;

    //адрес страницы создания заказа
    private final String urlOrderPage = "https://qa-scooter.praktikum-services.ru/order";

    //поле для ввода имени
    private final By inputForName = By.xpath(".//input[@placeholder='* Имя']");

    //поле для ввода фамилии
    private final By inputForSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле для ввода адрес
    private final By inputForAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле для выбора станции метро
    private final By inputForMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //поле для ввода телефона
    private final By inputForPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка Далее
    private final By nextButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");

    //заголовок второго этапа создания заказа Про аренду
    private final By rentHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");

    //поле для выбора даты аренды
    private final By inputStartDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле для выбора даты аренды
    private final By periodOfRent = By.xpath(".//div[@class='Dropdown-placeholder']");

    //опция Сутки при выборе периода
    private final By oneDayOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");

    //опция Двое суток при выборе периода
    private final By twoDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");

    //опция Трое суток при выборе периода
    private final By threeDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");

    //опция Четверо суток при выборе периода
    private final By fourDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='четверо суток']");

    //опция Пятеро суток при выборе периода
    private final By fiveDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='пятеро суток']");

    //опция Шестеро суток при выборе периода
    private final By sixDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='шестеро суток']");

    //опция Пятеро суток при выборе периода
    private final By sevenDaysOption = By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']");

    //чекбокс для выбора черного цвета самоката
    private final By blackScooter = By.xpath(".//input[@id='black']");

    //чекбокс для выбора серого цвета самоката
    private final By greyScooter = By.xpath(".//input[@id='grey']");

    //поле для ввода комментария для курьера
    private final By courierCommentary = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка Заказать итогового оформления заказа
    private final By makeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //кнопка Да согласия на оформление заказа
    private final By yesToOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //текст подтверждения заказа Заказ оформлен
    private final By confirmationOfOrder = By.xpath(".//div[(text()= 'Заказ оформлен')]");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public By getRentHeader() {
        return rentHeader;
    }

    public String getUrlOrderPage() {
        return urlOrderPage;
    }
    public void fillName(String name){

        driver.findElement(inputForName).sendKeys(name);
    }

    public void fillSurname(String surname){

        driver.findElement(inputForSurname).sendKeys(surname);
    }

    public void fillAddress(String address){

        driver.findElement(inputForAddress).sendKeys(address);
    }

    public void fillPhoneNumber(String phoneNumber){

        driver.findElement(inputForPhoneNumber).sendKeys(phoneNumber);
    }

    public void fillMetroStation(String metroStation){

        driver.findElement(inputForMetroStation).sendKeys(metroStation);
        driver.findElement(inputForMetroStation).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(inputForMetroStation).sendKeys(Keys.ENTER);
    }

    public void fillInputsFirstStep(String name, String surname, String address, String metroStation, String phoneNumber){
        fillName(name);
        fillSurname(surname);
        fillAddress(address);
        fillPhoneNumber(phoneNumber);
        fillMetroStation(metroStation);
    }

    public void clickButtonNext(){
        driver.findElement(nextButton).click();
    }

    public void fillInputStartDate(String date){
        driver.findElement(inputStartDate).sendKeys(date);
        driver.findElement(inputStartDate).sendKeys(Keys.ENTER);
    }

    public void chooseBlackScooter(){
        driver.findElement(blackScooter).click();
    }

    public void chooseGreyScooter(){
        driver.findElement(greyScooter).click();
    }

    public void choiceOfColor(int mark){
        switch (mark) {
            case 1: chooseBlackScooter();
                break;
            case 2: chooseGreyScooter();
                break;
            default:
                break;
        }
    }

    public void fillCommentary(String commentary){

        driver.findElement(courierCommentary).sendKeys(commentary);
    }

    public void fillPeriodOfRent(int days){
        driver.findElement(periodOfRent).click();
        switch (days){
            case 2: driver.findElement(twoDaysOption).click();
                break;
            case 3: driver.findElement(threeDaysOption).click();
                break;
            case 4: driver.findElement(fourDaysOption).click();
                break;
            case 5: driver.findElement(fiveDaysOption).click();
                break;
            case 6: WebElement element6 = driver.findElement(sixDaysOption);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element6);
                driver.findElement(sixDaysOption).click();
                break;
            case 7: WebElement element7 = driver.findElement(sevenDaysOption);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element7);
                driver.findElement(sevenDaysOption).click();
                break;
            default:
                driver.findElement(oneDayOption).click();
                break;
        }
    }

    public void clickMakeOrderButton(){

        driver.findElement(makeOrderButton).click();
    }

    public void sayYesToOrderButton(){
        driver.findElement(yesToOrderButton).click();
    }

    public By getConfirmationOfOrder() {
        return confirmationOfOrder;
    }
}
