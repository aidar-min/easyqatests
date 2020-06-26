package com.easyqa.qa.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "user_email")
    public SelenideElement login;
    @FindBy(id = "user_password")
    public SelenideElement password;
    @FindBy(name = "commit")
    public SelenideElement loginBtn;


    /*public void enterLogin(String userLogin){
        login.click();
        login.clear();
        login.sendKeys(userLogin);
    }

    public void enterPassword(String userPassword){
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }*/




    public void enterUser(String userEmail, String userPassword) {
        login.click();
        login.clear();
        login.sendKeys(userEmail);
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }

    public DashboardPage clickLoginBtn() {
        loginBtn.click();
        return page(DashboardPage.class);
    }
}