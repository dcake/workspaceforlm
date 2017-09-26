package com.thinkgem.jeesite.mobile.utils.alipay;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
	
	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088121451168609";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKNyRXJSt1aEXOivPOWuCtVZUJ5DM3YsKv1GB8gNd36aEe2a3Zi97Or+ds3HMhcPPI/nWKvnIT3IC27Zp/St3JCc9I1IJj2lDYkot5g09cMTk2QF9+HdLw1iwbv05SyrwB5p/cHpWmHJybLXo4AvkuI6SmPjTvu3P+z+LsP81Dw7AgMBAAECgYBPQgZzHbFR/vWez/tT1UXjl2AEnsnBsEFYeDElzYH4nnW7JrH2c4MDoUmzF7kufXD8x060bWwtLWh95IYRnI2rvE3jTRHeTm7N72p8kV2zfLJdrSOu+wFzW6dWs1mU93afhvJzoj0aCX9vj+1h+OqVSvQfUN+44R7Xt60RfstKwQJBAMy96doeZ5GHdTe2NZpIhZDd/wOSGd0Ww1fgQ0AjJ+SxyncFLjZ9ee7vVhhhpih7uHzAqYiEVoAIdQL776D1JLMCQQDMXbGuHBvNHFsqUvhe+/NZe3kvHC+zJXsjoysYUfMcm3+g+8c/YANJZKYGIxCXqfqOQfPML9bMPlM6eazbPJ5ZAkA7aqXR6d7uidwHlfZKVt+EIhiepaih07hO6UM6+rjaEoqKLdOydomLQKPAoZ4Bw53Pfm30s0sTDuE+Q3TQRjQnAkAP8N8DLb4dabDSxFYLUqvQtwjk29X8q1fHl9qssve7q4VxETKhhuO6vdcVc3a/3cplfk9+Bd1DYTksvoD1OO1BAkEApYnnHK9ulKGvsG8ouvnuFakK5y9vrFb4gT24Ic2/lwZoa7cNaat9IJ2wsaYQxWMI5gt5XS5MGrE0uuJlD1YjhA==";
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.ccejia.com/groupcar/aliPay/alipayNotify.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问http://61.53.69.133:62493/school/pay/alipayReturn.do
	//public static String return_url = "http://www.ccejia.com/school/pay/alipayReturn.do";
	//public static String return_url = "http://61.53.69.133:62493/school/pay/alipayReturn.do";
	public static String return_url = "http://1l6t408169.imwork.net:22145/reportName/alipayReturn";//购买班级时使用
	public static String pcReturn_url = "http://1l6t408169.imwork.net:22145/reportName/aliPayReturn1";//pc后端报名购买班级时使用
	public static String hoursReturn_url = "http://116.255.197.252:54321/myCenterHours/aliPayHoursReturn";//购买学时时使用
	public static String serviceReturn_url = "http://116.255.197.252:54321/PurchaseAccretion/alipayReturn";//购买服务时使用
	public static String toBePaidReturn_url = "http://116.255.197.252:54321/myCenterToBePaid/aliPayToBePaidReturn";//待缴费用时使用
	public static String pcToBePaidReturn_url = "http://116.255.197.252:54321/myCenterToBePaid/aliPayToBePaidReturn1";//待缴费用时使用
	
	public static String saleGroupReturn_url = "http://1l6t408169.imwork.net:22145/SaleProduct/updateAliPayOrder";//营销活动团购支付回调
	// 签名方式
	public static String sign_type = "RSA";
	// 商家帐号
	public static String seller_email = "ccejia@126.com";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "/logs/alipay/";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";
	
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
	//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
	//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	//操作中断跳转地址
	public static String merchant_url ="http://www.ccejia.com";
}

