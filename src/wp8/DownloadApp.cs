//Copyright (c) 2014 Sang Ki Kwon (Cranberrygame)
//Email: cranberrygame@yahoo.com
//Homepage: http://www.github.com/cranberrygame
//License: MIT (http://opensource.org/licenses/MIT)
using System;
using System.Windows;
using System.Runtime.Serialization;
using WPCordovaClassLib.Cordova;
using WPCordovaClassLib.Cordova.Commands;
using WPCordovaClassLib.Cordova.JSON;
using Microsoft.Phone.Tasks;//MarketplaceDetailTask,MarketplaceReviewTask

using System.Diagnostics; //Debug.WriteLine

namespace Cordova.Extension.Commands
{
    public class DownloadApp : BaseCommand
    {

        public void openDownloadAppUrl(string args)
        {
			Debug.WriteLine("test");
  
			//JsonHelper.Deserialize<string[]>(args)[0];

			string appId=JsonHelper.Deserialize<string[]>(args)[0];

			//http://stackoverflow.com/questions/17656011/windows-phone-c-sharp-link-to-buy-app
			MarketplaceDetailTask marketplaceDetailTask = new MarketplaceDetailTask();
			marketplaceDetailTask.ContentIdentifier = appId;
			marketplaceDetailTask.ContentType = MarketplaceContentType.Applications;			
			marketplaceDetailTask.Show();
				
			DispatchCommandResult(new PluginResult(PluginResult.Status.OK, "ok"));			
        }        

	}
}