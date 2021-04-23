import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TestSearchFilter {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement searchBar;
    public static WebElement email;
    public static WebElement password;
    public static WebElement loginButton;
    public static ChromeOptions chromeOptions;

    public void loadTenantsPage() throws InterruptedException {
        WebElement tenantsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a")));
        tenantsButton.click();
    }

    public static void highlight(WebElement webElement) {
        String jsSyyle = "'3px solid red'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=" + jsSyyle, webElement);
        try {
            Thread.sleep(550);
        } catch (InterruptedException e) {
            //do nothing
        }
        try{
            js.executeScript("arguments[0].style.border=" + "null", webElement);
        } catch (StaleElementReferenceException e){
            //do nothing
        }

    }

    //sghHi@tenant.com
    public void searchFilter1() throws InterruptedException {
        Thread.sleep(2000);

        searchBar.click();
    	Thread.sleep(400);
    	searchBar.sendKeys("c");
    	Thread.sleep(400);
    	searchBar.sendKeys("g");
    	Thread.sleep(400);
    	searchBar.sendKeys("h");
    	Thread.sleep(400);
    	searchBar.sendKeys("n");
    	Thread.sleep(400);
    	searchBar.sendKeys("o");
    	Thread.sleep(400);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(400);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    
    public void searchFilter2() throws InterruptedException {
        Thread.sleep(2000);

    	searchBar.click();
    	Thread.sleep(400);
    	searchBar.sendKeys("e");
    	Thread.sleep(400);
    	searchBar.sendKeys("s");
    	Thread.sleep(400);
    	searchBar.sendKeys("c");

        Thread.sleep(400);
        searchBar.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(400);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(400);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    
    public void searchFilter3() throws InterruptedException {
        Thread.sleep(2000);
        searchBar.click();
        Thread.sleep(400);
        searchBar.sendKeys("h");
        Thread.sleep(400);
        searchBar.sendKeys("f");
    	Thread.sleep(400);
    	searchBar.sendKeys("a");
    	Thread.sleep(400);
    	searchBar.sendKeys("i");
    	Thread.sleep(400);
    	searchBar.sendKeys("r");
    	Thread.sleep(400);
    	searchBar.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(400);
    	searchBar.sendKeys(Keys.ENTER);
    	Thread.sleep(400);
    	searchBar.sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
    }

    @Before
    public void loginStaff() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        chromeOptions = new ChromeOptions();

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 550);
        deviceMetrics.put("height", 940);
        deviceMetrics.put("pixelRatio", 2.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("deviceName", "iPhone 6");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        int width = 565;
        int height = 1075;
        driver.manage().window().setSize(new Dimension(width, height));
//        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
        wait = new WebDriverWait(driver, 7);
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        email.sendKeys("sgh@auditor.com");
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        loginButton.click();


        loadTenantsPage();
        Thread.sleep(400);

        try {
            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "Search"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        Thread.sleep(400);
        try {
            searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc_select_1\"]")));
        } catch (TimeoutException e) {
            driver.navigate().refresh();
        }
        highlight(searchBar);
        searchBar.click();
        Thread.sleep(400);
        searchBar.click();
        Thread.sleep(400);

        searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc_select_1\"]")));
    }

    @Test
    public void testSearchFilter1() throws InterruptedException{
        searchFilter1();
    }

    @Test
    public void testSearchFilter2() throws InterruptedException{

        searchFilter2();
    }

    @Test
    public void testSearchFilter3() throws InterruptedException{

        searchFilter3();
    }


    @After
    public void quit() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
        Thread.sleep(2000);
    }


}
