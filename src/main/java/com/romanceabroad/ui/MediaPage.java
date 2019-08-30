package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaPage extends BaseActions {

    public MediaPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }


    public void searchForPhotosTest(){

        driver.findElement(Locators.LINK_PHOTO).click();
        driver.findElement(Locators.LINK_VIDEO).click();
        driver.findElement(Locators.LINK_ALBUMS).click();
    }


    }

