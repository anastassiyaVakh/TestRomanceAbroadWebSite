import org.openqa.selenium.By;
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
  /*  @Test
    public void testNavBar(){
        String actualTitle;
        String actualUrlPrettyWomen;
        String expectedUrlPrettyWomen = "https://romanceabroad.com/users/search";
        String expectedTitleHowWeWork = "Ukranian women for marriage";
        String expectedTitlePrettyWomen = "Single Ukranian women online";
        List<WebElement> links = driver.findElement (Locators.NAVIGATION_MENU);
        System.out.println(links.size());

        for (int i=0; i < links.size(); i++){
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();

            if(info.contains("WORK")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(expectedTitleHowWeWork,actualTitle);
            }

            if(info.contains("PRETTY WOMEN")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(actualUrlPrettyWomen, expectedUrlPrettyWomen);
                driver.findElement(By.xpath("//a[@class='g-pic-border g-rounded']")).isDisplayed();

            }
            driver.get(Data.mainUrl);
            links = driver.findElement(Locators.NAVIGATION_MENU);
        }

    }*/
}

