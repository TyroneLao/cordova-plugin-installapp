
module.exports = {
	openAppPage : function (value,page) {
		//Cordova.exec(null,null,"AppPage","openAppPage",["6ce1aaa4-0226-4791-9c43-5e9e21e5f5a2","app_page"]);//success,fail,class,method,params
		//Cordova.exec(null,null,"AppPage","openAppPage",["6ce1aaa4-0226-4791-9c43-5e9e21e5f5a2","review_page"]);//success,fail,class,method,params
		Cordova.exec(null,null,"AppPage","openAppPage",[value,page]);//success,fail,class,method,params
		//alert("test");
	}
};
