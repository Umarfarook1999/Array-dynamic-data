package practiceTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingLead extends ProjectCommonCases {
@DataProvider(name = "create")
	public String[][] fetchData() {
	String [][] data = new String [2][4];
	data [0][0] = "Teatleaf";
	data[0][1] = "Hari";
	data[0][2] = "R";
	data[0][3] = "99";
	
	data[1][0] = "TCS";
	data[1][1] = "Babu";
	data[1][2] = "M";
	data[1][3] = "TCS";
	return data;
	
		

	}
	
@Test(dataProvider = "create")
	public void creatinglead (String cName, String fName, String lName, String pNumber) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNumber);
		driver.findElement(By.name("submitButton")).click();
		
}
}


//Steps to follow
    //to convert normal test case into testng test cases
	//remove the static keyword, remove argument in the main method, and rename the main method name
	//add @test annotation at the top of the method below the class name




