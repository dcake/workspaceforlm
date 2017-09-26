package com.thinkgem.jeesite.modules.complaints.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.dao.UsersSuggestionMapper;
import com.thinkgem.jeesite.common.entity.UsersSuggestion;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

@Service
public class UsersSuggestionService {

	@Autowired
	private UsersSuggestionMapper usersSuggestionMapper;
	
	/**
	 * @desc 获取投诉建议列表
	 * @author yaotengfei
	 * @date 2017年8月17日上午10:14:59
	 * @param page
	 * @param usersSuggestion
	 * @return
	 * @throws ParseException
	 */
	public Page<UsersSuggestion> findUsersSuggestionListForPage(Page<UsersSuggestion> page, UsersSuggestion usersSuggestion) throws ParseException {
		usersSuggestion.setPage(page);
		List<UsersSuggestion> usersSuggestionList = usersSuggestionMapper.findUsersSuggestionListForPage(usersSuggestion);
		if(usersSuggestionList.size() > 0){
			//查询字典缓存获取用户类型
			for(int i = 0; i < usersSuggestionList.size(); i++){
				String result = DictUtils.getDictLabels(usersSuggestionList.get(i).getUserSort(),"users_user_sort","未知");
				usersSuggestionList.get(i).setUserSortStr(result);
			}
		}
		page.setCount(usersSuggestionList.size());
		page.setList(usersSuggestionList);
		return page;	
	}
}
