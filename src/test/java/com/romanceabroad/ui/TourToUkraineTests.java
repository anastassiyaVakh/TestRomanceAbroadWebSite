package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {

    String currentUrlTourToUkraine;

    @Test
    public  void testSearchTours () {

        driver.findElement (Locators.LINK_TOUR_TO_UKRAINE).click ();
        currentUrlTourToUkraine = driver.getCurrentUrl ();
        System.out.println (currentUrlTourToUkraine);
        Assert.assertEquals (currentUrlTourToUkraine, Data.expectedUrlTourToUkraine);
        tourToUkrainePage.toursSearchTest();
        tourToUkrainePage.ajaxClick (Locators.BUTTON_QUICK_VIEW);
    }
}
