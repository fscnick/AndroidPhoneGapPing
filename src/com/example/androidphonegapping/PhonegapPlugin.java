package com.example.androidphonegapping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class PhonegapPlugin extends CordovaPlugin {
	 
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
		if (action.compareTo("ping")==0){
			//String host="192.168.0.155";
			String host=args.getString(0);

			try { 
				InetAddress inet=InetAddress.getByName(host);
				boolean result=inet.isReachable(5000);
				if(result)
					callbackContext.success();
				return result;
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("UnknownHostException");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("IOException");
				e.printStackTrace();
			}
		}
		return false;
	 
	}

}
