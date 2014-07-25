// Copyright (c) 2014 cranberrygame
// Email: cranberrygame@yahoo.com
// Phonegap plugin: http://www.github.com/cranberrygame
// Construct2 phonegap plugin: https://www.scirra.com/forum/viewtopic.php?f=153&t=109586
//                             https://dl.dropboxusercontent.com/u/186681453/index.html
//                             https://www.scirra.com/users/cranberrygame
// Facebook: https://www.facebook.com/profile.php?id=100006204729846
// License: MIT (http://opensource.org/licenses/MIT)
using System.Windows;
using System.Runtime.Serialization;
using WPCordovaClassLib.Cordova;
using WPCordovaClassLib.Cordova.Commands;
using WPCordovaClassLib.Cordova.JSON;
using Microsoft.Phone.Tasks;//MarketplaceDetailTask,MarketplaceReviewTask

using System.Diagnostics; //Debug.WriteLine

namespace Cordova.Extension.Commands
{
    public class AppPage : BaseCommand
    {

        public void openAppPage(string args)
        {
			Debug.WriteLine("test");
  
			//JsonHelper.Deserialize<string[]>(args)[0];

			string appid=JsonHelper.Deserialize<string[]>(args)[0];
			string page=JsonHelper.Deserialize<string[]>(args)[1];
			
			//app page
			if (page=="app_page"){
				//http://stackoverflow.com/questions/17656011/windows-phone-c-sharp-link-to-buy-app
				MarketplaceDetailTask marketplaceDetailTask = new MarketplaceDetailTask();
				marketplaceDetailTask.ContentIdentifier = appid;
				marketplaceDetailTask.ContentType = MarketplaceContentType.Applications;			
				marketplaceDetailTask.Show();
					
				DispatchCommandResult(new PluginResult(PluginResult.Status.OK, "ok"));					
			}
			//review page
			else if (page=="review_page"){
				//http://msdn.microsoft.com/en-us/library/windowsphone/develop/hh394030(v=vs.105).aspx
				MarketplaceReviewTask marketplaceReviewTask = new MarketplaceReviewTask();
				//marketplaceReviewTask.ContentIdentifier = appid; //compile error
				//marketplaceReviewTask.ContentType = MarketplaceContentType.Applications; //compile error
				marketplaceReviewTask.Show();
					
				DispatchCommandResult(new PluginResult(PluginResult.Status.OK, "ok"));			
			}
			
			
        }        

	}
}