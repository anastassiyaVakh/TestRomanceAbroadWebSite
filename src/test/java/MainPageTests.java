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

    @DataProvider(name = "Registration")
	public static Object[][] testRegistration2() throws Exception{
		ArrayList<Object[]>out = new ArrayList<> ();
		Files.readAllLines (Paths.get ("Registration.txt")).stream ().forEach (s -> {

			String[] data = s.split (",");
			out.add (new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
		});
		return  out.toArray (new Object[out.size ()][]);
	}


	@Test
    public void testSignIn(){
        mainPage.signIn (Data.email, Data.password);

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

}

