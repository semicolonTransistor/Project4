package Misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;

public class Helpers {
	public static JSONObject JSONFromFile(File file) throws IllegalArgumentException, IOException{
		if(file.isFile()){
			FileInputStream input;
			input = new FileInputStream(file);
			byte[] readBuffer = new byte[input.available()];
			input.read(readBuffer);
			input.close();
			return new JSONObject(new String(readBuffer));
		}else{
			throw new IllegalArgumentException(file.getPath() + " does not name a file");
		}
	}
}
