package Practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_CreateContact_Test1 {
	
	@Test (dataProvider = "getData")
	public void createContactTest(String firstName , String LastName) {
		
		System.out.println("FirstNamne :" +firstName + ", LastName :" + LastName);
	}




	@DataProvider
	public Object[][] getData() {
		Object [][] objArr = new Object[3][2];
		objArr[0][0] = "Deepak";
		objArr[0][1] = "HR";
		
		objArr[1][0] = "sam";
		objArr[1][1] = "HOD";
		
		objArr[2][0] = "jhon";
		objArr[2][1] = "Deepak";
		
		return objArr;
		
	}
}