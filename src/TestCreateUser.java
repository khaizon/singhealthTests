import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCreateUser {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement loginButton;
    public static WebElement email;
    public static WebElement password;
    public static WebElement newName;
    public static WebElement newEmail;
    public static WebElement newInstitution;
    public static WebElement newType;
    public static WebElement submit;
    public static WebElement createTenant;


    public void fillInTenantFailWrongEmail() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("hello");
        newEmail.sendKeys("abcdef");
        newInstitution.sendKeys("OCH");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantFailUsedEmail() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("teststrhranrsbnbnrsbr");
        newEmail.sendKeys("test@tenant.com");
        newInstitution.sendKeys("OCH");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantFailUsedName() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("hello");
        newEmail.sendKeys("testing131313@tenant.com");
        newInstitution.sendKeys("cgh");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantSuccess() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("helloworld");
        newEmail.sendKeys("testing181818@tenant.com");
        newInstitution.sendKeys("cgh");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailWrongEmail() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("hello");
        newEmail.sendKeys("abcdef");
        newInstitution.sendKeys("OCH");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailUsedEmail() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("teststrhranrsbnbnrsbr");
        newEmail.sendKeys("sgh@auditor.com");
        newInstitution.sendKeys("sgh");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailUsedName() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("sgh");
        newEmail.sendKeys("testingzz@auditor.com");
        newInstitution.sendKeys("cgh");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorSuccess() throws InterruptedException {
        createTenant.click();
        newName.sendKeys("helloworld");
        newEmail.sendKeys("testing1818@auditor.com");
        newInstitution.sendKeys("cgh");
        Thread.sleep(100);
        newInstitution.sendKeys(Keys.RETURN);
        newType.click();
        submit.click();
        Thread.sleep(3000);
    }

    @Before
    public void createUserPage() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        int width = 600;
        int height = 1000;
        driver.manage().window().setSize(new Dimension(width, height));

        driver.get("http://localhost:3000");

        wait = new WebDriverWait(driver, 5);

        Thread.sleep(2500);
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        email.sendKeys("sgh@auditor.com");
        password.sendKeys("sgh2021");
        loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div/div[5]/div/div/div/button/span")));
        loginButton.click();
        Thread.sleep(4000);
        WebElement settings = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/ul/li[6]/a"));
        settings.click();
        Thread.sleep(1000);
        WebElement newUser = driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-tab-4\"]"));
        newUser.click();

        Thread.sleep(3000);
        createTenant = driver.findElement(By.xpath("//*[@id=\"control-hooks\"]/div[1]/label[1]/span[2]"));
        newName = driver.findElement(By.xpath("//*[@id=\"control-hooks_name\"]"));
        newEmail = driver.findElement(By.xpath("//*[@id=\"control-hooks_email\"]"));
        newInstitution = driver.findElement(By.xpath("//*[@id=\"control-hooks_institution\"]"));
        newType = driver.findElement(By.xpath("//*[@id=\"control-hooks_type\"]/label[2]/span[1]/input"));
        submit = driver.findElement(By.xpath("//*[@id=\"control-hooks\"]/div[7]/div/div/div/button[1]/span"));



        Thread.sleep(3000);
    }

    @Test
    public void testTenantWrongEmail() throws InterruptedException{
        fillInTenantFailWrongEmail();
    }
    
    @Test
    public void testTenantUsedEmail() throws InterruptedException{
        fillInTenantFailUsedEmail();
    }
    
    @Test
    public void testTenantUsedName() throws InterruptedException{
        fillInTenantFailUsedName();
    }
    
    @Test
    public void testTenantSuccess() throws InterruptedException{
        fillInTenantSuccess();
    }
    
    @Test
    public void testAuditorWrongEmail() throws InterruptedException{
        fillInAuditorFailWrongEmail();
    }
    
    @Test
    public void testAuditorUsedEmail() throws InterruptedException{
        fillInAuditorFailUsedEmail();
    }
    
    @Test
    public void testAuditorUsedName() throws InterruptedException{
        fillInAuditorFailUsedName();
    }
    
    @Test
    public void testAuditorSuccess() throws InterruptedException{
        fillInAuditorSuccess();
    }


    @After
    public void quit() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }


}
