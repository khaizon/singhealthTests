import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSwipeDifferentAuditor {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void loadTenantsPage() throws InterruptedException {
        Thread.sleep(1000);
        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]")));
        menuButton.click();
    }

    public void swipeCGH() throws InterruptedException{
        Thread.sleep(1500);
        WebElement swipeableCGH = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[3]/div[1]/div/div[2]/div/span")));
       
        int posX = swipeableCGH.getLocation().x;
        int posY = swipeableCGH.getLocation().y;
        System.out.println("swipeable is at: "+ posX+","+posY);

        Actions action = new Actions(driver);
        action.moveByOffset(posX+250,posY);
        action.clickAndHold();
        action.moveByOffset(-200,0).release();
        // Thread.sleep(3000);
        action.build().perform();
        Thread.sleep(3000);

    }

    public void loginCGH() throws InterruptedException{
        driver.get("http://localhost:3000/login");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("CURRENTIXER@GMAIL.COM");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("cgh2021");
        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(3000);
    }

    @Before
    public void loginStaff() throws InterruptedException{
        System.setProperty("webdriver.driver", "C:\\Users\\Deeni\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
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
    public void testSwipe() throws InterruptedException{
        loadTenantsPage();
        Thread.sleep(1500);
        swipeCGH();
        Thread.sleep(1500);

        loginCGH();
        Thread.sleep(1500);
        loadTenantsPage();
        Thread.sleep(1500);
        swipeCGH();
        Thread.sleep(1500);
    }

    @After
    public void quit() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
    
}

