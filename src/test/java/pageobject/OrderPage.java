package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    public SelenideElement createOrderPage = $x("//div[contains(@class,'new-order-page')]");
    public SelenideElement nameField = $x("//input[@data-name='username-input']");
    public SelenideElement phoneField = $x("//input[@data-name='phone-input']");
    public SelenideElement commentField = $x("//input[@data-name='comment-input']");
    public SelenideElement orderButton = $x("//button[@data-name='createOrder-button']");
    public SelenideElement ENLanguageButtonActive = $x("//button[@class='language__button language__button_active']");
    public SelenideElement RULanguageButtonFalse = $x("//button[@class='language__button false']");
    public SelenideElement createOrderSuccessfullyPopup = $x("//div[@data-name='orderSuccessfullyCreated-popup']");
    public SelenideElement OkButtonInCreateOrderSuccessfullyPopup = $x("//button[@data-name='orderSuccessfullyCreated-popup-ok-button']");
    public SelenideElement orderButtonDisable = $x("//button[@disabled='']");
    public SelenideElement statusButton = $x("//button[@data-name='openStatusPopup-button']");
    public SelenideElement searchOrderCodePopup = $x("//div[@data-name='searchOrder-popup']");
    public SelenideElement searchTheOrderCode = $x("//input[@data-name='searchOrder-input']");
    public SelenideElement searchOrderCodeTrackingButton = $x("//button[@data-name='searchOrder-submitButton']");
    public SelenideElement OrderNotFoundPage = $x("//main[@data-name='orderNotFound-container']");
    public SelenideElement logOutButton = $x("//a[@data-name='logout-button']");


}
