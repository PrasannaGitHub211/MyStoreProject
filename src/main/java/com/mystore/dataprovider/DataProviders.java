/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

/**
 * @author Shree Computers
 *
 */
public class DataProviders {

	NewExcelLibrary excellLibraryObj = new NewExcelLibrary();
	
	@DataProvider(name="credentials")
	public Object[][] getCredentials()
	{
		//Total rows count
		int rows = excellLibraryObj.getRowCount("Credentials");
		//Total column count
		int column = excellLibraryObj.getColumnCount("Credentials");
		int actRows = rows-1;
		
		
		Object[][] data = new Object[actRows][column];
		
		for(int i=0;i<actRows;i++)
		{
			for(int j=0;j<column;j++)
			{
				data[i][j] = excellLibraryObj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="createAcntDetails")
	public Object[][] getCreatAcntDetls()
	{
				//Total rows count
				int rows = excellLibraryObj.getRowCount("CreateAccountDetails");
				//Total column count
				int column = excellLibraryObj.getColumnCount("CreateAccountDetails");
				int actRows = rows-1;
				
				
				Object[][] data = new Object[actRows][column];
				
				for(int i=0;i<actRows;i++)
				{
					for(int j=0;j<column;j++)
					{
						data[i][j] = excellLibraryObj.getCellData("CreateAccountDetails", j, i+2);
					}
				}
				return data;
	}
	
}
