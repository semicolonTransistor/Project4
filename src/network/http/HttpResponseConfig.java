package network.http;
import java.io.File;

import org.json.*;

import Misc.Helpers;

public class HttpResponseConfig {
	public enum responceType{
		ok("ok"),
		redirect("redirect"),
		badRequest("badRequest"),
		unauthorized("unauthorized"),
		forbidden("fobidden"),
		notFound("notFound");
		
		responceType(String key){};
		
	}
	
	public static JSONObject responceTypeMap = null;
	
	public static JSONObject fileTypeMap = null;
	
	public static String HttpVersion = "HTTP/1.1";
	
	public static String webRoot = "C:\\Users\\James\\workspace\\HomeServer\\WebContent";
	
	public static String defaultUrl = "/index.html";
	
	public static void loadConfig(){
		try{
			responceTypeMap = Helpers.JSONFromFile(new File("./resources/responsetypemap.json"));
			fileTypeMap = Helpers.JSONFromFile(new File("./resources/filetypemap.json"));
		}catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
}

