package network.http.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HttpResponse {
	public enum ResponseType{
		ok("ok"),
		redirect("redirect"),
		badRequest("badRequest"),
		unauthorized("unauthorized"),
		forbidden("fobidden"),
		notFound("notFound");
		
		ResponseType(String key){};
		
	}

	HttpResponse.ResponseType responceType;
	HttpResponseStat stat;
	File messageBody;
	
	public HttpResponse(HttpResponse.ResponseType responseType,File message){
		this.responceType = responseType;
		this.stat = new HttpResponseStat(responseType);
		this.messageBody = message;
	}
	
	public void send(OutputStreamWriter writer) throws IOException{
		writer.write(stat.toString());
		if(messageBody != null){
			FileInputStream file = new FileInputStream(messageBody);
			writer.write("Content-Length:" + messageBody.length() + "\r\n");
			writer.write("\r\n");
			int thisByte = -1;
			while((thisByte = file.read()) != -1){
				writer.write(thisByte);
			}
			file.close();
			writer.write("\r\n");
		}
		writer.flush();
		System.out.println(stat);
	}
	
}
