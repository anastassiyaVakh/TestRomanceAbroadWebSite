package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickSignInButton(){
        driver.findElement (Locators.BUTTON_LOGIN).click ();
    }

    public void signIn(String email, String password){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement (Locators.TEXT_FIELD_LOGIN_EMAIL).sendKeys (email);
        driver.findElement (Locators.TEXT_FIELD_LOGIN_PASSWORD).sendKeys (password);
        driver.findElement (Locators.BUTTON_SIGN_IN).click ();
        //driver.findElement (com.romanceabroad.ui.Locators.).isDisplayed ();

    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration( String email, String password) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait.until (ExpectedConditions.visibilityOf (driver.findElement (Locators.TEXT_FIELD_EMAIL)));
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
    }

    public void completeSecondPartOfRegistration(String nickname, String phone, String month, String day, String year, String city, String location) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.BUTTON_NEXT).click();

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        driver.findElement(Locators.LIST_DAY).click();
        clickValueOfLists (Locators.LIST_DAY_VALUE, day);

        driver.findElement(Locators.LIST_MONTH).click();
        clickValueOfLists (Locators.LIST_MONTH_VALUE, month);

        driver.findElement(Locators.LIST_YEAR).click();
       clickValueOfLists (Locators.LIST_YEAR_VALUE, year);

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_TERMS);
        if (!checkboxConfirmation.isSelected()) {
            checkboxConfirmation.click();

            driver.findElement (Locators.AUTOFILLING_FORM_LOCATION).clear();
            driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys (city);
            clickValueOfLists (Locators.LIST_VALUE_LOCATION, location);
        }
    }

    public void clickTabBlog(){
        driver.findElement (Locators.LINK_BLOG).click ();

    }

    public void clickLinkSearch(){
        driver.findElement(Locators.LINK_SEARCH).click();
    }

    public void clickLinkGifts(){
        driver.findElement(Locators.LINK_GIFTS).click();
    }

    public void clickLinkPhotos(){
        driver.findElement (Locators.LINK_MEDIA).click ();
    }

    public void clickLinkContactUs(){
        driver.findElement (Locators.LINK_TOUR_TO_UKRAINE).click ();
        scrollToBottomOfPage ();
        driver.findElement (Locators.LINK_CONTACT_US).click ();
    }

    public int verifyIFrameSizeMainPage(){
        int size = driver.findElements(By.xpath("//iframe")).size();
        System.out.println(size + "iframe");
        return size;
    }

    public void verifyIFrameOnMainPage(){
    WebElement element = driver.findElement(Locators.IFRAME_VIDEO);
    driver.switchTo().frame(element);
    performClick(Locators.BUTTON_PLAY);
    driver.switchTo().defaultContent();
    }

}



