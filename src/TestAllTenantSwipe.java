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
import org.openqa.selenium.StaleElementReferenceException;

public class TestAllTenantSwipe {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void loadTenantsPage() throws InterruptedException {
        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]")));
        menuButton.click();
    }

    public void swipeToAudit() throws InterruptedException{
        java.util.List<WebElement> swipeables = driver.findElements(By.className("swipeable-list"));
        System.out.println(swipeables.size());

        for(int i = 0; i < swipeables.size(); i++){
            boolean staleElementLoaded = true;
            while(staleElementLoaded) {
                try{
                    int posX = swipeables.get(i).getLocation().x;
                    int posY = swipeables.get(i).getLocation().y;
                    System.out.println("tenantCard is at: "+ posX+","+posY);
                    Actions action = new Actions(driver);
                    action.moveByOffset(posX+250,posY);
                    action.clickAndHold();
                    action.moveByOffset(-250,0).release();
                    // Thread.sleep(3000);
                    action.build().perform();
                    Thread.sleep(3000);

                    //click the back button in browser
                    // WebElement backButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div/div[1]/div[1]/div/div/div/span")));
                    // backButton.click();
                    driver.navigate().back();
                    swipeables = driver.findElements(By.className("swipeable-list"));
                    staleElementLoaded = false;
                } catch (StaleElementReferenceException e) {
                    staleElementLoaded = true;
                }

            }
            
        }
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
    public void testSwipeToAudit() throws InterruptedException{
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
    }

    @After
    public void quit() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

}


