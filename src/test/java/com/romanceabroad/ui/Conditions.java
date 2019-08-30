package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI {

   /* @Test
    public void test18(){

        mainPage.ajaxClick(driver.findElement(By.xpath("//a[@href='#']")));
        mainPage.ajaxClick(com.romanceabroad.ui.Locators.NAVIGATION_MENU,1);
        mainPage.performClick(com.romanceabroad.ui.Locators.NAVIGATION_MENU, 1);
        mainPage.scrollToBottomOfPage();
    }
*/


    @Test
    public void test() {
        String fruit1 = "apple";
        String fruit2 = "orange";

        if (fruit1.contains("apple") && fruit2.contains("kiwi")) {
            System.out.println("we cand find this fruit 1");
        } else {
            Assert.fail("we cannot find it");
        }
    }

    @Test
    public void test2() {
        int number = 10;
        int sum;

        if (number==15 +5){
            sum =95+100;
        } else {
            sum= 100-95;
        }
        System.out.println(sum);

    }

    @Test
    public void test4(){
        boolean requirement = true;

        if(!requirement){
            System.out.println("Boolean is true");
        }else {
            Assert.fail("Boolean is false");
        }

    }

    @Test
    public void test5(){
        WebElement tabSearch = driver.findElement(Locators.LINK_SEARCH);

        if(tabSearch.isDisplayed()){
            tabSearch.click();
        }else {
            Assert.fail("We can't find this button");
        }
    }

    @Test
    public void test7 (){
        List<String> crunchifyList1 = new ArrayList(Arrays.asList("kiwi","orange","melon"));
        String element = crunchifyList1.get(0);
        if (crunchifyList1.contains("orange")){
            System.out.println(crunchifyList1);
        }

    }

    @Test
    public void test10 () {
        List<String> crunchifyList4 = new ArrayList(Arrays.asList("kiwi", "orange", "melon"));
        crunchifyList4.add("apple");
        System.out.println(crunchifyList4);

        for (int i = 0; i < crunchifyList4.size(); i++) {
            String element = crunchifyList4.get(i);

            if (element.contains("me")) {
                System.out.println("melon is inside list");
            }

        }

    }

    @Test
    public void test11 () {
        String phrase = "Melon is inside list";
        List<String> crunchifyList4 = new ArrayList(Arrays.asList("kiwi", "orange", "melon", phrase));
        crunchifyList4.add("apple");
        System.out.println(crunchifyList4);

        for (int i = 0; i < crunchifyList4.size(); i++) {
            String element = crunchifyList4.get(i);
            System.out.println("Iteration:"+ i);

            if (element.contains("me")) {
                System.out.println(phrase);
                //continue;
                break; //complete loop

            }if (element.equals("orange")){
                System.out.println("Orange");
            }if(element.contains("i")){
                System.out.println("IIIIII");
            }
            else {
                System.out.println("Bad loop");
            }

        }

    }

    @Test
    public void test12 () {
        String phrase = "Melon is inside list";
        List<String> crunchifyList4 = new ArrayList(Arrays.asList("kiwi", "orange", "melon", phrase));
        crunchifyList4.add("apple");
        System.out.println(crunchifyList4);

        for (int i = 0; i < crunchifyList4.size(); i++) {
            String element = crunchifyList4.get(i);
            System.out.println("Iteration:"+ i);
            continue;

        }

    }

    @Test
    public void test8 (){
        List<Integer> crunchifyList2 = new ArrayList(Arrays.asList(5,7,4));
        int sum = crunchifyList2.get(1) + crunchifyList2.get(2);
        System.out.println(sum);
    }

    @Test
    public void test9 (){
        List<Integer> crunchifyList3 = new ArrayList<>(Arrays.asList(5,10,19));
        crunchifyList3.add(10);
        System.out.println(crunchifyList3.size());

        for (int i=0; i<crunchifyList3.size(); i++){
            int element =crunchifyList3.get(i);
            System.out.println(element);
        }
    }


}
