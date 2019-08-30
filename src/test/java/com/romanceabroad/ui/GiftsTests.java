package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {
    String currentUrlGifts;

    @Test
    public  void testGiftSearch (){

        mainPage.clickLinkGifts ();
        currentUrlGifts = driver.getCurrentUrl();
        System.out.println(currentUrlGifts);
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
        giftsPage.giftsSearchTest ();

    }
}
