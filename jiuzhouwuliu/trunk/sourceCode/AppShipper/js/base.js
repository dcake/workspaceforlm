﻿/**
 * 刘思雨
 * Ajax配置
 * 2017年4月24日
 */

localStorage.setItem("interfaceString","192.168.7.34:8080/jzwl");
var ServerHost = localStorage.getItem("interfaceString");

//ServerHost ="http://" +  ServerHost + "/eschl/";
ServerHost = "http://" + ServerHost + "/";

var IsDebug = true;

/**
 * openWindow方法
 * @param {Object} targetUrl目标页面url
 * @param {Object} parentID本页面Url
 * @param {Object} extras扩展参数
 */
function AppOpenWindow(targetUrl, parentID, extras) //uuid.innerHTML 
{
	//console.log("parentID="+parentID);
	console.log("targetUrl======" + targetUrl);
	var targetUrl = targetUrl;
	var extras = extras || {};

	extras.parentID = parentID || "";
	mui.openWindow({
		url: targetUrl,
		id: targetUrl,
		createNew: true,
		extras: extras
	});
}
/**
 * 关闭父页面
 * @param {Object} _currentWebView页面对象
 */
function AppCloseParentWindow(_currentWebView) {
	//	if(plus.os.name=="iOS"){
	//		
	//	}
	setTimeout(function() {
		plus.webview.close(plus.webview.getWebviewById(_currentWebView.parentID));
	}, 1000);
}
/**
 * 自定义PlusReady
 * @param {Object} CallBackFun
 */
function AppPlusReady(CallBackFun) {
	mui.plusReady(function() {
		plus.nativeUI.showWaiting();
		//		//自己添加的代码
		//		if(IsCloseParent){
		//			AppCloseParentWindow(plus.webview.currentWebview());
		//		}
		mui("ul").on("tap", "li > a", function() {
			var url = this.getAttribute('id');
			if(url == "takePhone") {
				return;
			} else if(url == "login.html") {
				var btnArray = ['否', '是'];
				mui.confirm('确认退出登录？', appAlertTitle, btnArray, function(e) {
					if(e.index == 1) {
						UserLoginOut();
					}
				});

			} else {
				AppOpenWindow(url, plus.webview.currentWebview().id);
			}
		});

		plus.nativeUI.closeWaiting();
		CallBackFun(plus.webview.currentWebview().parentID);

	});
}

/**
 * 发送ajax请求
 * 
 * @param {Object} 请求地址 url
 * @param {Object} 请求数据 json格式 data
 * @param {Object} type 请求类型
 * @param {Object} success 成功回调函数
 */
function AjaxSend(url, data, type, success, loginfun, closeWeb) {
	if(!ServerHost) {
		ServerHost = localStorage.getItem("interfaceString");
		ServerHost = "http://" + ServerHost + "/";
	}
	var complete_url = ServerHost + url;
	console.log(complete_url);
	console.log(url + " Request" + JSON.stringify(data));
	//plus.nativeUI.showWaiting();
	mui.ajax(complete_url, {
		data: data,
		dataType: 'json', //服务器返回json格式数据
		type: type, //HTTP请求类型
		timeout: 1000 * 60, //超时时间设置为10秒；
		success: function(result) {
			//plus.nativeUI.closeWaiting();
			if(result.status == ajaxStatus.INFOR) {
				mui.toast(result.msg); //保存失败
			} else if(result.status == ajaxStatus.LOGIN) {
				//loginfun(result);
			} else if(result.status == ajaxStatus.BACK) {
				//closeWeb(result);
			} else {
				success(result);
			}
		},
		error: function(err) {
			//plus.nativeUI.closeWaiting();
			console.log("err:" + JSON.stringify(err));
			console.log(err.status + complete_url); //complete_url

			if(err.status == 401) {
				mui.toast("登录超时，请重新登录！");
			}
			if(IsDebug) {
				mui.toast("请求错误:" + url); //保存失败
			} else {
				mui.toast("网络异常请稍后再试"); //保存失败
			}
			//				mui.alert("请求超时，请检查网络是否正常！");
		}
	});
}

function login() {

	var url = "../login/login.html";
	AppOpenWindow(url, plus.webview.currentWebview().id);
}
/**
 * 输出打印
 * 刘思雨
 * 2017年4月24日
 * @param {Object} msg
 */
