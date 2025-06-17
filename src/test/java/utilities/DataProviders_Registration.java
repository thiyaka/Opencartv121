package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders_Registration {
	

	@DataProvider(name="RegisterData")
	public String [][] getdata() throws IOException{
		
		//String path=".\\testData\\test_data.xlsx";
		//OpencartV121/testData/test_data.csv
		String path=".\\testData\\Opencart_AcctRegistrationData.xlsx";
		
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcol=xlutil.getCellCount("Sheet1",1);
		
		String registerdata [][]= new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0; j<totalcol;j++) {
				registerdata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return registerdata;
				
	}
	
}
