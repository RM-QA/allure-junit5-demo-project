package org.tallinn.rehab;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class StepTest {
    @BeforeEach
    void openPage() {
        Selenide.open("http://51.250.6.164:3000/signin");
    }

    @Nested
    class FailedLogins {
        @AfterEach
        void clearFields() {
            $x("//input[@data-name='username-input']").clear();
            $x("//input[@data-name='password-input']").clear();
        }

        // provide incorrect credential to check if  authorizationError-popup would display
        @Test
        public void provideIncorrectCredentialsAndCheckingTheErrorMessage() {

            $x("//input[@data-name='username-input']").setValue("Tom Cruise");
            $x("//input[@data-name='password-input']").setValue("88888888");
            $x("//button[@data-name='signIn-button']").click();
            $x("//div[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);
        }

        //Error checking using a minimum number of characters (1 character in username field)
        @Test
        public void provideOneCharacterInUsernameFieldAndCorrectPasswordAndCheckingTheErrorMessage() {
            $x("//input[@data-name='username-input']").setValue("R");
            $x("//input[@data-name='password-input']").setValue("p14astwd63");
            $x("//span[@data-name='username-input-error']").shouldBe(Condition.exist, Condition.visible);
            $x("//span[text()='The field must contain  at least of characters: 2']");
        }

        //Error checking using a minimum number of characters (1 character in password field)
        @Test
        public void provideTwoCharacterInPasswordFieldAndCorrectUsernameAndCheckingTheErrorMessage() {
            $x("//input[@data-name='username-input']").setValue("rehab");
            $x("//input[@data-name='password-input']").setValue("62");
            $x("//span[contains(@class,'form-error form-error_active')]").shouldBe(Condition.exist, Condition.visible);
            //$x("//span[text()='The field must contain  at least of characters: 8']").shouldBe(Condition.exist,Condition.visible);
        }
    }

    @Nested
    class OtherLogins {

        @AfterEach
        void logout() {
            $x("//a[@data-name='logout-button']").click();
        }

        // provide incorrect credential to check if  authorizationError-popup would display
        @Test
        public void provideCorrectCredentialsAndCreateOrderPageShouldDisplay() {
            $x("//input[@data-name='username-input']").setValue("rehab");
            $x("//input[@data-name='password-input']").setValue("p14astwd63");
            $x("//button[@data-name='signIn-button']").click();
            $x("//div[contains(@class,'new-order-page')]").shouldBe(Condition.exist, Condition.visible);

        }

        // provide incorrect credential to check if  authorizationError-popup would display
        @Test
        public void provideIncorrectCredentialsAndCloseThePopupErrorMessageAndLoginCorrectly() {
            $x("//input[@data-name='username-input']").setValue("jason momoa");
            $x("//input[@data-name='password-input']").setValue("66666666");
            $x("//button[@data-name='signIn-button']").click();
            $x("//div[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);
            $x("//button[@data-name='authorizationError-popup-close-button']").click();
            $x("//input[@data-name='username-input']").setValue("rehab");
            $x("//input[@data-name='password-input']").setValue("p14astwd63");
            $x("//button[@data-name='signIn-button']").click();
            $x("//div[contains(@class,'new-order-page')]").shouldBe(Condition.exist, Condition.visible);
        }
    }
}


