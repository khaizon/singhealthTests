import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setup() throws InterruptedException{
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testLoginAsAuditor() throws InterruptedException{

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[2]/div[2]/div/div/input"));
        email.sendKeys("cgh@auditor.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div[2]/div/div/input"));
        password.sendKeys("cgh2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div[5]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(2000);
    }

    @Test
    public void testLoginAsTenant() throws InterruptedException{

        WebElement loginAsButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div[1]/label[1]/span[2]")));
        loginAsButton.click();

        WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[2]/div[2]/div/div/input"));
        email.sendKeys("cghNoelGifts@tenant.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div[2]/div/div/input"));
        password.sendKeys("noelgifts2021");

        WebElement loginButton = driver.findElement((By.xpath("//*[@id=\"root\"]/div/form/div[5]/div/div/div/button/span")));
        loginButton.click();

        Thread.sleep(2000);
    }

    @After
    public void quit() throws InterruptedException{
        driver.quit();
    }
}


