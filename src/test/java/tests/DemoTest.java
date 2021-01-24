package tests;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class DemoTest extends TestBase {
	
	@Test
	public void test1() {
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
        assertTrue(Driver.getDriver().getTitle().equals("Web Orders"));
        
	}
        
        @Test
        public void test2() {
        	
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");	
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(""); 
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
        
        assertTrue(errorMessage.isDisplayed());
        }
        
        @AfterMethod(alwaysRun = true)
    	public void teardownMethod() throws IOException {
    	Driver.quit();
	}   
     
}
