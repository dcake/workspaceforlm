package com.thinkgem.jeesite.modules.users.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.dao.GoodsMapper;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * 高估值货物审核--Service
 *   
 * @author 张彦学
 * 日期 2017年8月8日
 */
@Service
public class HighValuationOfGoodsService {
	
	@Resource
	private GoodsMapper goodsMapper;

	/**
	 * 查询高估值货物审核列表
	 *   
	 * @author 张彦学
	 * 日期 2017年8月9日
	 * @param page
	 * @param goods
	 * @return
	 */
	public Page<Goods> findPage(Page<Goods> page, Goods goods){
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get("dictMap");
		if(dictMap != null){
			List<Dict> dictList = dictMap.get("high_goods");
			goods.setInsuranceMoney(Double.parseDouble(dictList.get(0).getValue()));
		}
		goods.setPage(page);
		List<Goods> list = goodsMapper.selectHighGoods(goods);
		for(Goods g : list){
			for(int i = 0; i < dictMap.get("goods_type").size(); i++){
				if(g.getGoodsType().equals(dictMap.get("goods_type").get(i).getValue())){
					g.setGoodsType(dictMap.get("goods_type").get(i).getLabel());
				}
			}
		}
		page.setList(list);
		return page;
	}
	
	/**
	 * 根据id查询货物详情
	 *   
	 * @author 张彦学
	 * 日期 2017年8月10日
	 * @param id
	 * @return
	 */
	public Goods findGoodsById(String id){
		return goodsMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 审核
	 *   
	 * @author 张彦学
	 * 日期 2017年8月10日
	 * @param goods
	 */
	public void highValuationOfGoodsCheck(Goods goods){
		goods.preUpdate();
		goods.setExamTime(new Date());
		goodsMapper.updateByPrimaryKeySelective(goods);
	}
}
