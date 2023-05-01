package session5;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VeriousConcept {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver,chrome,driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		WebElement NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement LOGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
		
		NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		LOGIN_BUTTON_ELEMENT.click();
		WebElement DASHBOARD_Header_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));

//		
//		By USER_NAME_FIELD=By.xpath("//input[@id='username']");
//		By PASSWORD_FIELD=By.xpath("//input[@id='password']");
//		By LOGIN_FIELD=By.xpath("//button[@name='login']");
//		By DASHBORAD_HEADER_FIELD=By.xpath("//h2[contains(text(),' Dashboard ')]");
//		
	
		Assert.assertTrue("the page is not found", DASHBOARD_Header_ELEMENT.isDisplayed());
	}
}
