import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestChecklist {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void loadTenantsPage() throws InterruptedException {
        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/section/header/div/button/span")));
        menuButton.click();
        Thread.sleep(2000);
        WebElement tenantsButton =
                driver.findElement((By.xpath("//*[@id=\"nav-drawer\"]/div[2]/div/div/div[2]/ul/li[2]")));
        tenantsButton.click();
    }

    public void swipeToAudit() throws InterruptedException{
        WebElement tenantCard = driver.findElement((By.xpath("//*[@id=\"root\"]/section/section/section/main/div[3]/div[1]/div/div/div[3]/div")));
//        tenantCard.click();
        int posX = tenantCard.getLocation().x;
        int posY = tenantCard.getLocation().y;
        System.out.println("tenantCard is at: "+ posX+","+posY);
        Actions action = new Actions(driver);
        action.moveByOffset(550,229).clickAndHold().moveByOffset(-300,0).release();
        action.build().perform();
    }

    public void clickFnBTemplate() {
        WebElement fnbButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/section/section/main/div[2]/a[2]/button/span")));
        fnbButton.click();
    }



    @Before
    public void loginStaff() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        int width = 600;
        int height = 1200;
        driver.manage().window().setSize(new Dimension(width, height));
        driver.get("http://localhost:3000/");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[2]/div[2]/div/div/input"));
        email.sendKeys("cgh@auditor.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div[2]/div/div/input"));
        password.sendKeys("cgh2021");
        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div[5]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(3000);
    }

    @Test
    public void testLoadTenantsPage() throws InterruptedException{
        loadTenantsPage();
    }

    @Test
    public void testSwipeToAudit() throws InterruptedException{
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(2500);
    }

//    @Test
//    public void testCreateAuditFnB() throws InterruptedException{
//        loadTenantsPage();
//        Thread.sleep(1500);
//        swipeToAudit();
//        Thread.sleep(1500);
//        clickFnBTemplate();
//        Thread.sleep(2500);
//    }

    @After
    public void quit() throws InterruptedException{
        Thread.sleep(2000);
//        driver.quit();
    }
}
