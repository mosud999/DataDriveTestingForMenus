package datadriven.arraylist.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePageActualMenus {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@id='secondary']")
	WebElement dealsElement;
	
	@FindBy(xpath="//ul[@class='NavigationList-sc-1ltyzy8-0 iHsBIj']/li")
	List<WebElement> dealsListElement;
	
	/*--------Constructor to initialize----------------*/
	public HomePageActualMenus(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*--------Click and open deals menu----------------*/
	public void clickOnDeals()
	{
		dealsElement.click();
		
	}
	
	/*--------Verify actual and expected data----------------*/
	public void dealsListVerification() throws IOException
	{
		ArrayList actList = actualDealsList();
		ArrayList expList = expectedDealsList();

		int actualCountriesNumber = actList.size();
		int expectedCountriesNumber = expList.size();

		if (actualCountriesNumber == expectedCountriesNumber) 
		{
			Iterator actualIterator = actList.iterator();
			Iterator expectedIterator = expList.iterator();

			while (actualIterator.hasNext() && expectedIterator.hasNext()) {

				Object obj1 = actualIterator.next();
				Object obj2 = expectedIterator.next();

				
				if (obj1.equals(obj2)) 
				{
					System.out.println(obj1 + " == " + obj2);
				} else
				{
					
					System.out.println(obj1 + " == " + obj2);
				}

			}

		} else {
	
			System.out.println("Actual country names number does not matched with Expected");
		}
		
	}
	
	
	
	/*--------Get actual data from website------------------*/
	public ArrayList<String> actualDealsList()
	{
		ArrayList<String> actual = new ArrayList<String>();
		for(WebElement e:dealsListElement)
		{
			String act=e.getText();
			actual.add(act);
			//System.out.println(act);
		}
		return actual;
	}
	
	/*--------Get expected data from website----------------*/
	public ArrayList<String> expectedDealsList() throws IOException
	{
		ArrayList<String> expected = new ArrayList<String>();
		Object [][] exp = RawDataFromExcel.rawDataFromExcel();
		
		for(int i=0; i<exp.length; i++)
		{
			for(int j=0; j<exp[i].length; j++)
			{
				expected.add(exp[i][j].toString());
		
			}
		}
		return expected;
		
		/*
		 * Iterator c = expected.iterator();
			while(c.hasNext())
			{
				System.out.println(c.next());
			}
		*/
		
	}

}
