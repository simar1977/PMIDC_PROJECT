package com.covid.mis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {

	//for sms send after registration
		public static void sendSms(String message, String number)
		{
			//System.out.println(message);
			//System.out.println(number);
			
			try {	
				String apiKey="0qrx6tgV8OThfji5BGaw4CM9NpXEyLdKokH27YIJFnRlDv3mUWXIyxGamjRVKsDQLM10PuwCvY36TU5p";
				String sendId="TXTIND";
				
				//importent step...
				message=URLEncoder.encode(message,"UTF-8");
				String language="english";
				String route="v3";
				String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&route="+route+"&language="+language+"&numbers="+number;

				
				//sending get request using java..
				URL url=new URL(myUrl);
				
				HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
				
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				con.setRequestProperty("cache-control","no-cashe");
				System.out.println("wait..............");
				
				int code = con.getResponseCode();
				System.out.println("Response code" +code);
				
				StringBuffer response=new StringBuffer();
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				while(true) {
					String line=br.readLine();
					if(line==null) {
						break;
					}
					response.append(line);
				}
				
				System.out.println(response);
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
//		public static void main(String[] args) {
//			System.out.println("Program started......");
//			SendSms.sendSms("Thank you for the Registration...."+new Date().toLocaleString(),"6268698585");
//		}
}
