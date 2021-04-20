import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSearchFilter {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement searchBar;
    public static WebElement email;
    public static WebElement password;
    public static WebElement loginButton;

    public void loadTenantsPage() throws InterruptedException {
        WebElement tenantsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a")));
        tenantsButton.click();
    }

    //sghHi@tenant.com
    public void searchFilter1() throws InterruptedException {

    	searchBar.sendKeys("c");
    	Thread.sleep(400);
    	searchBar.sendKeys("g");
    	Thread.sleep(400);
    	searchBar.sendKeys("h");
    	Thread.sleep(400);
    	searchBar.sendKeys("n");
    	Thread.sleep(400);
    	searchBar.sendKeys("o");
    	Thread.sleep(1000);
    	searchBar.clear();	
    }
    
    public void searchFilter2() throws InterruptedException {
    	Thread.sleep(2000);
    	searchBar.click();
    	searchBar.sendKeys("e");
    	Thread.sleep(400);
    	searchBar.sendKeys("s");
    	Thread.sleep(400);
    	searchBar.sendKeys("c");
    	Thread.sleep(1000);
    	searchBar.clear();	
    }
    
    public void searchFilter3() throws InterruptedException {
    	Thread.sleep(2000);
    	searchBar.click();
    	searchBar.sendKeys("f");
    	Thread.sleep(400);
    	searchBar.sendKeys("a");
    	Thread.sleep(400);
    	searchBar.sendKeys("i");
    	Thread.sleep(400);
    	searchBar.sendKeys(Keys.ENTER);
    }

    @Before
    public void loginStaff() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        int width = 600;
        int height = 1000;
        wait = new WebDriverWait(driver,5);
        driver.manage().window().setSize(new Dimension(width, height));
        driver.get("http://localhost:3000/");
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        email.sendKeys("sgh@auditor.com");
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        loginButton.click();


        loadTenantsPage();

        try {
            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "Search"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        searchBar = driver.findElement(By.xpath("//*[@id=\"root\"]/section/main/div[1]/div/div/span[1]/span/span"));

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
    }


}
