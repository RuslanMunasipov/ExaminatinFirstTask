package PageObject.Jira;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class LoginForm {
    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement LoginJira;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement PasswordJira;

    @FindBy(how = How.XPATH, using = "//input[@value='Войти']")
    private SelenideElement buttonLogIn;

    @Step("Вводи логина")
    public SecondPage loginVal() {
        LoginJira.setValue(Utils.Configuration.getConfigurationValue("login"));
        return page(SecondPage.class);
    }

    @Step("Ввод пароля")
    public SecondPage passwordVal() {
        PasswordJira.setValue(Utils.Configuration.getConfigurationValue("password"));
        return page(SecondPage.class);
    }

    @Step("Нажать кнопку войти")
    public SecondPage clickButtonLogIn(){
        buttonLogIn.click();
        return page(SecondPage.class);
    }
}
