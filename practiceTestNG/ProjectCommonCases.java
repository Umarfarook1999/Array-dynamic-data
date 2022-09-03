package practiceTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectCommonCases {
	
	public RemoteWebDriver driver;
@Parameters({"browserName", "URL", "userName", "password"})
@BeforeMethod	
	public void basicCodes(String browserName, String URL, String userName, String password) {
	if(browserName.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	}
	else {
		if(browserName.equalsIgnoreCase("Edge"))
		WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();	
	}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
@AfterMethod
public void afterCondition () {
	
	driver.close();

}
	
	
	
	
	
	

}
