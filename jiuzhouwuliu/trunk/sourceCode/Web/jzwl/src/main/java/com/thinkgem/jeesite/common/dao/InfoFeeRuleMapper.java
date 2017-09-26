package com.thinkgem.jeesite.common.dao;

import java.util.List;

import com.thinkgem.jeesite.common.entity.InfoFeeRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface InfoFeeRuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(InfoFeeRule record);

    int insertSelective(InfoFeeRule record);

    InfoFeeRule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoFeeRule record);

    int updateByPrimaryKey(InfoFeeRule record);
    //信息费设置列表  by 崔亚光
	List<InfoFeeRule> findList(InfoFeeRule entity);
	/**
	 * @description	通过货物类型（字典value）查询信息费
	 * @author 文帅
	 * @date 2017年9月11日 下午4:19:10
	 * @param dictValue
	 * @return
	 */
	InfoFeeRule findByDictValue(String dictValue);
	
	/**
	 * @description	：根据label值查询信息费
	 * @author pangchengxiang
	 * @date 2017年9月20日 上午9:47:33
	 * @return InfoFeeRule
	 */
	InfoFeeRule findByDictLabel(String dictLabel);
}