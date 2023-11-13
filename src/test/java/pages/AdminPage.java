package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdminPage extends BasePage {
    public SelenideElement userProfileName() {
        return $(".ant-avatar-string");
    }
    @Step("Verify project's all widgets are displayed")
    public void checkThatProjectHas5Widgets() {
        $$("#root").shouldHave(
                itemWithText("Контрагенты"),
                itemWithText("Контрагенты"),
                itemWithText("Список бронирований"),
                itemWithText("Авиакомпании"),
                itemWithText("Агенты по продажам")
        );
    }
}
