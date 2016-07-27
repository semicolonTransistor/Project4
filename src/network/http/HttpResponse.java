package network.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.json.JSONObject;

public class HttpResponse {
	HttpResponseConfig.responceType responceType;
	String statcodeString;
	String reasonPhrase;
	File messageBody;
	
	public HttpResponse(HttpResponseConfig.responceType responceType,File message){
		this.responceType = responceType;
		JSONObject responseTypeInfo = HttpResponseConfig.responceTypeMap.getJSONObject(responceType.toString());
		this.statcodeString = responseTypeInfo.getString("code");
		this.reasonPhrase = responseTypeInfo.getString("reasonPhrase");getClass();
		this.messageBody = message;
	}
	
	public void send(OutputStreamWriter writer) throws IOException{
		writer.write(HttpResponseConfig.HttpVersion + " " + statcodeString + " " + reasonPhrase + "\r\n");
		if(messageBody != null){
			FileInputStream file = new FileInputStream(messageBody);
			int thisByte = -1;
			while((thisByte = file.read()) != -1){
				writer.write(thisByte);
			}
			file.close();
			writer.write("\r\n");
		}
		writer.flush();
		System.out.println(HttpResponseConfig.HttpVersion + " " + statcodeString + " " + reasonPhrase + "\r\n\r\n");
	}
	
}
