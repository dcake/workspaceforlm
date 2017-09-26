package com.thinkgem.jeesite.mobile.shipper.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.GoodsownerDeal;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.mobile.shipper.service.MobileBidService;
import com.thinkgem.jeesite.mobile.utils.alipay.AlipayNotify;
import com.thinkgem.jeesite.mobile.utils.wxpay.XmlUtils;
/**
 * @description	货主端-竞价
 * @author 文帅
 * @date 2017年8月24日 上午11:40:50
 */
@Controller
@RequestMapping(value="/mobileBid")
public class MobileBidController {
	@Autowired
	private MobileBidService mobileBidService;
	
	/**
	 * @description	测试页面
	 * @author 文帅
	 * @date 2017年8月21日 下午4:47:31
	 * @return
	 */
	@RequestMapping(value="goShipperTest")
	public String goShipperTest(){
		return "mobile/test/shipperTest";
	}
	
	/**
	 * @description	根据用户ID查询竞价列表
	 * @author 文帅
	 * @date 2017年8月24日 下午3:11:54
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findBidList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findBidList(String currentPage,String userId){
		return mobileBidService.findBidList(currentPage,userId);
	}
	
	/**
	 * @description	查看竞价或查看经纪人
	 * @author 文帅
	 * @date 2017年8月25日 上午10:00:13
	 * @param goodsownerOrderId 货主订单ID
	 * @param type 用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	 * @return
	 */
	@RequestMapping(value="lookBidOrAgent",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lookBidOrAgent(String goodsownerOrderId,String type,String userId){
		return mobileBidService.lookBidOrAgent(goodsownerOrderId,type,userId);
	}
	/**
	 * @description	根据货主订单ID查询货物信息
	 * @author 文帅
	 * @date 2017年8月25日 下午5:31:16
	 * @param goodsownerOrderId
	 * @return
	 */
	@RequestMapping(value="lookGoodsDetail",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lookGoodsDetail(String goodsownerOrderId){
		return mobileBidService.lookGoodsDetail(goodsownerOrderId);
	}
	/**
	 * @description	通过车主ID查询车主评价列表
	 * @author 文帅
	 * @date 2017年8月25日 下午6:03:37
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="findDriverEvaluationList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findDriverEvaluationList(String currentPage,String driversId){
		return mobileBidService.findDriverEvaluationList(currentPage,driversId); 
	}
	
	/**
	 * @description	根据车主ID查询车主历史路线
	 * @author 文帅
	 * @date 2017年8月26日 上午10:38:03
	 * @param currentPage
	 * @param driversId
	 * @return
	 */
	@RequestMapping(value="findDriveLineList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil findDriveLineList(String currentPage,String driversId){
		return mobileBidService.findDriveLineList(currentPage,driversId); 
	}
	
	/**
	 * @description	确认交易
	 * @author 文帅
	 * @date 2017年8月30日 上午10:48:24
	 * @param goodsownerDeal
	 * @param type 用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	 * @return
	 */
	@RequestMapping(value="confrimTransaction",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil confrimTransaction(GoodsownerDeal goodsownerDeal,HttpServletRequest request){
		return mobileBidService.confrimTransaction(goodsownerDeal,request);
	}
	
	
	/**
	 * 支付成功给微信的反馈
	 * 
	 * @param orderId订单ID
	 * @param transaction_id交易单号
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/weixinPayReturn")
	public void weixinPayReturn(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String notityXml = "";
		String inputLine;
		while ((inputLine = request.getReader().readLine()) != null) {
			notityXml += inputLine;
		}
		request.getReader().close();
		Map map = XmlUtils.xmlToMap(notityXml);
		String transaction_id1 = (String) map.get("transaction_id");// 微信订单号
		String return_code = (String) map.get("return_code");// 返回状态码
		String result_code = (String) map.get("result_code");// 业务结果
		String out_trade_no = (String) map.get("out_trade_no");// 商户订单号
		System.out.println(transaction_id1);
		System.out.println(return_code);
		System.out.println(result_code);
		System.out.println(out_trade_no);
		String resXml = "";
		request.setAttribute("result_code", result_code);
		ServletContext application = request.getSession().getServletContext();
		application.removeAttribute(out_trade_no);
		if ("SUCCESS".equals(result_code)) {
			// 支付成功
			resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
					+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml>";
		} else {
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
					+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml>";
		}
		System.out.println("微信支付回调数据结束");
		System.out.println(resXml);
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();
	}
	
	/**
	 * app支付宝异步通知信息
	 * @throws IOException 
	 */
	@RequestMapping(value="/aliPayReturn")
	@ResponseBody
	public static Map<String, Object> myCenterAlipayReturn(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		//返回map
		Map<String, Object> newMap = new HashMap<String, Object>();
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
		//商品描述
//		if(!"".equals(request.getParameter("body"))){
//			String body = new String(request.getParameter("body"));
//		}
		// 订单名称，必填
		String productName = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
		// 订单价格，必填
		String price=new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
		// 计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		/*System.out.println("支付宝订单交易信息返回！！！！！！！！！！！");
		System.out.println("是否为支付宝发出的信息"+verify_result);
		System.out.println("交易状态:"+trade_status);
		System.out.println("支付宝交易号:"+trade_no);
		System.out.println("商户订单号:"+out_trade_no);
		System.out.println("商户订单号:"+body);
		System.out.println("交易金额:"+price);*/
		if (verify_result) {// 验证成功
			if (trade_status.equals("TRADE_FINISHED")|| trade_status.equals("TRADE_SUCCESS")) {
				//回调成功之后在这里写业务逻辑{。。。。}
			}
		} else {
			newMap.put("status", false);
			return newMap;
		}
		newMap.put("status", false);
		return newMap;
	}
	
	/**
	 * @description	取消委托
	 * @author 文帅
	 * @date 2017年9月1日 上午9:46:22
	 * @param goodsownerOrderId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="cancleWeiTuo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil cancleWeiTuo(String goodsownerOrderId,String userId){
		return mobileBidService.cancleWeiTuo(goodsownerOrderId,userId); 
	}
	/**
	 * @description	取消竞价
	 * @author 文帅
	 * @date 2017年9月1日 上午10:12:31
	 * @param goodsownerOrderId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="cancleJingJia",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil cancleJingJia(String goodsownerOrderId,String userId){
		return mobileBidService.cancleJingJia(goodsownerOrderId,userId);
	}
	/**
	 * @description	选择或取消竞价人
	 * @author 文帅
	 * @date 2017年9月1日 上午11:18:03
	 * @param goodsownerOrderId 货主订单ID
	 * @param jingJiaRenId 竞价人ID
	 * @param Type 用于判断是确认还是取消（1-确认，0-取消）
	 * @return
	 */
	@RequestMapping(value="chooseOrCancleJingJiaRen",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil chooseOrCancleJingJiaRen(String goodsownerOrderId,String jingJiaRenId,String type){
		return mobileBidService.chooseOrCancleJingJiaRen(goodsownerOrderId,jingJiaRenId,type);
	}
}
