//Copyright (c) 2014 Sang Ki Kwon (Cranberrygame)
//Email: cranberrygame@yahoo.com
//Homepage: http://www.github.com/cranberrygame
//License: MIT (http://opensource.org/licenses/MIT)
package com.cranberrygame.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.app.Activity;
import android.util.Log;
//
import java.util.List;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class InstallApp extends CordovaPlugin {
	private static final String LOG_TAG = "InstallApp";
	
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);		
    }
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		//args.length()
		//args.getString(0)
		//args.getString(1)
		//args.getInt(0)
		//args.getInt(1)
		//args.getBoolean(0)
		//args.getBoolean(1)
		//JSONObject json = args.optJSONObject(0);
		//json.optString("adUnit")
		//json.optString("adUnitFullScreen")
		//JSONObject inJson = json.optJSONObject("inJson");
			
		if (action.equals("getInstalledApps")) {
			//Activity activity = cordova.getActivity();
			//webView
			//				
			
			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable(){
				@Override
				public void run() {						
					_getInstalledApps(delayedCC);				
				}
			});
			
			return true;
		}		
		
		return false; // Returning false results in a "MethodNotFound" error.
	}
	
	//-------------------------------------
	
	private void _getInstalledApps(CallbackContext callbackContext) {
 		//http://neverland.googlecode.com/svn/trunk/NeverLand/src/com/nearme/plugin/webview/client/cordova/AppLauncher.java
		final JSONArray installedApps = new JSONArray();
		try{		
			final List<PackageInfo> apps = cordova.getActivity().getPackageManager().getInstalledPackages(PackageManager.GET_SIGNATURES);
			for (PackageInfo packageInfo : apps) {
				if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
					final JSONObject jsonObject = getJsonByPackageInfo(packageInfo);
					installedApps.put(jsonObject);
				}
			}
			
			PluginResult pr = new PluginResult(PluginResult.Status.OK, installedApps);
			//pr.setKeepCallback(true);
			callbackContext.sendPluginResult(pr);
			//PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
			//pr.setKeepCallback(true);
			//callbackContext.sendPluginResult(pr);
		}
		catch(JSONException ex){
			//PluginResult pr = new PluginResult(PluginResult.Status.OK, installedApps);
			//pr.setKeepCallback(true);
			//callbackContext.sendPluginResult(pr);
			PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
			//pr.setKeepCallback(true);
			callbackContext.sendPluginResult(pr);
		}
	}

	private JSONObject getJsonByPackageInfo(final PackageInfo pi) throws JSONException {
		final JSONObject jsonResult = new JSONObject();
		jsonResult.put("packageName", pi.packageName);
		jsonResult.put("versionCode", pi.versionCode);
		jsonResult.put("versionName", pi.versionName);
		jsonResult.put("sourceDir", pi.applicationInfo.sourceDir);
		
		return jsonResult;
	}	
}