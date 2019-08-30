package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainPageTests extends BaseUI {

	@Test
	public void testSignIn(){
		mainPage.clickSignInButton ();
		mainPage.javaWaitSec (5);
		mainPage.signIn (Data.email, Data.password);

	}

	@DataProvider(name= "Registration2")
	public static Object[][] testRegistration2(){
		return new Object[][]{
				{"11@gmail.com", 3, true},
				{"12@yahooo.com", 0, false},
				{"13@hotmail.com", 4, true},
		};
	}

	@Test(dataProvider = "Registration2")
	public void testRegistration2(String email, int lenght, boolean requirement) {

		System.out.println (email);
		mainPage.clickJoinButton();
		if (requirement) {
			mainPage.completeFirstPartOfRegistration (email, Data.password);
		}else {
			System.out.println ("email is wrong");


		}
		mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, lenght), Data.phone,
				Data.month, Data.day,Data.year,Data.city,Data.location);

	}

    @DataProvider(name = "Registration")
	public static Object[][] testRegistration() throws Exception{
		ArrayList<Object[]>out = new ArrayList<> ();
		Files.readAllLines (Paths.get ("com.romanceabroad.ui.Registration.txt")).stream ().forEach (s -> {

			String[] data = s.split (",");
			out.add (new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
		});
		return  out.toArray (new Object[out.size ()][]);
	}


	@Test(dataProvider = "Registration")
	public void testRegistration(String email, String password, String day, String month, String year, String phone, String city, String location ) {
		mainPage.clickJoinButton();
		mainPage.completeFirstPartOfRegistration(email,password);
		mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5), phone,
				month, day,year,city,location);

	}

	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(5000);
		WebElement ele =driver.findElement(Locators.IFRAME_VIDEO);
		driver.switchTo().frame(ele);
		driver.findElement(Locators.BUTTON_PLAY).click();
	}

	@Test
	public void testIFrame(){
		int numberOfIFrames = mainPage.verifyIFrameSizeMainPage();
		Assert.assertTrue(numberOfIFrames > 0);
		mainPage.verifyIFrameOnMainPage();

	}

   @Test
	public void testNavBar(){
		String actualTitle;
		String actualUrlPrettyWomen;

		List<WebElement> links = driver.findElements(Locators.NAVIGATION_MENU);
		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++){
			String info = links.get(i).getText();
			System.out.println(info);
			//links.get(i).click();
			 mainPage.ajaxClick (links.get(i));

			if(info.contains("WORK")){
				actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
				Assert.assertEquals(Data.expectedTitleHowWeWork,actualTitle);
			}

			if(info.contains("PRETTY WOMEN")) {
				actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
				actualUrlPrettyWomen = driver.getCurrentUrl();
				Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
				Assert.assertEquals(actualUrlPrettyWomen, Data.expectedUrlPrettyWomen);
				driver.findElement(Locators.IMAGES).isDisplayed();

				if(actualUrlPrettyWomen.contains ("#")){
				   Assert.fail("It contains restricted #");
				}else {
					System.out.println ("No special characters");
				}
			}
			driver.get(Data.mainUrl);
			links = driver.findElements(Locators.NAVIGATION_MENU);
		}

	}
	@Test
	public void testMainPage1(){

		mainPage.ajaxClick (Locators.NAVIGATION_MENU, 3);

	}

	@Test
	public void testLinksOnMainPage(){
		mainPage.checkLinksOnWebPage ("//a","href");
		mainPage.checkLinksOnWebPage ("//img","src");
		driver.findElement (Locators.LINK_SEARCH).click ();
		mainPage.checkLinksOnWebPage ("//a","href");
		mainPage.checkLinksOnWebPage ("//img","src");
	}


    @Test
    public void smokeTestMainPage(){
        List<WebElement>mainTabs = driver.findElements(By.xpath ("//ul[@class='navbar-nav']//li/a"));
        for (int i = 0; i <mainTabs.size (); i ++){
            mainTabs.get (i).click ();
            driver.get(Data.mainUrl);
            mainTabs = driver.findElements (By.xpath ("//ul[@class='navbar-nav']//li/a"));
        }
    }
    @Test
	public void findTabSearch(){
		WebElement tabSearch = driver.findElement (Locators.LINK_SEARCH);
		if (tabSearch.getText ().contains ("PRETTY WOMEN")) {
			tabSearch.click ();
		}else {
			Assert.fail("We can't find Pretty Women tab");
		}

	}


}

