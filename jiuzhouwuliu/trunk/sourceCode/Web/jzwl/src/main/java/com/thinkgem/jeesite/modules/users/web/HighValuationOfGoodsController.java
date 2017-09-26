package com.thinkgem.jeesite.modules.users.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.users.service.HighValuationOfGoodsService;

/**
 * 高估值货物审核--Controller
 *   
 * @author 张彦学
 * 日期 2017年8月8日
 */
@Controller
@RequestMapping(value = "${adminPath}/users/highValuationOfGoods")
public class HighValuationOfGoodsController {
	
	@Resource
	private HighValuationOfGoodsService highValuationOfGoodsService;
	
	/**
	 * 高估值货物审核列表
	 *   
	 * @author 张彦学
	 * 日期 2017年8月9日
	 * @return
	 */
	@RequestMapping(value = "/highValuationOfGoodsList")
	public String highValuationOfGoodsList(Goods goods, Model model, HttpServletRequest request, HttpServletResponse response){
		Page<Goods> page = highValuationOfGoodsService.findPage(new Page<Goods>(request, response), goods);
		model.addAttribute("page", page);
		return "modules/users/highValuationOfGoodsList";
		
	}
	
	/**
	 * 高估值货物
	 *   
	 * @author 张彦学
	 * 日期 2017年8月9日
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/highValuationOfGoodsDetail")
	public String highValuationOfGoodsDetail(Goods goods, Model model,String checkOut){
		goods = highValuationOfGoodsService.findGoodsById(goods.getId());
		goods.setGoodsType(DictUtils.getDictLabel(goods.getGoodsType(), "goods_type", ""));
		goods.setNeedTruckType(DictUtils.getDictLabel(goods.getNeedTruckType(), "truck_type", ""));
		model.addAttribute("goods", goods);
		model.addAttribute("checkOut", checkOut);
		return "modules/users/highValuationOfGoodsDetail";
	}
	
	/**
	 * 高估值货物审核操作
	 *   
	 * @author 张彦学
	 * 日期 2017年8月10日
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/highValuationOfGoodsCheck")
	@ResponseBody
	public AjaxBeanUtil highValuationOfGoodsCheck(Goods goods){
		highValuationOfGoodsService.highValuationOfGoodsCheck(goods);
		if(goods.getIsExamPass().equals("1")){
			return new AjaxBeanUtil("审核通过成功", true);
		}
		return new AjaxBeanUtil("驳回成功", true);
	}

}
