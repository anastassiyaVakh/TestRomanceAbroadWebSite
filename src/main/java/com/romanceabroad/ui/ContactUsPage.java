package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactUsPage extends BaseActions {

    public ContactUsPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

    public void contactUsSelectReason(){

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.LIST_REASON).click ();

        WebElement dropdownListReason = driver.findElement(Locators.LIST_REASON);
        getDropDownListByIndex(dropdownListReason, 2);
    }

    public void contactUsCompleteForm(String nickname, String email, String subject, String message, String captcha){

        driver.findElement (Locators.TEXT_FIELD_USER_NAME_CONTACT_US).sendKeys (nickname);
        driver.findElement (Locators.TEXT_FIELD_EMAIL_CONTACT_US).sendKeys (email);
        driver.findElement (Locators.TEXT_FIELD_SUBJECT_CONTACT_US).sendKeys (subject);
        driver.findElement (Locators.TEXT_FIELD_MESSAGE_CONTACT_US).sendKeys (message);
        driver.findElement (Locators.TEXT_FIELD_CAPTCHA).sendKeys (captcha);
        driver.findElement (Locators.BUTTON_SEND_CONTACT_US).click ();





    }
    }

