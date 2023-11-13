package pages;

import com.codeborne.selenide.SelenideElement;
import config.Project;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class DictPage extends BasePage {

    @FindBy(xpath = "//h1")
    public WebElement title;

    public void openPage() {
        open(Project.config.baseUrl());
    }

   // id записи Авиакомпанияdict
    public SelenideElement dictEdit_id() {
        return $("#dictEdit_id");
    }
    // id записи Наименование
    public SelenideElement dictEdit_nam() {
        return $("#dictEdit_name");
    }

    public SelenideElement dictEdit_nameEn() {
        return $("#dictEdit_nameEn");
    }

    public SelenideElement dictEdit_icoaCode() {
        return $("#dictEdit_icoaCode");
    }
    public SelenideElement dictEdit_rusCode() {
        return $("#dictEdit_rusCode");
    }
    public SelenideElement dictEdit_prefix() {
        return $("#dictEdit_prefix");
    }




    public String getTitle(){
        return title.getText();
    }

    @Step("Открыть страницу входа в систему")
    public static DictPage openPageDictPage() {
        open(Project.config.baseUrl() + "dict/airline");
        return new DictPage();
    }
    @Step("Нажать кнопку 'Добавить запись'")
    public void clickAddButton() {
        $(".ant-btn-primary > span:nth-child(2)").click();
    }

    @Step("Нажать кнопку 'Записать'")
    public void clickCreateButton() {
        $x("//span[contains(.,'Создать')]").click();

//SelenideElement createButton = $x("");
    }
}


