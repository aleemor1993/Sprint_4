package accordionqa;

import main.BrowserRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class CheckQuestionsAndAnswers {

    private final String expectedText;

    private final int elem;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public CheckQuestionsAndAnswers(int elem, String expectedText){

        this.expectedText = expectedText;
        this.elem = elem;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",},
                { 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTextForAccordionElements() {

        WebDriver driver = browserRule.getDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookieButton();
        mainPage.scrollToAccordionHeader();
        mainPage.clickButton(mainPage.getOfAccordionQuestion(elem));

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(mainPage.getOfAccordionAnswer(elem))));

        Assert.assertEquals(expectedText, driver.findElement(mainPage.getOfAccordionAnswer(elem)).getText());
    }

}

