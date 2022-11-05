package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class MainPage {

    private WebDriver driver;

    //адрес главной страницы
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //блок страницы, в котором располагается аккордеон с вопросами
    private final By accordionHeader = By.xpath(".//div[@class='Home_FourPart__1uthg']");

    //кнопка принятия кук
    private final By cookieButton = By.xpath(".//button[@class ='App_CookieButton__3cvqF']");

    //кнопки аккордеона Вопросы о важном
    public final By howMuchAndHowToPayButton = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private final By howAboutSomeScootersButton = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private final By howToCalculateTimeOfRentButton = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    private final By isItPossibleToOrderScooterForTodayButton = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private final By howToChangeTimeOfRentButton = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private final By whatAboutChargeButton = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private final By howToCancelOrderButton = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    private final By whatAboutMCADButton = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");

    //ответы в аккордеоне Вопросы о важном
    public final By howMuchAndHowToPayText = By.id("accordion__panel-0");
    private final By howAboutSomeScootersText = By.id("accordion__panel-1");
    private final By howToCalculateTimeOfRentText = By.id("accordion__panel-2");
    private final By isItPossibleToOrderScooterForTodayText = By.id("accordion__panel-3");
    private final By howToChangeTimeOfRentText = By.id("accordion__panel-4");
    private final By whatAboutChargeText = By.id("accordion__panel-5");
    private final By howToCancelOrderText = By.id("accordion__panel-6");
    private final By whatAboutMCADText = By.id("accordion__panel-7");

    //кнопка создания заказа в верху страницы
    private final By startOrderButtonInHeader = By.xpath(".//button[@class ='Button_Button__ra12g']");

    //кнопка создания заказа в середине страницы
    private final By startOrderButtonBelowPage = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }

    public void scrollToAccordionHeader(){
        WebElement element = driver.findElement(accordionHeader);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToOrderButtonBelowPage(){
        WebElement element = driver.findElement(startOrderButtonBelowPage);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickButton(By button){
        driver.findElement(button).click();
    }

    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    public void clickStartOrderButtonInHeader(){
        driver.findElement(startOrderButtonInHeader).click();
    }

    public void startOrderButtonBelowPage(){
        driver.findElement(startOrderButtonBelowPage).click();
    }

    public By getOfAccordionQuestion(int question){
        switch (question){
            case 0: return howMuchAndHowToPayButton;
            case 1: return howAboutSomeScootersButton;
            case 2: return howToCalculateTimeOfRentButton;
            case 3: return isItPossibleToOrderScooterForTodayButton;
            case 4: return howToChangeTimeOfRentButton;
            case 5: return whatAboutChargeButton;
            case 6: return howToCancelOrderButton;
            case 7: return whatAboutMCADButton;
        };
        return null;
    }

    public By getOfAccordionAnswer(int answer){
        switch (answer){
            case 0: return howMuchAndHowToPayText;
            case 1: return howAboutSomeScootersText;
            case 2: return howToCalculateTimeOfRentText;
            case 3: return isItPossibleToOrderScooterForTodayText;
            case 4: return howToChangeTimeOfRentText;
            case 5: return whatAboutChargeText;
            case 6: return howToCancelOrderText;
            case 7: return whatAboutMCADText;
        };
        return null;
    }
}
