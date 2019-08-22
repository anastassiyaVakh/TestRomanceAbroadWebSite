import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void signIn(){
        driver.findElement (Locators.BUTTON_LOGIN).click ();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement (Locators.TEXT_FIELD_LOGIN_EMAIL).sendKeys (Data.email);
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration( String email, String password) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
    }

    public void completeSecondPartOfRegistration(String nickname, String phone, String month, String day, String year, String city, String location) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.BUTTON_NEXT).click();
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        driver.findElement(Locators.LIST_DAY).click();
        clickValueOfLists (Locators.LIST_DAY_VALUE, day);

        driver.findElement(Locators.LIST_MONTH).click();
        clickValueOfLists (Locators.LIST_MONTH_VALUE, month);

        driver.findElement(Locators.LIST_YEAR).click();
       clickValueOfLists (Locators.LIST_YEAR_VALUE, year);

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_TERMS);
        if (!checkboxConfirmation.isSelected()) {
            checkboxConfirmation.click();

            driver.findElement (Locators.AUTOFILLING_FORM_LOCATION).clear();
            driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys (city);
            clickValueOfLists (Locators.LIST_VALUE_LOCATION, location);
        }
    }

    public void clickValueOfLists (By locator, String text){
        List<WebElement>elements = driver.findElements (locator);
        for (int i = 0; i <elements.size (); i ++){
            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText ();
            if (value.contains (text)){
                elementOfList.click ();

            }
        }
    }

}



