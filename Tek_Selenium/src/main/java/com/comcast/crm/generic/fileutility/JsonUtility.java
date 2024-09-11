package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		
		FileReader fileR = new FileReader("./configAppData/jasonCommonData.json");
		
		// step-1 : parse json physical file in to java object using jsonparse class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fileR);
		
		// step-2 : convert java object in to jsonobject using down casting
		JSONObject map = (JSONObject) obj;
		
		// step-3 : get the value from json file using key
		 String data = (String) map.get(key);
		 return data; 
		
	}

}
