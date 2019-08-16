
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BaseActions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    /*public static String generateNewNumber (String name, int length){
        return name + RandomStringUtils.random(length, "125466");
    }*/

    public void getDropDownListByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    /*public void getDropDownListByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByIndex(text);
    }
    public void getDropDownListByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByIndex(value);
    }*/
}
