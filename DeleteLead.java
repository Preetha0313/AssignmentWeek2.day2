package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
        //Launch the browser
		WebDriverManager.chromedriver().setup();
	      ChromeDriver driver = new ChromeDriver();
	      driver.get("http://leaftaps.com/opentaps/control/main");
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
	      //Click on Phone
	      driver.findElement(By.xpath("//span[text()='Phone']")).click();
	      //Enter phone number
	      driver.findElement(By.name("phoneNumber")).sendKeys("99");
	      //Click find leads button
	      driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	      Thread.sleep(2000);
	      //Capture lead ID of First Resulting lead
	      String  i= driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
	      System.out.println(i);
	      Thread.sleep(2000);
	      //Click First Resulting lead
	      driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
	      //Click Delete
	      driver.findElement(By.linkText("Delete")).click();
	      //Click Find leads
	      driver.findElement(By.linkText("Find Leads")).click();
	      //Enter captured lead ID
	      driver.findElement(By.xpath("//input[@name='id']")).click();
	      //Click find leads button
           driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
           //Verify message "No records to display" in the Lead List. This message confirms the successful deletion
          if(driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).isDisplayed())
         {
        	 
         
        	 System.out.println("No Records found");
         }
         
         else 
         
         {
        	 System.out.println("Records are displayed");
        	 
         }
          //Close the browser (Do not log out)
         
	      driver.close();
         }
}

         
         

