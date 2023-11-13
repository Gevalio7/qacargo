package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AdminPage;
import pages.AuthPage;
import pages.DictPage;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    protected final DictPage dictPage = new DictPage();
    protected final AuthPage authPage = new AuthPage();
    protected final Faker faker = new Faker();
    protected final AdminPage adminPage = new AdminPage();


    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }

}