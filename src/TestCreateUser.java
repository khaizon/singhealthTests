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

public class TestCreateUser {
    public WebDriver driver;
 

    public void fillInTenantFailWrongEmail() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[1]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("hello");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("abcdef");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("12345");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantFailUsedEmail() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[1]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("teststrhranrsbnbnrsbr");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("test@tenant.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("sgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantFailUsedName() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[1]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("hello");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("testing131313@tenant.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("cgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInTenantSuccess() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[1]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("helloworld");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("testing181818@tenant.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("cgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailWrongEmail() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[2]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("hello");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("abcdef");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("12345");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailUsedEmail() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[2]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("teststrhranrsbnbnrsbr");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("sgh@auditor.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("sgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorFailUsedName() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[2]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("sgh");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("testingzz@auditor.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("cgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }
    
    public void fillInAuditorSuccess() throws InterruptedException {
    	WebElement loginUserType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[1]/label[2]"));
    	loginUserType.click();
    	WebElement name = driver.findElement(By.xpath("/html/body/div/section/main/form/div[2]/div[2]/div/div/input"));
        name.sendKeys("helloworld");
    	WebElement email = driver.findElement(By.xpath("/html/body/div/section/main/form/div[3]/div[2]/div/div/input"));
        email.sendKeys("testing1818@auditor.com");
        WebElement institution = driver.findElement(By.xpath("/html/body/div/section/main/form/div[4]/div[2]/div/div/input"));
        institution.sendKeys("cgh");
        WebElement userType = driver.findElement(By.xpath("/html/body/div/section/main/form/div[5]/div/div/div/div/label[1]/span[1]/input"));
        userType.click();
        WebElement submit = driver.findElement((By.xpath("/html/body/div/section/main/form/div[7]/div/div/div/button[1]")));
        submit.click();
        Thread.sleep(3000);
    }

    @Before
    public void createUserPage() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
    	System.setProperty("webdriver.edge.driver","C:\\Users\\Windows\\eclipse-workspace\\ESCSelenium\\drivers\\edgedriver\\msedgedriver.exe");
		this.driver = new EdgeDriver();
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
        Thread.sleep(2000);
        this.driver.get("http://localhost:3000/createuser");

        Thread.sleep(3000);

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
