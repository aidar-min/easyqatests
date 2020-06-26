package com.easyqa.qa.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class DashboardPage {

    @FindBy(xpath = "//a[@href='/user/edit']")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='/projects']")
    public SelenideElement myProjectsLink;

    @FindBy(xpath = "//a[@href='/user/edit']")
    public SelenideElement userEdit;

        public void OpenMyOrganizations(WebDriver driver, String _organization_title){
            driver.findElement(By.cssSelector("a[href='/users/profile/my_organizations']")).click();
        }
        public static void ClickAddOrganization(WebDriver driver){
            driver.findElement(By.linkText("Add organization")).click();
        }



    public void checkUserAuthorized(){
        profileLink.shouldBe(Condition.visible);
    }

    public ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return Selenide.page(ProjectsPage.class);
    }


}
