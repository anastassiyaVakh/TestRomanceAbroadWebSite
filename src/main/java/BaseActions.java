
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    //constractor
    public BaseActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void javaWait(int ms){
        try{
            Thread.sleep (ms);
        }catch (InterruptedException e){
            e.printStackTrace ();
        }
    }
    public void javaWaitSec(int sec){
        try{
            Thread.sleep (sec * 1000);
        }catch (InterruptedException e){
            e.printStackTrace ();
        }
    }


    public static String generateNewNumber (String name, int length){
        return name + RandomStringUtils.random(length, "125466");
    }


    public void getDropDownListByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void scrollToBottomOfPage(){
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void clickUnselectedCheckbox(By checkbox){
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isDisplayed()){
            ajaxClick(currentCheckbox);
        }
    }

    public void ajaxClick(WebElement element){ //java script executer
        ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void ajaxClick (By by){
        wait. until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    public void ajaxClick (By by, int index){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    public void performClick(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();

    }

    public void performClick(By locator, int index){
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();

    }

    public void performClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();

    }

    public void getNavigateToLinkPage(By locator){driver.findElement(locator).click();}



    public void getDropDownListByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void getDropDownListByIndex(By locator, int index){
        Select select = new Select(driver.findElement (locator));
        select.selectByIndex (index);
    }
}