function printlog(msg) {
	if(IsDebug) {
		console.log(msg);
	}
}
/**
 * 请求返回状态码
 */
var ajaxStatus = {
	//请求成功
	SUCCESS: "true",
	//输入数据有误
	INFOR: "INFOR",
	LOGIN: "LOGIN",
	//确认
	CONFIRM: "CONFIRM",
	BACK: "BACK"
}
/**
 * 存储用户信息
 * @param {Object} user
 */
function createUser(user) {
	localStorage.setItem('$user', JSON.stringify(user));
}
/**
 * 获取用户信息
 */
function getUser() {
	var user = localStorage.getItem('$user') || "{}";

	return JSON.parse(user);
}
/**
 * 存储用户GPS信息
 * @param {Object} user
 */
function createUserGPS(userGPS) {
	localStorage.setItem('$userGPS', JSON.stringify(userGPS));
}
/**
 * 获取用户GPS信息
 */
function getUserGPS() {
	var userGPS = localStorage.getItem('$userGPS') || "{}";

	return JSON.parse(userGPS);
}
/**
 * 删除用户信息
 */
function removeUser() {
	localStorage.clear();
}
/**
 * 判断是否为空对象{}
 * @param {Object} obj
 */
function isEmptyObject(obj) {
	if(obj == null) {
		return true;
	}
	for(var x in obj) {
		return false;
	}
	return true;
}

/**
 * 判断对象是空或者是Null
 * @param {Object} obj
 */
function isNullOrEmpty(Str) {
	if(Str == null || Str == "" && Str != 0) {
		return true;
	}
}
/**
 * 格式化日期时间(沈亚辉2016-10-08)
 * @param {Object} datatime
 */
function DataTimeFormat(datatime) {
	return new Date(datatime).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
}
/**
 * 刘思雨
 * 2017-1-12
 * 获取当前时分
 */
function timeNow() {
	var now = new Date();
	var hh = now.getHours(); //时
	var mm = now.getMinutes(); //分
	var ss = now.getSeconds(); //秒

	var clock = "";
	if(hh < 10)
		clock += "0";
	clock += hh + ":";
	if(mm < 10)
		clock += "0";
	clock += mm;

	return(clock);
}

/**
 * 刘思雨
 * 2017-1-22
 * 时间格式化(年月日时分秒)
 */
function dateTimeFormat(time) {
	var clock = "";
	var d = new Date(time);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();

	if(month < 10) {
		month = "0" + month;
	}
	if(day < 10) {
		day = "0" + day;
	}
	if(hour < 10) {
		hour = "0" + hour
	}
	if(min < 10) {
		min = "0" + min;
	}
	if(sec < 10) {
		sec = "0" + sec;
	}
	clock = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
	return(clock);
}

function timeForma(time) {
	var clock = "";
	var d = new Date(time);
	//		var year = d.getFullYear();
	//		var month = d.getMonth() + 1;
	//		var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();

	//		if (month < 10) {
	//			month = "0"+month;
	//		}
	//		if (day < 10) {
	//			day = "0"+day;
	//		}
	if(hour < 10) {
		hour = "0" + hour
	}
	if(min < 10) {
		min = "0" + min;
	}
	if(sec < 10) {
		sec = "0" + sec;
	}
	clock = hour + ":" + min + ":" + sec;
	return(clock);
}
/**
 * 刘思雨
 * 2017-1-22
 * 时间格式化(年月日)
 */
function YMDFormat(time) {
	var clock = "";
	var d = new Date(time);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();

	if(month < 10) {
		month = "0" + month;
	}
	if(day < 10) {
		day = "0" + day;
	}
	clock = year + "-" + month + "-" + day;
	return(clock);
}

function YMDFormat2(time) {
	var clock = "";
	var d = new Date(time);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();

	if(month < 10) {
		month = "0" + month;
	}
	if(day < 10) {
		day = "0" + day;
	}
	clock = month + "-" + day;
	return(clock);
}

/**
 * 罗龙泉
 * 2017-6-8
 * 时间格式化(年月日时分) 2017年6月6日 17:00-18:00
 */
