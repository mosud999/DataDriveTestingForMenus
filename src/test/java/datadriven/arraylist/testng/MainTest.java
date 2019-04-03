package datadriven.arraylist.testng;

import java.io.IOException;

import org.testng.annotations.Test;

public class MainTest extends BaseClass{
	
	@Test
	public void test1() throws IOException, InterruptedException
	{
		HomePageActualMenus homePageActualMenus = new HomePageActualMenus(driver);
		homePageActualMenus.clickOnDeals();
		//homePageActualMenus.actualDealsList();
		//homePageActualMenus.expectedDealsList();
		homePageActualMenus.dealsListVerification();
	}

}
