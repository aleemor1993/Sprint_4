package makeorder;

import main.BrowserRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;
import pom.OrderPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class MakeOrder {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    private final String metroStation;

    private final String startDate;

    //количество суток аренды: от 1 до 7
    private final int day;

    //цвет: 1 - черный, 2 - серый
    private final int color;

    private final String commentary;

    private final String button;

    public MakeOrder(String button, String name, String surname, String address, String metroStation,
                     String phone, String startDate, int day, int color, String commentary) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.startDate = startDate;
        this.day = day;
        this.color = color;
        this.commentary = commentary;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                { "In header", "Черника", "Черникова", "Черниковск", "Театральная", "+79999999999", "12.12.2022",
                        7, 3, "Что-то для курьера"},
                { "Below page", "Манго", "Мангов", "Мангово", "Университет", "+7911111111", "11.11.2022",
                        1, 1, ""},
        };
    }

    @Test
    public void makeOrderFull() throws InterruptedException {

        WebDriver driver = browserRule.getDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookieButton();
        mainPage.chooseOrderButton(button);

        OrderPage orderPage = new OrderPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(), orderPage.getUrlOrderPage());

        orderPage.fillInputsFirstStep(name, surname, address, metroStation, phone);
        orderPage.clickButtonNext();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderPage.getRentHeader())));

        orderPage.fillInputStartDate(startDate);
        orderPage.choiceOfColor(color);
        orderPage.fillCommentary(commentary);
        orderPage.fillPeriodOfRent(day);

        orderPage.clickMakeOrderButton();
        orderPage.sayYesToOrderButton();

        Assert.assertTrue(driver.findElement(orderPage.getConfirmationOfOrder()).isDisplayed());

        Thread.sleep(5000);
    }
}

