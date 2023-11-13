package tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.AuthPage;
import pages.DictPage;

import static helpers.DriverUtils.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictTest extends TestBase {
   String passwordValue = "sysadmin";
   @Test
   @Owner("d.perlin")
   @Layer("web")
   @Story("Успешный вход в Систему")
   @Tags({@Tag("web"), @Tag("smoke")})
   @Feature("Аутентификация пользователей")
   @JiraIssues({@JiraIssue("HOMEWORK-269")})
   @DisplayName("Лог консоли браузера на странице входа в Систему не содержит ошибок")
   public void consoleLogShouldNotHaveErrors() {
      authPage.openPage();
      authPage.setLoginValue("sysadmin");
      authPage.setPasswordValue(passwordValue);
      authPage.clickEnterButton();
      dictPage.openPageDictPage();
      dictPage.clickAddButton();
      dictPage.dictEdit_id().setValue("new");
      dictPage.dictEdit_nam().setValue("new");
      dictPage.dictEdit_nameEn().setValue("new");
      dictPage.dictEdit_icoaCode().setValue("new");
      dictPage.dictEdit_rusCode().setValue("new");
      dictPage.dictEdit_prefix().setValue("new");
      dictPage.clickCreateButton();


   }
}
