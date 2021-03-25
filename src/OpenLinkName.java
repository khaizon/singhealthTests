import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenLinkName {
	
	public static void main(String[] args) {		
		
		// set the firefox driver
		System.setProperty("chromedriver", "C:\\");

		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();

		// open my webpage
		driver.get("https://sudiptac.bitbucket.io/");
				
		// click the link with name "ASSET research group"
		driver.findElement(By.linkText("ASSET Research Group")).click();
		
		// click the link name "Sakshi Udeshi"
		driver.findElement(By.linkText("Sakshi Udeshi")).click();
		
		// click the link name "Publications"
		driver.findElement(By.linkText("Publications")).click();

	}
}
