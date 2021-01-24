package tests;

//import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageClasses.LoginPage;


public class LoginTests extends TestBase {

	@Test
	public void positiveLogin(){
        
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); 
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        
        assertEquals(actualURL, expectedURL);
        //assertEquals(actualURL, expectedURL, "URL didn't match");//Optional argument with a failure message  
	}
	
	@Test
	public void positiveLoginUsingPageObjectModel(){
		
		LoginPage lp = new LoginPage();
        
        lp.usernameField.sendKeys("Tester");
        lp.passwordField.sendKeys("test"); 
        lp.loginButton.click();
        
        String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        
        assertEquals(actualURL, expectedURL);
        //assertEquals(actualURL, expectedURL, "URL didn't match");//Optional argument with a failure message  
	}
	
	
	@Test
	public void negativeLogin1UsingPOM(){
		
		LoginPage lp = new LoginPage();
		
        lp.usernameField.sendKeys("");
        lp.passwordField.sendKeys(""); 
        lp.loginButton.click();
        
        //WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
        assertTrue(lp.errorMessage.isDisplayed());
        //assertTrue("Error Message Is Not Displayed",!errorMessage.isDisplayed());
	}
	
	
	@Test
	public void negativeLogin1(){
		
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(""); 
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
   
        assertTrue(errorMessage.isDisplayed());
        //assertTrue("Error Message Is Not Displayed",!errorMessage.isDisplayed());
	}
	
	
	
	@Test
	public void negativeLogin2(){
		
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("incorrectPassword"); 
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
   
        assertTrue(errorMessage.isDisplayed());
        //assertTrue("Error Message Is Not Displayed",!errorMessage.isDisplayed());
	}
	@Test
	public void negativeLogin3(){
		
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("IncorrectUsername");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); 
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
   
        assertTrue(errorMessage.isDisplayed());
        //assertTrue("Error Message Is Not Displayed",!errorMessage.isDisplayed());
	}
}
