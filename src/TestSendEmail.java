import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSendEmail {

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

    public void swipeToSend() throws InterruptedException {
        WebElement tenantCard = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div/section[1]/div/div[2]/div/span[1]")));
        int posX = tenantCard.getLocation().x;
        int posY = tenantCard.getLocation().y;
        System.out.println("tenantCard is at: " + posX + "," + posY);
        Actions action = new Actions(driver);
        action.moveByOffset(posX + 350, posY).clickAndHold().moveByOffset(-350, 0).release();
        action.build().perform();
    }

    private void clickTenant() {
        WebElement tenantButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[3]/div[7]/div/div[2]/div/span")));
        tenantButton.click();
    }

    private void clickSelf() {
        WebElement tenantButton = driver.findElement((By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/label/span[1]/input")));
        tenantButton.click();
    }

    private void clickSendEmail() {
        WebElement tenantButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div/div[2]/div[2]/button[2]/span")));
        tenantButton.click();
    }

    private void clickReport() {
        WebElement tenantButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div/section[1]/div/div[2]/div/span[1]")));
        tenantButton.click();
    }

    public void clickSend() {
        WebElement fnbButton = driver.findElement((By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")));
        fnbButton.click();
    }

    @Before
    public void loginStaff() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
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
        Thread.sleep(1000);
        loginButton.click();


        Thread.sleep(3000);
    }

    @Test
    public void testLoadTenantsPage() throws InterruptedException {
        loadTenantsPage();
    }

    @Test
    public void testclickTenant() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(2500);
        clickTenant();
        Thread.sleep(5500);
    }

    @Test
    public void testclickReport() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(2500);
        clickTenant();
        Thread.sleep(5500);
        clickReport();
        Thread.sleep(5500);
    }

    @Test
    public void testclickSendEmail() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(2500);
        clickTenant();
        Thread.sleep(5500);
        clickReport();
        Thread.sleep(5500);
        clickSendEmail();
        Thread.sleep(1500);
    }

    @Test
    public void testclickSelf() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(2500);
        clickTenant();
        Thread.sleep(5500);
        clickReport();
        Thread.sleep(5500);
        clickSendEmail();
        Thread.sleep(1500);
        clickSelf();
        Thread.sleep(1500);
    }

    @Test
    public void testSendEmail() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(2500);
        clickTenant();
        Thread.sleep(5500);
        clickReport();
        Thread.sleep(5500);
        clickSendEmail();
        Thread.sleep(1500);
        clickSelf();
        Thread.sleep(1500);
        clickSend();
        Thread.sleep(1500);
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
