package com.thinkgem.jeesite.modules.users.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.config.OrderStatus;
import com.thinkgem.jeesite.common.dao.GoodsMapper;
import com.thinkgem.jeesite.common.dao.GoodsownerOrderMapper;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsownerOrder;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @desc 发布竞价审核--Service
 * @author 张彦学
 * @date 2017年8月11日上午10:08:48
 */
@Service
public class BidAuditService {
	
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private GoodsownerOrderMapper goodsownerOrderMapper;
	
	/**
	 * 查询发布竞价审核列表
	 *   
	 * @author 张彦学
	 * 日期 2017年8月14日
	 * @param page
	 * @param goods
	 * @return
	 */
	public Page<Goods> findPage(Page<Goods> page, Goods goods){
		goods.setPage(page);
		goods.setNotCheckPoint(DictUtils.getDictList("not_check_point").get(0).getValue());
		List<Goods> list = goodsMapper.selectBidAudit(goods);
		for(Goods goods2 : list){
			goods2.setGoodsType(DictUtils.getDictLabel(goods2.getGoodsType(), "goods_type", goods2.getGoodsType()));
			goods2.setNeedTruckType(DictUtils.getDictLabel(goods2.getNeedTruckType(), "truck_type", goods2.getNeedTruckType()));
		}
		page.setList(list);
		return page;
	}

	/**
	 * 发布竞价审核
	 *   
	 * @author 张彦学
	 * 日期 2017年8月14日
	 * @param goods
	 */
	public void bidAuditCheck(Goods goods){
		GoodsownerOrder go = goodsownerOrderMapper.findOrderByGoodId(goods.getId());
		if(null!=go){
			if("1".equals(goods.getIsCheckPass())){
				go.setGoodCurrStatus(OrderStatus.BIDING_IN_COMPETITION);
			}else{
				go.setGoodCurrStatus(OrderStatus.HAS_REJECT);
			}
			go.preUpdate();
			goodsownerOrderMapper.updateByPrimaryKeySelective(go);
		}
		goods.preUpdate();
		goods.setCheckTime(new Date());
		goodsMapper.updateByPrimaryKeySelective(goods);
	}
}
