import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MediaTests extends BaseUI {
    String currentUrlMedia;

    @Test
    public  void TestMediaPage (){

        driver.findElement(Locators.LINK_MEDIA).click();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        Assert.assertEquals(currentUrlMedia, Data.expectedUrlMedia);



        List<WebElement> filters = driver.findElements(Locators.GALLERY_FILTERS);
        System.out.println(filters.size());

        for (int i = 0; i < filters.size(); i++){
            String info = filters.get(i).getText();
            System.out.println(info);

            filters.get(i).click();
            driver.get(currentUrlMedia);
            filters = driver.findElements (Locators.GALLERY_FILTERS);

            mediaPage.mediaSearchTest();


        }

    }

}
