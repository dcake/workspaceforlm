package com.thinkgem.jeesite.mobile.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.UsersSuggestion;
import com.thinkgem.jeesite.mobile.common.service.MobileCommonSuggestService;
import com.thinkgem.jeesite.mobile.utils.AjaxBeanUtil;

/**
 * @desc 投诉建议接口
 * @author yaotengfei
 * @date 2017年8月10日上午10:33:55
 */
@Controller
@RequestMapping(value="/MobileCommonSuggest")
public class MobileCommonSuggestController {

	@Autowired
	private MobileCommonSuggestService mobileCommonSuggestService;
	
	/**
	 * @desc 投诉建议
	 * @author yaotengfei
	 * @date 2017年8月10日上午10:43:27
	 * @param userid--用户id
	 * @param suggestionContent--投诉建议内容
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/submitSuggest", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil submitSuggest(UsersSuggestion usersSuggestion,HttpServletRequest request,HttpServletResponse response) throws IOException{
		return mobileCommonSuggestService.submitSuggest(usersSuggestion,request,response);
	}
	
	/**
	 * @desc 获取投诉建议列表
	 * @author yaotengfei
	 * @date 2017年8月22日下午5:03:30
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getSuggestList", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getSuggestList(HttpServletRequest request){
		return mobileCommonSuggestService.getSuggestList(request);
	}
	
	/**
	 * @desc 根据id获取投诉建议详情
	 * @author yaotengfei
	 * @date 2017年8月22日下午5:51:27
	 * @param suggestId
	 * @return
	 */
	@RequestMapping(value="/getSuggestDetail", method= RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil getSuggestDetail(String suggestId){
		return mobileCommonSuggestService.getSuggestDetail(suggestId);
	}
}
