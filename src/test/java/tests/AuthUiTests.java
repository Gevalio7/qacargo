package tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.AdminPage;

import static com.codeborne.selenide.Condition.text;
import static helpers.DriverUtils.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthUiTests extends TestBase {

    String passwordValue = "sysadmin";
    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Успешный вход в Систему")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Аутентификация пользователей")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Лог консоли браузера на странице входа в Систему не содержит ошибок")
    void consoleLogShouldNotHaveErrors() {
        authPage.openPage();

        step("Страница входа в Систему не содержит ошибок в логах консоли браузера", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs).doesNotContain("SERVE");
        });
    }
    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Успешный вход в Систему")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Аутентификация пользователей")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Проверка заголовка страницы входа в Систему")
    void checkTitleTest() {
        authPage.openPage();
        String expectedTitle = "Sign in to cargo-development";

        step("Заголовок страницы входа в Систему содержит '" + expectedTitle + "'", () -> {
            assertThat(authPage.getTitle()).isEqualTo(expectedTitle);
        });
    }



    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Успешный вход в Систему")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Аутентификация пользователей")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Успешный вход в Систему")
    void loginSuccessful() {
        AuthPage.openPage();
        authPage.setLoginValue("sysadmin");
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();

        String expectedUserName = "S";
        step("Профиль пользователя содержит '" + expectedUserName + "'", () -> {

            adminPage.userProfileName().shouldHave(text(expectedUserName));
            adminPage.checkThatProjectHas5Widgets();
        });
    }



    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Попытка входа в Систему с невалидными данными")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Аутентификация пользователей")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Попытка входа в Систему с невалидным значением логина")
    void inputInvalidLoginShowErrorMessage() {
        authPage.openPage();
        authPage.checkLoginInputExists();
        authPage.setLoginValue(faker.number().digits(3));
        authPage.setPasswordValue(faker.number().digits(3));
        authPage.clickEnterButton();
        authPage.checkAlertContainsMessage("Invalid username or password.");
    }

    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Попытка входа в Систему с невалидными данными")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Вход в личный кабинет")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Попытка входа в Систему без указания пароля")
    void passwordCouldNotBeEmpty() {
        Faker faker = new Faker();
        authPage.openPage();
        authPage.checkLoginInputExists();
        authPage.setLoginValue(faker.number().digits(3));
        authPage.clickEnterButton();
        authPage.checkAlertContainsMessage("Invalid username or password.");

    }
/*
    @Test
    @Owner("d.perlin")
    @Layer("web")
    @Story("Открытие страниц")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Восстановление пароля")
    @JiraIssues({@JiraIssue("HOMEWORK-269")})
    @DisplayName("Переход на страницу 'Восстановление пароля'")
    void checkLoginAdminPage() {
        AuthPage authPage = AuthPage.openPage();

        String expectedUserName = "S";
        step("Профиль пользователя содержит '" + expectedUserName + "'", () -> {
            AdminPage AdminPage = new AdminPage();
            assertThat(authPage.userProfileName()).isEqualTo(expectedUserName);
        });

        RecoveryPasswordPage recoveryPasswordPage = authPage.clickRecoveryPasswordLink();
        String expectedRecoveryPasswordTitle = "Sign in to cargo-development";
        step("Заголовок страницы содержит '" + expectedRecoveryPasswordTitle + "'", () -> {
            assertThat(recoveryPasswordPage.getTitle()).isEqualTo(expectedRecoveryPasswordTitle);
        });
    }*/


}