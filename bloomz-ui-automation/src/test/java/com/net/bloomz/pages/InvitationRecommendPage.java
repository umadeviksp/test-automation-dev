package com.net.bloomz.pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class InvitationRecommendPage {
	
	public InvitationRecommendPage testFunc1()	{
		
		String sURL = "https://app-staging.bloomz.net/api/admin/updateuser?email=pop@pop.pop&action=getDetails"; //just a string
		String myStr ;
		
		try {
			// Connect to the URL using java's native library
			URL url = new URL(sURL);
			HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); //from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
			myStr = rootobj.get("primaryemail").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("createdtime").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("invitationcode").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("userregistrationstatus").getAsString(); //just grab the text
			System.out.println(myStr);
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return this ;		
	}

}
