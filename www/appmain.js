
module.exports = {
	openAppMainUrl : function (appMainUrl) {
		//Cordova.exec(null,null,"AppMain","openAppMainUrl",["6ce1aaa4-0226-4791-9c43-5e9e21e5f5a2"]);//success,fail,class,method,params
		Cordova.exec(null,null,"AppMain","openAppMainUrl",[appMainUrl]);//success,fail,class,method,params
		//alert("test");
	}
};
