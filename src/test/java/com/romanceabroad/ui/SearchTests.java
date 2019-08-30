package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    String currentUrlSearch;

    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;

    @Test (priority = 2, enabled = testCase12, groups = {"ie"})

    public void testSearchPageTestCase12 () {
        Assert.assertTrue(driver.findElement (Locators.LINK_SEARCH).isDisplayed ()," Element is displayed");
        mainPage.clickLinkSearch ();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, com.romanceabroad.ui.Data.expectedUrlSearch);
        softAssert.assertEquals (currentUrlSearch, Data.expectedUrlSearch, " Url is wrong");
        WebElement dropdownListSortBy = driver.findElement (Locators.DROP_DOWN_LIST_SORT_BY);
        searchPage.getDropDownListByValue (dropdownListSortBy, "date_created");
        //searchPage.searchForWomenTest ();
        softAssert.assertAll ();

    }

    @Test(priority = 3, enabled = testCase13, groups =  {"user", "admin"})
    public void verificationsTestCase13 (){
        Assert.assertEquals ("Web", "Web");
    }

    @Test(priority = 1, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListTestCase11 (){
        mainPage.clickLinkSearch ();
        searchPage.ageTableIsDisplayed ();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList (Locators.DROP_DOWN_LIST_SORT_BY_MAX_AGE);
        System.out.println (sizeOfDropDownListSortBy);
        for (int i = 0; i < 2; i++){
            searchPage.selectItemDropDownRandomOption (Locators.DROP_DOWN_LIST_SORT_BY_MAX_AGE, "Sort By Age");
            mainPage.javaWait (3);
        }
    }
    @Test
    public void selectRandomDropDownList(){
        mainPage.clickLinkSearch ();

        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList (Locators.DROP_DOWN_LIST_SORT_BY_MIN_AGE);
        System.out.println (sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++){
            searchPage.selectItemDropDownRandomOption (Locators.DROP_DOWN_LIST_SORT_BY, "Sort by Age");
            mainPage.javaWaitSec (3);
        }
    }

}
