import Helpers.OnlinerLoginPageMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static Helpers.OnlinerLoginPageMessages.*;
import static Helpers.OnlinerLoginPageXpath.*;

public class OnlinerLoginTest {

    @Test
    public void errorWitoutLogin() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.onliner.by");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        OnlinerLoginPageMethods onlinerLoginPageMethods = new OnlinerLoginPageMethods(webDriver);

        onlinerLoginPageMethods.clickButton(OPEN_LOGIN_PAGE_BUTTON_XPATH);
        onlinerLoginPageMethods.sendKeysInput(INPUT_PASSWORD_XPATH, "Qwd12345#");
        onlinerLoginPageMethods.clickButton(LOGIN_BUTTON_XPATH);
        Assertions.assertEquals(onlinerLoginPageMethods.getResultErrorText(ENTER_NICKNAME_ERROR_XPATH), ENTER_NICKNAME_ERROR);
    }

    @Test
    public void errorWitoutPassword() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.onliner.by");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        OnlinerLoginPageMethods onlinerLoginPageMethods = new OnlinerLoginPageMethods(webDriver);

        onlinerLoginPageMethods.clickButton(OPEN_LOGIN_PAGE_BUTTON_XPATH);
        onlinerLoginPageMethods.sendKeysInput(INPUT_LOGIN_XPATH, "Pavelkalinkov");
        onlinerLoginPageMethods.clickButton(LOGIN_BUTTON_XPATH);
        Assertions.assertEquals(onlinerLoginPageMethods.getResultErrorText(ENTER_PASSWORD_ERROR_XPATH), ENTER_PASSWORD_ERROR);
    }

    @Test
    public void errorLoginAndPassword() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.onliner.by");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        OnlinerLoginPageMethods onlinerLoginPageMethods = new OnlinerLoginPageMethods(webDriver);

        onlinerLoginPageMethods.clickButton(OPEN_LOGIN_PAGE_BUTTON_XPATH);
        onlinerLoginPageMethods.sendKeysInput(INPUT_LOGIN_XPATH, "1223");
        onlinerLoginPageMethods.sendKeysInput(INPUT_PASSWORD_XPATH, "1223");
        onlinerLoginPageMethods.clickButton(LOGIN_BUTTON_XPATH);
        Assertions.assertEquals(onlinerLoginPageMethods.getResultErrorText(LOGIN_AND_PASSWORD_ERROR_XPATH), LOGIN_AND_PASSWORD_ERROR);
    }
}
