package network.http;
import org.json.*;

public class HttpResponseConfiger {
	public enum responceType{
		ok("ok"),
		redirect("redirect"),
		badRequest("badRequest"),
		unauthorized("unauthorized"),
		forbidden("fobidden"),
		notFound("notFound");
		
		responceType(String key){};
		
	}
	
	public static final JSONObject responceMap = new JSONObject("{\"ok\":{\"code\":\"200\",\"reasonPhrase\":\"Ok\"},\"redirct\":{\"code\":\"300\",\"reasonPhrase\":\"Redirct\",\"headers\":[\"location\"]},\"badRequest\":{\"code\":\"400\",\"reasonPhrase\":\"Bad Request\"},\"unauthorized\":{\"code\":\"401\",\"reasonPhrase\":\"Unauthorized\",\"headers\":[\"wwwAuthenticate\"]},\"forbidden\":{\"code\":\"404\",\"reasonPhrase\":\"Forbidden\"},\"notFound\":{\"code\":\"404\",\"reasonPhrase\":\"Not Found\"}}");
	
	public static final String HttpVersion = "HTTP/1.1";
	
	public static final String webRoot = "C:\\webroot";
}

