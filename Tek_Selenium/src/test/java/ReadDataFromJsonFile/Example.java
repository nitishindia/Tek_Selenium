
package ReadDataFromJsonFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Example {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		// step-1 : parse json physical file in to java object using jsonparse class
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\dell\\Desktop\\Command_Line\\jasonCommonData.json"));
		
		
		// step-2 : convert java object in to jsonobject using down casting
		JSONObject map = (JSONObject) obj;
		
		// step-3 : get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
	}

}
