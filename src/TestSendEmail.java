import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TestSendEmail {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement email;
    public static WebElement password;
    public static WebElement loginButton;
    public static ChromeOptions chromeOptions;

    public void loadTenantsPage() throws InterruptedException {
//        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a/span")));
//        menuButton.click();
//        Thread.sleep(2000);
        WebElement tenantsButton =
                wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"root" +
                        "\"]/section/div/ul/li[4]/a"))));
        highlight(tenantsButton);
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

    public static void highlight(WebElement webElement) {
        String jsSyyle = "'3px solid red'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=" + jsSyyle, webElement);
        try {
            Thread.sleep(550);
        } catch (InterruptedException e) {
            //do nothing
        }
        js.executeScript("arguments[0].style.border=" + "null", webElement);
    }

    private void clickTenant() {
        WebElement tenantButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-0\"]/section[1]/div/div/div")));
//        WebElement tenantButton = driver.findElement((By.xpath("//*[@id=\"rc-tabs-2-panel-0\"]/section[1]/div/div/div/div[2]")));
        highlight(tenantButton);
        tenantButton.click();
    }

    private void clickSelf() {
        WebElement tenantButton = driver.findElement((By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/label/span[1]/input")));
        highlight(tenantButton);
        tenantButton.click();
    }

    private void clickSendEmail() {
        WebElement sendEmailButton = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"root\"]/section/main/div[1]/div[1]/div[2]/div[4]/button[2]/span"))));
        highlight(sendEmailButton);
        sendEmailButton.click();
    }

    private void clickReport() {
        WebElement report = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"root" +
                "\"]/section/main/div/section[1]/div/div[2" +
                "]/div/span[1]"))));
        highlight(report);

        report.click();
    }



    public void clickSend() {
        WebElement fnbButton = driver.findElement((By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")));
        highlight(fnbButton);
        fnbButton.click();
    }

    @Before
    public void loginStaff() throws InterruptedException {
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
        highlight(email);
        email.sendKeys("sgh@auditor.com");
        highlight(password);
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        highlight(loginButton);
        loginButton.click();
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
        Thread.sleep(3500);
        clickReport();
        Thread.sleep(1500);
        clickSendEmail();
//        Thread.sleep(1500);
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
