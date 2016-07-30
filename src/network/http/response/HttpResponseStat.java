package network.http.response;

import org.json.JSONObject;

import network.http.HttpConfig;

public class HttpResponseStat {
	HttpResponse.ResponseType responseType;
	String httpVersion;
	String statCode;
	String reasonPharse;

	public HttpResponseStat(HttpResponse.ResponseType responseType, String reasonPharse){
		this.httpVersion = HttpConfig.HttpVersion;
		this.responseType = responseType;
		JSONObject responseDataMap = HttpConfig.responceTypeMap.getJSONObject(this.responseType.toString());
		this.statCode = responseDataMap.getString("code");
		if(reasonPharse != null){
			this.reasonPharse = reasonPharse;
		}else{
			this.reasonPharse = responseDataMap.getString("reasonPhrase");
		}
	}
	
	public HttpResponseStat(HttpResponse.ResponseType responseType){
		this(responseType,null);
	}
	
	public String toString(){
		return httpVersion + " " + statCode + " " + reasonPharse + "\r\n";
		
	}
}
