import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;


public class MainPageTests extends BaseUI {



    @Test
    public void test2() throws InterruptedException{
        Thread.sleep(5000);
        WebElement ele =driver.findElement(Locators.IFRAME_VIDEO);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.BUTTON_PLAY).click();
    }

    public void testNavBar(){
        String expectedTitle = "Ukranian women for marriage";
        List<WebElement> links = driver.findElement(Locators.NAVIGATION_MENU);
        System.out.println(links.size());

        for (int i=0; i < links.size(); i++){
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();

            if(info.contains("WORK")){
                String actualTitle = driver.findElement(By.xpath("//h1")).getText();
                Assert.assertEquals(expectedTitle,actualTitle);
            }
        }
    }
}

}
