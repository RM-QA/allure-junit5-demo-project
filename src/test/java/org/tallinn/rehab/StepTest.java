package org.tallinn.rehab;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class StepTest {

    @Test
    // provide incorrect credential to check if  authorizationError-popup would display

    public void provideIncorrectCredentialsAndCheckingTheErrorMessage() {

        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name='username-input']").setValue("Tom Cruise");
        $x("//input[@data-name='password-input']").setValue("88888888");
        $x("//button[@data-name='signIn-button']").click();
        $x("//div[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);
        $x("//input[@data-name='username-input']").clear();
        $x("//input[@data-name='password-input']").clear();
    }

    @Test
    //Error checking using a minimum number of characters (1 character in username field)

    public void provideOneCharacterInUsernameFieldAndCorrectPasswordAndCheckingTheErrorMessage() {

        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name='username-input']").setValue("R");
        $x("//input[@data-name='password-input']").setValue("p14astwd63");
        $x("//span[@data-name='username-input-error']").shouldBe(Condition.exist, Condition.visible);
        $x("//span[text()='The field must contain  at least of characters: 2']");
        $x("//input[@data-name='username-input']").clear();
        $x("//input[@data-name='password-input']").clear();

    }

    @Test
    //Error checking using a minimum number of characters (1 character in password field)

    public void provideTwoCharacterInPasswordFieldAndCorrectUsernameAndCheckingTheErrorMessage() {

        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name='username-input']").setValue("rehab");
        $x("//input[@data-name='password-input']").setValue("62");
        $x("//span[contains(@class,'form-error form-error_active')]").shouldBe(Condition.exist, Condition.visible);
        //$x("//span[text()='The field must contain  at least of characters: 8']").shouldBe(Condition.exist,Condition.visible);
        $x("//input[@data-name='username-input']").clear();
        $x("//input[@data-name='password-input']").clear();

    }

    @Test
    // provide incorrect credential to check if  authorizationError-popup would display

    public void provideCorrectCredentialsAndCreateOrderPageShouldDisplay() {

        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name='username-input']").setValue("rehab");
        $x("//input[@data-name='password-input']").setValue("p14astwd63");
        $x("//button[@data-name='signIn-button']").click();
        $x("//div[contains(@class,'new-order-page')]").shouldBe(Condition.exist, Condition.visible);
        $x("//a[@data-name='logout-button']").click();

    }


    @Test
    // provide incorrect credential to check if  authorizationError-popup would display

    public void provideIncorrectCredentialsAndCloseThePopupErrorMessageAndLoginCorrectly() {

        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name='username-input']").setValue("jason momoa");
        $x("//input[@data-name='password-input']").setValue("66666666");
        $x("//button[@data-name='signIn-button']").click();
        $x("//div[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);
        $x("//button[@data-name='authorizationError-popup-close-button']").click();
        $x("//input[@data-name='username-input']").setValue("rehab");
        $x("//input[@data-name='password-input']").setValue("p14astwd63");
        $x("//button[@data-name='signIn-button']").click();
        $x("//div[contains(@class,'new-order-page')]").shouldBe(Condition.exist, Condition.visible);
        $x("//a[@data-name='logout-button']").click();


    }
}


