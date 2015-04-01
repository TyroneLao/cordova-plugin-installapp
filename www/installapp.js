
module.exports = {
	openInstallAppUrl : function (installAppUrl) {
		//Cordova.exec(null,null,"InstallApp","openInstallAppUrl",["6ce1aaa4-0226-4791-9c43-5e9e21e5f5a2"]);//success,fail,class,method,params
		Cordova.exec(null,null,"InstallApp","openInstallAppUrl",[installAppUrl]);//success,fail,class,method,params
		//alert("test");
	},	
	getInstalledApps: function(success, failure) {
        cordova.exec(
            success,
            failure,
            'InstallApp',
            'getInstalledApps',
            []
        ); 
    }	
};
