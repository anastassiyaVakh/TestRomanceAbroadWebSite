import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class MainPageTests extends BaseUI {



    @Test
    public void test2() throws InterruptedException{
        Thread.sleep(5000);
        WebElement ele =driver.findElement(Locators.IFRAME_VIDEO);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.BUTTON_PLAY).click();
    }

}
