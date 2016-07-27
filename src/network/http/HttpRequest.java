package network.http;

public class HttpRequest {
	public enum RequestMethod{
		get("get"),
		head("head");
		
		RequestMethod(String val){
			
		}
	}
	
	public boolean isValid = false;
	public RequestMethod requestMethod = null;
	public String requestUrl = null;
	public String httpVersion = "HTTP/1.1";
	
	public HttpRequest(String request){
		int index = request.indexOf(" ");
		try{
			requestMethod = RequestMethod.valueOf(RequestMethod.class, request.substring(0,index).trim().toLowerCase());
			request=request.substring(index+1);
			index = request.indexOf(" ");
			requestUrl = request.substring(0,index).trim();
			isValid = true;
		}catch(IllegalArgumentException e){
			isValid = false;
		}
	}
	
	public String toString(){
		String string = "";
		string+="Http Request Summary\n\n";
		string+=("isValid: " + this.isValid + "\n");
		string+=("requestMethod: " + this.requestMethod + "\n");
		string+=("requestUrl: " + this.requestUrl + "\n");
		return string;
		
	}
}
