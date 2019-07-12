import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

    String mainUrl = "https://www.monster.com/";
    WebDriver driver;
    String currentUrlSearch;
    String expectedUrl = "https://www.monster.com/jobs/search/?q=QA&where=Weston";


    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainUrl);

    }

    @Test

    public  void testLoginPage (){


        driver.findElement(By.cssSelector("a[href*='https://login20.monster.com/Login/SignIn?ch=MONS&intcid=skr_navigation_www_signin']")).click();
        driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("Test1414pull@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Tair2013!");
        driver.findElement(By.cssSelector("#btn-login")).click();
        driver.findElement(By.cssSelector("#CareerLevelID")).click();
        driver.findElement(By.cssSelector("#btn-submit")).click();
        driver.findElement(By.xpath("//input[@id='keywords2']")).sendKeys("QA");
        driver.findElement(By.cssSelector("#location")).sendKeys("Weston");
        driver.findElement(By.cssSelector("#doQuickSearch")).click();
        driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Salary')]")).click();

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



