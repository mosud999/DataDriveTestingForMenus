package datadriven.arraylist.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class RawDataFromExcel {


	public static Object[][] rawDataFromExcel() throws IOException {
		
		/*--------Loading Excel File and Stor the datas in Object [][]datas ------------------*/
		File file = new File("/Users/mosudahmed/eclipse-workspace/datadriven.arraylist.testng/src/main/resources/targetDealsList.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheetAt(0);
		
		Object [][]datas=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				XSSFCell cell=sheet.getRow(i).getCell(j);
				switch (cell.getCellType())
				{
				case STRING:
					datas[i-1][j]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					datas[i-1][j]=cell.getNumericCellValue();
					break;
					
				case BOOLEAN:
					datas[i-1][j]=cell.getBooleanCellValue();
					break;
				}
			}

		}
		return datas;
	}

}
