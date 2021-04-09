import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSearchFilter {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void loadTenantsPage() throws InterruptedException {
//        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a/span")));
//        menuButton.click();
//        Thread.sleep(2000);
        WebElement tenantsButton =
                driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a")));
        tenantsButton.click();
    }
    
    //sghHi@tenant.com
    public void searchFilter1() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/section/main/div[2]/div/div/span[1]/span/span/input"));
    	searchBar.click();
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
    	WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/section/main/div[2]/div/div/span[1]/span/span/input"));
    	searchBar.click();
    	searchBar.sendKeys("s");
    	Thread.sleep(400);
    	searchBar.sendKeys("g");
    	Thread.sleep(400);
    	searchBar.sendKeys("h");
    	Thread.sleep(1000);
    	searchBar.clear();	
    }
    
    public void searchFilter3() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/section/main/div[2]/div/div/span[1]/span/span/input"));
    	searchBar.click();
    	searchBar.sendKeys("f");
    	Thread.sleep(400);
    	searchBar.sendKeys("a");
    	Thread.sleep(400);
    	searchBar.sendKeys("i");
    	Thread.sleep(400);
    	searchBar.clear();	
    }

    @Before
    public void loginStaff() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
    	System.setProperty("webdriver.edge.driver","C:\\Users\\Windows\\eclipse-workspace\\ESCSelenium\\drivers\\edgedriver\\msedgedriver.exe");
		driver = new EdgeDriver();
        int width = 600;
        int height = 1000;
        driver.manage().window().setSize(new Dimension(width, height));
        driver.get("http://localhost:3000/");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("sgh@auditor.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("sgh2021");
        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(3000);
    }

    @Test
    public void testSearchFilter1() throws InterruptedException{
        loadTenantsPage();
        searchFilter1();9
    }
    
    @Test
    public void testSearchFilter2() throws InterruptedException{
        loadTenantsPage();
        searchFilter2();
    }
    
    @Test
    public void testSearchFilter3() throws InterruptedException{
        loadTenantsPage();
        searchFilter3();
    }


    @After
    public void quit() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }


}
