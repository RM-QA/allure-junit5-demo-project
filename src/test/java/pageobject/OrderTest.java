package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {
    OrderPage orderPage = new OrderPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("http://51.250.6.164:3000/signin");
        Selenide.localStorage().setItem("jwt", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZWhhYiIsImV4cCI6MTcwNTA3MzIzMywiaWF0IjoxNzA1MDU1MjMzfQ.gqRKfcfst77MJlfDH_-_0rtkyZjiL0slfWlSdBhqS0RPP7w-Gh9bum0KQbkRW3nCIBkFooqWUPQ-tNPjsLZwEA");
        Selenide.refresh();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void createOrderWithValidData() {
        orderPage.nameField.sendKeys("Jasmen");
        orderPage.phoneField.sendKeys("51245879");
        orderPage.commentField.sendKeys("please call when you arrived");
        orderPage.orderButton.click();
        orderPage.orderButton.shouldBe(Condition.exist, visible);
        orderPage.OkButtonInCreateOrderSuccessfullyPopup.click();
    }

    @Test
    public void checkingOrderId123NotFound() {

        orderPage.statusButton.click();
        orderPage.searchTheOrderCode.sendKeys("123");
        orderPage.searchOrderCodeTrackingButton.click();
        orderPage.OrderNotFoundPage.shouldBe(Condition.visible);
        orderPage.logOutButton.click();
    }

    @Test
    public void creatingFailedOrderAndOrderButtonIsDisabled() {
        orderPage.phoneField.sendKeys("1234");
        orderPage.nameField.sendKeys("9");
        orderPage.commentField.sendKeys("call before arriving");
        orderPage.orderButton.shouldBe(Condition.disabled);
        orderPage.nameField.clear();
        orderPage.phoneField.clear();
    }
}
