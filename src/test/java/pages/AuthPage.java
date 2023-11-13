package pages;

import com.codeborne.selenide.SelenideElement;
import config.Project;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthPage extends BasePage {



    public SelenideElement userProfileName() {
        return $(".ant-avatar-string");
    }

    @Step("Открыть страницу входа в систему")
    public static AuthPage openPage() {
        open(Project.config.baseUrl());
        return new AuthPage();
    }

    @Step("Открытая страница содержит поле 'Логин'")
    public void checkLoginInputExists() {
        $("#username").shouldBe(visible);
    }

    @Step("Заполнить поле 'Логин'")
    public void setLoginValue(String loginValue) {
        SelenideElement login = $("#username");
        clearInputValue(login);
        login.setValue(loginValue);
    }

    @Step("Заполнить поле 'Пароль'")
    public void setPasswordValue(String passwordValue) {
        SelenideElement password = $("#password");
        clearInputValue(password);
        password.setValue(passwordValue);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickEnterButton() {
        $("#kc-login").click();
    }





    private void clearInputValue(SelenideElement element) {
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.BACK_SPACE);
    }
}
