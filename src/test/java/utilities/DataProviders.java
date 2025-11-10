package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil= new ExcelUtility(path);  //creating an object for XLUtility
		int rowcount=xlutil.getRowCount("Sheet1");
		int cellcount=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[rowcount][cellcount];//created for two dimension array which can store the data user and password
		for(int i=1;i<=rowcount;i++) //read the data from xl storing in two deminsional array
		{
			for(int j=0;j<cellcount;j++)  // i is rows j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //here  //i is 1, j is 0
			}
		}
		return logindata; //returning two dimension array
		
	}
}
