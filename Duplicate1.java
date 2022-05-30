package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicate1 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Enter the username
		WebElement eleUserName=driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Login
        driver.findElement(By.className("decorativeSubmit")).click();
      //Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Click on Email
		driver.findElement(By.linkText("Email")).click();
		//Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("babu@testleaf.com");
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//Capture name of First Resulting lead
		String first=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='Babu']")).getText();
		System.out.println(first);
		//Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='Babu']")).click();
		String p=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(p);
		//Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		//Verify the title as 'Duplicate Lead'
        System.out.println("the title is: "+driver.getTitle());
        //Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//Confirm the duplicated lead name is same as captured name
		String i=driver.findElement(By.id("viewLead_companyName_sp")).getText();

		System.out.println(i);
		if(p.equals(i))
		{
			System.out.println("Duplicate records are having same same record");
		}
		else
		{
			System.out.println("Record names are different");
		}
		 //Close the browser (Do not log out)
		driver.close();
	}
}

