import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainPage {
    String mainUrl = "https://romanceabroad.com/";
    WebDriver driver;
    String currentUrlSearch;
    String expectedUrl = "https://romanceabroad.com/";

    @BeforeMethod
      public void setUp(){

        System.setProperty ("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);
    }


    @Test

    public  void testMainPage (){

        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']")).click();
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("teddy");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Flower basket')]")).click();
        driver.findElement(By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']")).click();
        driver.findElement(By.xpath("//*[@id='ajax_login_link']")).click();
        driver.findElement(By.xpath("//*[@id='main_search_button_user_line']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'3')]")).click();



        driver.findElement(By.cssSelector("a[href*='https://romanceabroad.com/content/view/how-it-works']")).click();
        driver.findElement(By.cssSelector("a[href*='https://romanceabroad.com/content/view/blog']")).click();



        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();

        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, expectedUrl);
    }


    @AfterMethod
    public void afterActions() {
        driver.quit();
    }
    }



