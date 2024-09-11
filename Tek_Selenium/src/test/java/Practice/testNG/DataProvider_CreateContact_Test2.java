package Practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_CreateContact_Test2 {
	
	@Test (dataProvider = "getData")
	public void createContactTest(String firstName , String LastName , long phonenumber) {
		
		System.out.println("FirstNamne :" +firstName + ", LastName :" + LastName +", PhoneNumber : "+ phonenumber );
	}




	@DataProvider
	public Object[][] getData() {
		Object [][] objArr = new Object[3][3];
		objArr[0][0] = "Deepak";
		objArr[0][1] = "HR";
		objArr[0][2] = 9876543210l;
		
		objArr[1][0] = "sam";
		objArr[1][1] = "HOD";
		objArr[1][2] = 1234567890l;
		
		objArr[2][0] = "jhon";
		objArr[2][1] = "Deepak";
		objArr[2][2] = 9087654321l;
		
		return objArr;
		
	}
}