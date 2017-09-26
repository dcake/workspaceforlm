package com.thinkgem.jeesite.modules.finance.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.DriverReciveMoneyMapper;
import com.thinkgem.jeesite.common.dao.GoodsownerDealMapper;
import com.thinkgem.jeesite.common.entity.DriveOrder;
import com.thinkgem.jeesite.common.entity.DriverReciveMoney;
import com.thinkgem.jeesite.common.entity.GoodsownerDeal;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
/**
 * @description	垫资管理
 * @author 文帅
 * @date 2017年8月10日 下午4:28:18
 */
@Service
@Transactional
public class MatFundsService {
	@Autowired
	private DriverReciveMoneyMapper driverReciveMoneyMapper;
	@Autowired
	private GoodsownerDealMapper goodsownerDealMapper;
	/**
	 * @description	
	 * @author 文帅
	 * @date 2017年8月10日 下午5:13:55
	 * @param page
	 * @param driveOrder
	 * @return
	 */
	public Page<DriverReciveMoney> findMatFundsList(Page<DriverReciveMoney> page, DriverReciveMoney  driverReciveMoney) {
		driverReciveMoney.setPage(page);
		page.setList(driverReciveMoneyMapper.findMatFundsList(driverReciveMoney));
		return page;	
	}
	
	/**
	 * @description	根据垫资信息进行批量结算
	 * @author 文帅
	 * @date 2017年8月11日 下午3:22:45
	 * @param ids
	 * @return
	 */
	public AjaxBeanUtil plJieSuan(String ids){
		try {
			Principal principal = UserUtils.getPrincipal();
			List<GoodsownerDeal> list=new ArrayList<GoodsownerDeal>();
			String[] arr=ids.split(",");
			for(int i=0;i<arr.length;i++){
				GoodsownerDeal goodsownerDeal=goodsownerDealMapper.selectByPrimaryKey(arr[i]);
				if("1".equals(goodsownerDeal.getIsSettleAccounts())){
					return new AjaxBeanUtil("请去掉已结算的数据！", false);
				}
				goodsownerDeal.setUpdateDate(new Date());
				goodsownerDeal.setUpdateBy(principal.getName());
				list.add(goodsownerDeal);
			}
			goodsownerDealMapper.plUpdateById(list);
			return new AjaxBeanUtil("结算成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常",false);
		}
	}
	
	/**
	 * @description	查询垫资列表
	 * @author 文帅
	 * @date 2017年8月15日 上午10:00:22
	 * @param driverReciveMoney
	 * @return
	 */
	public List<DriverReciveMoney> findList(DriverReciveMoney driverReciveMoney){
		return driverReciveMoneyMapper.findMatFundsList(driverReciveMoney);
	} 
	/**
	 * @description	根据ID查询垫资信息
	 * @author 文帅
	 * @date 2017年8月15日 上午10:37:59
	 * @param id
	 * @return
	 */
	public DriverReciveMoney findById(String id){
		return driverReciveMoneyMapper.findById(id);
	}
	
	/**
	 * @description	详情结算
	 * @author 文帅
	 * @date 2017年8月16日 下午5:22:17
	 * @param driverReciveMoney
	 * @return
	 */
	public AjaxBeanUtil detailJieSuan(DriverReciveMoney driverReciveMoney){
		try {
			Principal principal = UserUtils.getPrincipal();
			GoodsownerDeal goodsownerDeal=goodsownerDealMapper.selectByPrimaryKey(driverReciveMoney.getGoodsownerDealId());
			if("1".equals(goodsownerDeal.getIsSettleAccounts())){
				return new AjaxBeanUtil("改数据已结算，不能重复结算！", false);
			}
			goodsownerDeal.setUpdateDate(new Date());
			goodsownerDeal.setUpdateBy(principal.getName());
			goodsownerDeal.setIsSettleAccounts("1");
			goodsownerDealMapper.updateByPrimaryKeySelective(goodsownerDeal);
			return new AjaxBeanUtil("结算成功！", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常！", false);
		}
	}
}
