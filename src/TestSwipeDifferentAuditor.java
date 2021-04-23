import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class TestSwipeDifferentAuditor {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement email;
    public static WebElement password;
    public static WebElement loginButton;
    public static ChromeOptions chromeOptions;

    public void loadTenantsPage() throws InterruptedException {
        Thread.sleep(1000);
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"root" +
                "\"]/section/div/ul/li[4]/a"))));
        highlight(menuButton);
        menuButton.click();
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

    private void clickOtherInstitution() {
        WebElement otherInstitution =
                wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"root\"]/section/main/div[2" +
                        "]/div/div[1]/div[1]/div/div[3]"))));
        highlight(otherInstitution);

        otherInstitution.click();
    }

    public void swipeCGH() throws InterruptedException {
        Thread.sleep(1500);
        WebElement swipeableCGH;
        try {

            swipeableCGH = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"rc-tabs-0" +
                    "-panel-2\"]/div/div[1]/div/div[2]"))));
        } catch (TimeoutException e) {
            driver.navigate().refresh();
            clickOtherInstitution();
            swipeableCGH = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"rc-tabs-0" +
                    "-panel-2\"]/div/div[1]/div/div[2]"))));

        }

        int posX = swipeableCGH.getLocation().x;
        int posY = swipeableCGH.getLocation().y;
        System.out.println("swipeable is at: " + posX + "," + posY);
        highlight(swipeableCGH);
        Actions action = new Actions(driver);
        action.moveToElement(swipeableCGH, 250, 0);
        action.clickAndHold();
        action.moveByOffset(-100, 0).release();
        // Thread.sleep(3000);
        action.build().perform();
        Thread.sleep(3000);

    }

    public void loginCGH() throws InterruptedException {
        driver.get("http://localhost:3000/login");
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        highlight(email);
        email.sendKeys("currentixer@gmail.com");
        highlight(password);
        password.sendKeys("cgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        highlight(loginButton);
        loginButton.click();

        Thread.sleep(3000);
    }

    @Before
    public void loginStaff() throws InterruptedException {
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
        int height = 1072;
        driver.manage().window().setSize(new Dimension(width, height));

        driver.get("http://localhost:3000/");
        wait = new WebDriverWait(driver, 5);

        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        highlight(email);
        email.sendKeys("sgh@auditor.com");
        highlight(password);
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        highlight(loginButton);
        loginButton.click();

        Thread.sleep(3000);
    }

    @Test
    public void testSwipe() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        clickOtherInstitution();
        Thread.sleep(1500);

        swipeCGH();
        Thread.sleep(1500);
        loginCGH();
        loadTenantsPage();
        Thread.sleep(1500);
//        clickOtherInstitution();
        Thread.sleep(1500);
        swipeCGH();
        Thread.sleep(1500);
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}

