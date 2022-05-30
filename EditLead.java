package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	
		public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		 WebDriverManager.chromedriver().setup();
	      ChromeDriver driver = new ChromeDriver();
	      driver.get("http://leaftaps.com/opentaps/control/login");
	      driver.manage().window().maximize();
	      //Enter the username
	      WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
	      eleUserName.sendKeys("DemoSalesManager");
	      //Enter the password
	      driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys("crmsfa");
	      //Click Login
	      driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	      //Click crm/sfa link
	      driver.findElement(By.linkText("CRM/SFA")).click();
	      //Click Leads link
	      driver.findElement(By.linkText("Leads")).click();
	      //Click Find leads
          driver.findElement(By.linkText("Find Leads")).click();
          //enter first name
	      driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("Babu");
	      //Click Find leads button
	      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	      Thread.sleep(2000);
	      //Click on first resulting lead
	      driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	      //Verify title of the page
	      System.out.println("The title is :"+ driver.getTitle());
	    //Click Edit
	      driver.findElement(By.xpath("//a[text()='Qualify Lead']/following-sibling::a")).click();
	      Thread.sleep(2000);
	      //Change the company name
          driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("CTS");
          //Click Update
          driver.findElement(By.name("submitButton")).click();
          WebElement p=driver.findElement(By.id("viewLead_companyName_sp"));
          System.out.println("The Changed name is : " + p.getText());
	      driver.close();

 }

}
