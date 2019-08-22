import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactUsPage extends BaseActions {

    public ContactUsPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

    public void contactUsTests(){
        driver.findElement (Locators.LINK_TOUR_TO_UKRAINE).click ();
        scrollToBottomOfPage ();
        driver.findElement (Locators.LINK_CONTACT_US).click ();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.LIST_REASON).click ();

       // WebElement dropdownListReason = driver.findElement(Locators.LIST_REASON);
       // getDropDownListByValue(dropdownListReason, "Technical support");


    }
    }