function datetimeFormat(time) {
	var clock = "";
	var d = new Date(time);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();
	var hour1 = hour + 1;

	if(hour < 10) {
		hour = "0" + hour
	}
	if(hour1 < 10) {
		hour1 = "0" + hour1
	}
	if(min < 10) {
		min = "0" + min;
	}
	clock = year + "年" + month + "月" + day + "日 ";
	return(clock);
}
/**
 * 刘思雨
 * 2016-1-6
 * 验证手机号
 */
function checkPhone(tel) {
	var reg = /^1[34578]\d{9}$/;
	if(reg.test(tel) && tel !== "") {
		return true;
	} else {
		return false;
	};
}

/**
 * 李留新
 * 2017-8-22
 * 验证固定电话
 */
function checkTel(tel) {
	var integer2 = /^(0[0-9]{2,3}\-)([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
	if(integer2.test(tel) && tel != "") {
		return true;
	} else {
		return false;
	}
}

/**
 * 刘思雨
 * 2017-2-9
 * 验证邮箱
 * @param {Object} mail
 */
function checkMail(mail) {
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(mail !== "" && !filter.test(mail)) {
		return false;
	} else {
		return true;
	}
}

/**
 * 孙孟龙
 * 2017-4-28
 * 验证身份证
 * @param {Object} mail
 */
function isCardNo(card) {
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if(card !== "" && !reg.test(card)) {
		return false;
	} else {
		return true;
	}
}

/**   
 * json格式转树状结构   
 * @param   {json}      json数据   
 * @param   {String}    id的字符串   
 * @param   {String}    父id的字符串   
 * @param   {String}    children的字符串   
 * @return  {Array}     数组   
 */
function transData(a, idStr, pidStr, chindrenStr) {
	var r = [],
		hash = {},
		id = idStr,
		pid = pidStr,
		children = chindrenStr,
		i = 0,
		j = 0,
		len = a.length;
	for(; i < len; i++) {
		hash[a[i][id]] = a[i];
	}
	for(; j < len; j++) {
		var aVal = a[j],
			hashVP = hash[aVal[pid]];
		if(hashVP) {
			!hashVP[children] && (hashVP[children] = []);
			hashVP[children].push(aVal);
		} else {
			r.push(aVal);
		}
	}
	return r;
}

/**
 * 刘思雨
 * 2017-2-8
 * 汉字超出补省略
 */
function interceptName(str) {
	var name = "";
	if(str.length > 4) {
		name = str.substr(0, 4) + "...";
	} else {
		name = str;
	}
	return name;
}

function intercept(str) {
	var name = "";
	if(str == "") {
		name = "未知用户";
	} else {
		name = str.substr(4, 8);
		var str1 = name.replace('****');
		return name;
	}
}
/**
 * 验证数字或字母
 * 刘思雨
 * 2017年5月12日
 */
function validateNum(num) {
	var reg = /^[0-9a-zA-Z\.]+$/;
	if(reg.test(num)) {
		return true;
	} else {
		return false;
	}

}
/**
 * 将手机号显示成中间带*的格式
 * @param {Object} phonenum
 */
function showphonenum(phonenum) {
	//console.log(phonenum.length);
	if(phonenum.length == 11) {
		var first = phonenum.substr(0, 3);
		var secand = phonenum.substr(7, 4);
		return first + "****" + secand;
	} else {
		return phonenum;
	}
}

/**
 * 刘思雨
 * 2017-3-9
 * 获取字符串长度
 * @param {Object} str
 */
function getLength(str) {
	var len = 0;
	for(var i = 0; i < str.length; i++) {
		var length = str.charCodeAt(i);
		if(length >= 0 && length <= 128) {
			len += 1;
		} else {
			len += 2;
		}
	}
	return len;

}
// 格式化日期时间字符串，格式为"YYYY-MM-DD HH:MM:SS"
function dateToStr(d) {
	return(d.getFullYear() + "-" + ultZeroize(d.getMonth() + 1) + "-" + ultZeroize(d.getDate()) + " " + ultZeroize(d.getHours()) + ":" + ultZeroize(d.getMinutes()) + ":" + ultZeroize(d.getSeconds()));
};
/**
 * zeroize value with length(default is 2).
 * @param {Object} v
 * @param {Number} l
 * @return {String} 
 */
function ultZeroize(v, l) {
	var z = "";
	l = l || 2;
	v = String(v);
	for(var i = 0; i < l - v.length; i++) {
		z += "0";
	}
	return z + v;
};

/**
 * 检查网络
 * 沈亚辉
 * 2017年3月25日
 * CONNECTION_UNKNOW: 网络连接状态未知
 * CONNECTION_NONE: 未连接网络
 * CONNECTION_ETHERNET: 有线网络
 * CONNECTION_WIFI: 无线WIFI网络
 * CONNECTION_CELL2G: 蜂窝移动2G网络
 * CONNECTION_CELL3G: 蜂窝移动3G网络
 * CONNECTION_CELL4G: 蜂窝移动4G网络
 */
function CheckNetWork() {
	if(plus.networkinfo.getCurrentType() == plus.networkinfo.CONNECTION_NONE) {
		return "连接网络失败，请稍后再试"; //未连接网络
	}
	return "";
}

/**
 * 刘思雨
 * 2017-5-4
 * 验证银行卡号合法性
 */
//Luhm校验规则：16位银行卡号（19位通用）:

// 1.将未带校验位的 15（或18）位卡号从右依次编号 1 到 15（18），位于奇数位号上的数字乘以 2。
// 2.将奇位乘积的个十位全部相加，再加上所有偶数位上的数字。
// 3.将加法和加上校验位能被 10 整除。

//方法步骤很清晰，易理解，需要在页面引用Jquery.js    

//bankno为银行卡号 banknoInfo为显示提示信息的DIV或其他控件
function luhmCheck(bankno) {
	var lastNum = bankno.substr(bankno.length - 1, 1); //取出最后一位（与luhm进行比较）

	var first15Num = bankno.substr(0, bankno.length - 1); //前15或18位
	var newArr = new Array();
	for(var i = first15Num.length - 1; i > -1; i--) { //前15或18位倒序存进数组
		newArr.push(first15Num.substr(i, 1));
	}
	var arrJiShu = new Array(); //奇数位*2的积 <9
	var arrJiShu2 = new Array(); //奇数位*2的积 >9

	var arrOuShu = new Array(); //偶数位数组
	for(var j = 0; j < newArr.length; j++) {
		if((j + 1) % 2 == 1) { //奇数位
			if(parseInt(newArr[j]) * 2 < 9)
				arrJiShu.push(parseInt(newArr[j]) * 2);
			else
				arrJiShu2.push(parseInt(newArr[j]) * 2);
		} else //偶数位
			arrOuShu.push(newArr[j]);
	}

	var jishu_child1 = new Array(); //奇数位*2 >9 的分割之后的数组个位数
	var jishu_child2 = new Array(); //奇数位*2 >9 的分割之后的数组十位数
	for(var h = 0; h < arrJiShu2.length; h++) {
		jishu_child1.push(parseInt(arrJiShu2[h]) % 10);
		jishu_child2.push(parseInt(arrJiShu2[h]) / 10);
	}

	var sumJiShu = 0; //奇数位*2 < 9 的数组之和
	var sumOuShu = 0; //偶数位数组之和
	var sumJiShuChild1 = 0; //奇数位*2 >9 的分割之后的数组个位数之和
	var sumJiShuChild2 = 0; //奇数位*2 >9 的分割之后的数组十位数之和
	var sumTotal = 0;
	for(var m = 0; m < arrJiShu.length; m++) {
		sumJiShu = sumJiShu + parseInt(arrJiShu[m]);
	}

	for(var n = 0; n < arrOuShu.length; n++) {
		sumOuShu = sumOuShu + parseInt(arrOuShu[n]);
	}

	for(var p = 0; p < jishu_child1.length; p++) {
		sumJiShuChild1 = sumJiShuChild1 + parseInt(jishu_child1[p]);
		sumJiShuChild2 = sumJiShuChild2 + parseInt(jishu_child2[p]);
	}
	//计算总和
	sumTotal = parseInt(sumJiShu) + parseInt(sumOuShu) + parseInt(sumJiShuChild1) + parseInt(sumJiShuChild2);

	//计算Luhm值
	var k = parseInt(sumTotal) % 10 == 0 ? 10 : parseInt(sumTotal) % 10;
	var luhm = 10 - k;

	if(lastNum == luhm) {
		//mui.toast("Luhm验证通过");
		return true;
	} else {
		mui.toast("银行卡号不合法");
		return false;
	}
}
/**
 * 刘思雨
 * 2017-5-4
 * 中文验证
 * @param {Object} str
 */
function isChineseChar(str) {
	var reg = /^[\u4e00-\u9fa5]{2,4}$/;;
	return reg.test(str);
}

/**
 * 刘思雨
 * 2017-5-24
 * 验证是否含有中文
 * @param {Object} s
 */
function isChina(s) {
	var patrn = /[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi;
	if(!patrn.exec(s)) {
		return false;
	} else {
		return true;
	}
}

/**
 * 刘思雨
 * 2017-6-8
 * 替换html标签中的img路径
 * @param {Object} elementId 标签id
 */
function replaceImg(elementId) {
	var len = document.getElementById(elementId).getElementsByTagName("img").length;
	var imgObj = null;
	var imgHead = null;
	if(len > 0) {
		imgObj = document.getElementById(elementId).getElementsByTagName("img");
		for(var i = 0; i < len; i++) {
			imgObj[i].style.width = "100%";
			imgObj[i].style.height = "35%";
			imgHead = imgObj[i].src.split(":")[0];
			if(imgHead == "file") {
				//对相对路径的图片添加域名
				var str = imgObj[i].src.split("/")[3];
				var str1 = imgObj[i].src.replace(str, "$").split("$")[1];
				str2 = ServerHost + "/" + str + "/" + str1;
				imgObj[i].src = str2;
			} else {
				//网络图片路径直接显示
			}
		}
	}

}

/**
 * 罗龙泉
 * 2017-6-29
 * 时间格式化(年月日时分秒)2017-06-29 星期一
 */
function timeFormat(time) {
	var clock = "";
	var d = new Date(time);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var hour = d.getHours();
	var min = d.getMinutes();
	var sec = d.getSeconds();
	var hour1 = hour + 1
	if(month < 10) {
		month = "0" + month;
	}
	if(day < 10) {
		day = "0" + day;
	}
	if(hour < 10) {
		hour = "0" + hour
	}
	if(hour1 < 10) {
		hour1 = "0" + hour1
	}
	if(min < 10) {
		min = "0" + min;
	}
	if(sec < 10) {
		sec = "0" + sec;
	}
	var clock1 = year + "-" + month + "-" + day;
	var week = getMyDay(new Date(clock1));
	clock = year + "-" + month + "-" + day + "" + '&nbsp;&nbsp;&nbsp;&nbsp;' + week;
	return(clock);
}

/**
 * 罗龙泉
 * 2017-6-29
 * 日期判断星期几
 */
function getMyDay(date) {
	var week;
	if(date.getDay() == 0) week = "星期天"
	if(date.getDay() == 1) week = "星期一"
	if(date.getDay() == 2) week = "星期二"
	if(date.getDay() == 3) week = "星期三"
	if(date.getDay() == 4) week = "星期四"
	if(date.getDay() == 5) week = "星期五"
	if(date.getDay() == 6) week = "星期六"
	return week;
}
/**
 * 罗龙泉
 * 2017-7-20
 * 防止js注入
 */
function htmlEncode(value) {

	return $('<div/>').text(value).html();

}
/** 
 * 罗龙泉
 * 2017-06-29
 * 将表情符号转换
 * 用于把用utf16编码的字符转换成实体字符，以供后台存储 
 * @param  {string} str 将要转换的字符串，其中含有utf16字符将被自动检出 
 * @return {string}     转换后的字符串，utf16字符将被转换成&#xxxx;形式的实体字符 
 * 
 */
function utf16toEntities(str) {
	var patt = /[\ud800-\udbff][\udc00-\udfff]/g; // 检测utf16字符正则  
	str = str.replace(patt, function(char) {
		var H, L, code;
		if(char.length === 2) {
			H = char.charCodeAt(0); // 取出高位  
			L = char.charCodeAt(1); // 取出低位  
			code = (H - 0xD800) * 0x400 + 0x10000 + L - 0xDC00; // 转换算法  
			return "&#" + code + ";";
		} else {
			return char;
		}
	});
	return str;
}

/**
 * 转义html 防止js注入
 * @param {Object} str
 */
function htmlEncode(str){  
	var ele = document.createElement('span');  
	ele.appendChild( document.createTextNode(str)); 
	return ele.innerHTML;  
} 