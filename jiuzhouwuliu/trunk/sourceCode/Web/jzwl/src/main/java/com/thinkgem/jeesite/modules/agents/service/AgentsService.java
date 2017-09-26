package com.thinkgem.jeesite.modules.agents.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.AgentOrderMapper;
import com.thinkgem.jeesite.common.dao.AgentsMapper;
import com.thinkgem.jeesite.common.dao.DriveFleetMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.Agents;
import com.thinkgem.jeesite.common.entity.DriveFleet;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.FileOperatEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.SpringMvcUploadUtil;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

/**
 * 
 * 经纪人管理
 */
@Service("agentsService")
@Transactional
public class AgentsService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private DriveFleetMapper driveFleetMapper;
	@Autowired
	private AgentsMapper agentsMapper;
	@Autowired
	private AgentOrderMapper agentOrderMapper;

	public Page<Agents> findPage(Page<Agents> page, Agents agents) {
		agents.setPage(page);
		page.setList(agentsMapper.findList(agents));
		return page;
	}

	public Agents findById(String id) {
		return agentsMapper.selectByPrimaryKeyId(id);
	}

	public List<DriveFleet> findDriveFleetList(DriveFleet driveFleet) {
		return driveFleetMapper.findDriveFleetList(driveFleet);
	}

	public DriveFleet getDriveFleet(DriveFleet driveFleet) {
		return driveFleetMapper.selectByPrimaryKey(driveFleet.getId());
	}

	/**
	 * 王涛 保存
	 */
	public AjaxBeanUtil saveAgents(Users u, HttpServletRequest request) {
		if (StringUtils.isEmpty(u.getId()) || "undefined".equals(u.getId())) {
			// 上传附件，返回上传结果
			List<FileOperatEntity> fileList = null;
			try {
				fileList = SpringMvcUploadUtil.upload(request);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			// 保存用户信息
			u.setId(IdGen.uuid());
			u.setPassword(SystemService.entryptPassword(u.getPassword()));
			// u.setStatus("0");//0正常 1锁定
			u.setUserSort("2");// 0货主 1车主 2经纪人
			u.setSpell(getPinYinHeadChar(u.getTruename()));// 拼音简写
			u.setExamineStatus("0");// 审核状态默认 0 已审核 1已审核 2审核未通过
			// 将上传结果赋值到对象
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, u);
			}
			u.preInsert();
			usersMapper.insertSelective(u);
			// 保存经纪人信息
			String companyName = request.getParameter("companyName");
			Agents agents = new Agents();
			agents.setId(IdGen.uuid());
			agents.setUserid(u.getId());
			agents.setCompanyName(companyName);
			agents.setIsTruecommpany("0");// 是否企业认证（0否 1是）
			if(StringUtils.isEmpty(companyName)){
				agents.setIdentityType("0");// 个人身份选择（0个人、1公司 ）
			}else{
				agents.setIdentityType("1");// 个人身份选择（0个人、1公司 ）
			}
			// 将上传结果赋值到对象
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, agents);
			}
			agents.preInsert();
			System.out.println(agents.getCreateDate().toLocaleString());
			agentsMapper.insertSelective(agents);
			return new AjaxBeanUtil("保存成功", true, u);
		}
		return new AjaxBeanUtil("保存失败", false, u);
	}

	/**
	 * @desc 根据字符串获取首字母
	 * @author wangtao
	 * @return
	 */
	public String getPinYinHeadChar(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	public void updateInfo(Users users) {
		if (users != null) {
			usersMapper.updateByPrimaryKeySelective(users);
		}
	}

	public void updateInfo1(Agents agents) {
		if (agents != null) {
			agentsMapper.updateByPrimaryKeySelective(agents);
		}
	}

	public Agents findByUserId(String userId) {
		return agentsMapper.findByUserId(userId);
	}

	/**
	 * 锁定
	 * 
	 * @return
	 */
	public AjaxBeanUtil lock(String id) {
		Users u = usersMapper.selectByPrimaryKey(id);
		try {
			if (u != null) {
				u.setStatus("1");// 1锁定 0正常
				u.preUpdate();
				usersMapper.updateByPrimaryKeySelective(u);
				return new AjaxBeanUtil("锁定成功", true);
			}
			return new AjaxBeanUtil("锁定失败", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	/**
	 * 解锁
	 */
	public AjaxBeanUtil clear(String id) {
		Users u = usersMapper.selectByPrimaryKey(id);
		try {
			if (u != null) {
				u.setStatus("0");// 1锁定 0正常
				u.preUpdate();
				usersMapper.updateByPrimaryKeySelective(u);
				return new AjaxBeanUtil("解锁成功", true);
			}
			return new AjaxBeanUtil("解锁失败", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	/**
	 * @description ：查询经纪人订单详情
	 * @author pangchengxiang
	 * @date 2017年8月21日 下午5:25:00
	 * @return Page<Agents>
	 */
	public Page<Agents> findAgentOrderList(Page<Agents> page, Agents agents) {
		agents.setPage(page);
		page.setList(agentOrderMapper.findAgentOrderList(agents));
		return page;
	}

	public Agents findByOrderId(String id) {
		return agentsMapper.findOrderListId(id);
	}

	public Agents findAgentsId(String id) {
		return agentsMapper.selectByPrimaryKey(id);
	}

	public Agents findAgentsByUserId(String userId) {
		return agentsMapper.findAgentsByUserId(userId);
	}

	/**
	 * 王涛 编辑
	 */
	public AjaxBeanUtil update(Users us, HttpServletRequest request) {
		try {
			String companyName = request.getParameter("companyName");
			// 上传附件，返回上传结果
			List<FileOperatEntity> 	fileList = SpringMvcUploadUtil.upload(request);
			// 修改车主信息
			Agents agents = agentsMapper.findByUserId(us.getId());
			agents.setCompanyName(companyName);
			if(StringUtils.isEmpty(companyName)){
				agents.setIdentityType("0");// 个人身份选择（0个人、1公司 ）
			}else{
				agents.setIdentityType("1");// 个人身份选择（0个人、1公司 ）
			}
			agents.preUpdate();
			// 将上传结果赋值到对象
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, agents);
			}
			agentsMapper.updateByPrimaryKeySelective(agents);
			// 修改用户信息
			if (StringUtils.isNotBlank(us.getPassword())) {
				us.setPassword(SystemService.entryptPassword(us.getPassword()));
			}
			us.preUpdate();
			if (null != fileList) {
				SpringMvcUploadUtil.setObjectPropertyAndDelOldFile(fileList, us);
			}
			usersMapper.updateByPrimaryKeySelective(us);
			return new AjaxBeanUtil("修改成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxBeanUtil("系统异常", false);
		}
	}

	/**
	 * 通过用户ID查询用户实体
	 * 
	 * @param userId
	 * @return
	 */
	public Users findUserByUserId(String userId) {
		return usersMapper.selectByPrimaryKey(userId);
	}

}
