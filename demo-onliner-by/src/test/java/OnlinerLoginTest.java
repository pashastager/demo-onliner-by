import Helpers.OnlinerLoginPageMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Helpers.OnlinerLoginPageMessages.ENTER_NICKNAME_ERROR;
import static Helpers.OnlinerLoginPageXpath.*;

public class OnlinerLoginTest {
    @Test
    public void errorWitoutLogin() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.onliner.by/");
        OnlinerLoginPageMethods onlinerLoginPageMethods = new OnlinerLoginPageMethods(webDriver);

        onlinerLoginPageMethods.clickButton(OPEN_LOGIN_PAGE_BUTTON_XPATH);
        onlinerLoginPageMethods.sendKeysInput(INPUT_PASSWORD_XPATH, "Qwd12345#");
        onlinerLoginPageMethods.clickButton(LOGIN_BUTTON_XPATH);
        String actualResult = onlinerLoginPageMethods.getResultErrorText(ENTER_NICKNAME_ERROR_XPATH);
        String expectedResult = ENTER_NICKNAME_ERROR;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}
