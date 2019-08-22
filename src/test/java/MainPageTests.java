import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class MainPageTests extends BaseUI {


    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5), Data.phone,
                Data.month, Data.day, Data.year, Data.city, Data.location);

    }

   @Test
   public void testSignIn(){
       mainPage.signIn ();
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
}

