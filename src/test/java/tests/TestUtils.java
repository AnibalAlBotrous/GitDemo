package tests;

import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class TestUtils extends TestBase {
	
	@Test
	
	public void testScroll() {
		
		driver.get("https://www.duotech.io/");
		BrowserUtil.scroll(0, 2000);
		
		BrowserUtil.waitFor(5);
		
		BrowserUtil.takeScreenshot("Parcial");
		
		BrowserUtil.takeFullScreenshot("Full");
		
	}

}
