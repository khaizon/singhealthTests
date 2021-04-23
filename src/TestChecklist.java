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

public class TestChecklist {
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static WebDriverWait wait;te
    public static WebElement loginButton;
    public static WebElement email;
    public static WebElement password;

    public void loadTenantsPage() throws InterruptedException {
//        WebElement menuButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a/span")));
//        menuButton.click();
//        Thread.sleep(2000);
        WebElement tenantsButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/div/ul/li[4]/a")));
        highlight(tenantsButton);
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
        try {
            js.executeScript("arguments[0].style.border=" + "null", webElement);
        } catch (StaleElementReferenceException e) {
            //do nothing
        }
    }

    public void swipeToAudit() throws InterruptedException {
        Thread.sleep(3000);
        WebElement tenantCard;

        boolean notLoaded = true;
        while (notLoaded) {
            try {
                tenantCard =
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-0\"]/section[1]/div/div/div")));
                highlight(tenantCard);
                int posX = tenantCard.getLocation().x;
                int posY = tenantCard.getLocation().y;
                System.out.println("tenantCard is at: " + posX + "," + posY);
                Actions action = new Actions(driver);
                action.moveByOffset(posX + 200, posY).clickAndHold().moveByOffset(-100, 0).release();
                action.build().perform();
                wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"root\"]")),
                        "New Audit"));
                notLoaded = false;
                Thread.sleep(3000);
            } catch (TimeoutException e) {
                driver.navigate().refresh();
                Thread.sleep(2000);

            }
        }
    }

    private void clickChecklistNext() {
        WebElement checklistNextButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[2]/button/span")));
        highlight(checklistNextButton);
        checklistNextButton.click();
    }

    private void clickChecklistNext2() {
        WebElement checklistNextButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[2]/button[2]/span")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", checklistNextButton);
        highlight(checklistNextButton);
        checklistNextButton.click();
    }

    private void clickSubmit() {
        WebElement checklistSubmitButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[2]/div/button[2]/span")));
        checklistSubmitButton.click();
    }

    private void clickAllCompliant() throws InterruptedException {
        WebElement subcat2 = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1" +
                "]/div[1" +
                "]/div[2]/div/div/div[2]/div[1]")));
        highlight(subcat2);
        subcat2.click();
        Thread.sleep(1000);
        WebElement subcat3 = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[2]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat3);
        highlight(subcat3);
        subcat3.click();
        Thread.sleep(1000);
        WebElement subcat4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat4);
        highlight(subcat4);
        subcat4.click();
        Thread.sleep(1000);
        WebElement subcat5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat5);
        highlight(subcat5);
        subcat5.click();
        Thread.sleep(500);
        WebElement subcat6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[3]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat6);
        highlight(subcat6);
        subcat6.click();
    }

    private void clickOneNonCompliant() throws InterruptedException {
        WebElement NC = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[1" +
                "]/div[2]/div/div/div[1]/div[2]/div/div/div/div/ul/li[1]/div/img")));
        highlight(NC);
        NC.click();
        Thread.sleep(1000);
        WebElement subcat2 = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1" +
                "]/div[1" +
                "]/div[2]/div/div/div[2]/div[1]")));
        highlight(subcat2);
        subcat2.click();
        Thread.sleep(1000);
        WebElement subcat3 = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[2]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat3);
        highlight(subcat3);
        subcat3.click();
        Thread.sleep(1000);
        WebElement subcat4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat4);
        highlight(subcat4);
        subcat4.click();
        Thread.sleep(1000);
        WebElement subcat5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat5);
        highlight(subcat5);
        subcat5.click();
        Thread.sleep(500);
        WebElement subcat6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[3]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subcat6);
        highlight(subcat6);
        subcat6.click();
    }

    public void clickFnBTemplate() {
        WebElement fnbButton = driver.findElement((By.xpath("//*[@id=\"root\"]/section/main/div[2]/a[2]/button/span")));
        fnbButton.click();
    }

    public void clickChecklist() {
        WebElement fnbButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-1-tab-2\"]")));
        highlight(fnbButton);
        fnbButton.click();
    }

    public void selectAuditDate() throws InterruptedException {
        WebElement AuditDatePicker = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div/table/tbody/tr[5]/td/div/div/input")));
        int posX = AuditDatePicker.getLocation().x;
        int posY = AuditDatePicker.getLocation().y;
        System.out.println("AuditDatePicker is at: " + posX + "," + posY);
        AuditDatePicker.click();
        WebElement notification = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/ul/li[6]/a"));
        highlight(AuditDatePicker);
        Thread.sleep(500);
        Actions action = new Actions(driver);
        action.moveToElement(notification, -10, -400).click();
        action.build().perform();
    }


    public void selectDueDate() throws InterruptedException {
        WebElement DueDatePicker = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/section/main/div[2]/div[1]/div/div/table/tbody/tr[6]/td/div/div/input")));
        int posX = DueDatePicker.getLocation().x;
        int posY = DueDatePicker.getLocation().y;
        System.out.println("AuditDatePicker is at: " + posX + "," + posY);
        highlight(DueDatePicker);

        DueDatePicker.click();
        WebElement notification = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/ul/li[6]/a"));
        Thread.sleep(500);
        Actions action = new Actions(driver);
        action.moveToElement(notification, -10, -320).click();
        action.build().perform();

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
        email.sendKeys("sgh@auditor.com");
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(3000);
    }

    @Test
    public void testLoadTenantsPage() throws InterruptedException {
        loadTenantsPage();
    }

    @Test
    public void testSwipeToAudit() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(2500);
    }

    @Test
    public void testSelectAuditDate() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
    }

    @Test
    public void testSelectDueDate() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);

    }

    @Test
    public void testClickChecklistNext() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);
        clickChecklistNext();
        Thread.sleep(1500);
    }

    @Test
    public void testClickNonCompliant() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);
        clickChecklistNext();
        Thread.sleep(1500);
        clickAllCompliant();
        Thread.sleep(1500);
    }

    @Test
    public void testChecklistNext2() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(3500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);
        clickChecklistNext();
        Thread.sleep(1500);
        clickAllCompliant();
        Thread.sleep(1500);
        clickChecklistNext2();
        Thread.sleep(1500);
    }

    @Test
    public void testSubmitCompliantChecklist() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);
        clickChecklistNext();
        Thread.sleep(1500);
        clickAllCompliant();
        Thread.sleep(1500);
        clickChecklistNext2();
        Thread.sleep(1500);
        clickSubmit();
        Thread.sleep(1500);
        clickChecklist();
        Thread.sleep(1500);
    }

    @Test
    public void testSubmitNonCompliantChecklist() throws InterruptedException {
        loadTenantsPage();
        Thread.sleep(1500);
        swipeToAudit();
        Thread.sleep(1500);
        selectAuditDate();
        Thread.sleep(1500);
        selectDueDate();
        Thread.sleep(1500);
        clickChecklistNext();
        Thread.sleep(1500);
        clickOneNonCompliant();
        Thread.sleep(1500);
        clickChecklistNext2();
        Thread.sleep(1500);
        clickSubmit();
        Thread.sleep(1500);
        clickChecklist();
        Thread.sleep(1500);
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        Thread.sleep(1000);
    }


}
