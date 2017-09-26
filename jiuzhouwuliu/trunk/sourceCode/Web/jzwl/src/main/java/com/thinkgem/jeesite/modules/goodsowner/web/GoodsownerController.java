package com.thinkgem.jeesite.modules.goodsowner.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.entity.Goodsowners;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.goodsowner.service.GoodsownerService;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @description	货主管理
 * @author 文帅
 * @date 2017年8月11日 上午10:18:52
 */
@Controller
@RequestMapping(value = "${adminPath}/goodsowner/goodsowner")
public class GoodsownerController {
	
	/**
	 * @description	跳转到货主管理列表页面
	 * @author 文帅
	 * @date 2017年8月11日 上午10:20:51
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Autowired
	private GoodsownerService  goodsownerService;
	@RequestMapping(value ="list")
	public String list(Goodsowners goodsowners,HttpServletRequest request, HttpServletResponse response, Model model) {
		//从缓存里取字典列表   搜索内容
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get("dictMap");
			if (dictMap!=null){
				//审核状态
				model.addAttribute("goodsownersStatus", dictMap.get("driver_master_change_auditing_status"));
				//等级
				model.addAttribute("goodsLevel", dictMap.get("goods_level"));
		}
		Page<Goodsowners> page = goodsownerService.findPage(new Page<Goodsowners>(request, response), goodsowners); 
		//页面显示数据 非数据库字段字符串
		for(Goodsowners d:page.getList()){
			//用户状态 0正常 1锁定 
			d.setUsersStatus(DictUtils.getDictLabel(d.getUsersStatus(),"users_status",d.getUsersStatus()));
			//审核状态 0未审核 1已审核 2审核未通过
			d.setDriverMasterChangeAuditingStatus(DictUtils.getDictLabel(d.getDriverMasterChangeAuditingStatus(),"driver_master_change_auditing_status",d.getDriverMasterChangeAuditingStatus()));
			//等级 ABC级
			d.setLevel(DictUtils.getDictValue(d.getLevel(), "goods_level",d.getLevel()));
		}
		
		model.addAttribute("doodsowners", goodsowners);
		model.addAttribute("page", page);
		return "modules/goodsowner/goodsownerList";
	}
	
	/**
	 * @description	跳转到货主添加页面
	 * @author 文帅
	 * @date 2017年8月11日 上午10:55:40
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="add")
	public String add(Goodsowners goodsowners,HttpServletRequest request, HttpServletResponse response, Model model) {
		//等级
		model.addAttribute("sys", DictUtils.getDictList("sys_office_grade"));
		model.addAttribute("status", DictUtils.getDictList("users_status"));
		model.addAttribute("goodsownersIdentityType", DictUtils.getDictList("goodsowners_identity_type"));
		return "modules/goodsowner/goodsownerAdd";
	}
	
	@RequestMapping(value = "saveGoodsowners")
    @ResponseBody
    public AjaxBeanUtil  saveGoodsowners(Users users, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
    	return goodsownerService.saveGoodsowners(users, request);
    }
	/**
	 * @description	跳转到货主详情页面
	 * wangtao
	 */
	@RequestMapping(value ="goGoodsownerDetail")
	public String goGoodsownerDetail(Goodsowners goodsowner,HttpServletRequest request, HttpServletResponse response, Model model) {
		Goodsowners goodsowners=goodsownerService.findGoodsownersId(goodsowner.getId());
		Users  users=goodsownerService.findUserByUserId(goodsowners.getUserId());
		DictUtils.getDictLabel(users.getUsersStatus(),"users_status",users.getUsersStatus());
	    DictUtils.getDictValue(users.getLevel(), "goods_level",users.getLevel());
		List<Dict> usersStatus=DictUtils.getDictList("users_status");
		List<Dict>goodsLevel=DictUtils.getDictList("goods_level");
		List<Dict>truckType=DictUtils.getDictList("truck_type");
		List<Dict>goodsownersIdentityType=DictUtils.getDictList("goodsowners_identity_type");
		model.addAttribute("goodsLevel", goodsLevel);
		model.addAttribute("usersStatus", usersStatus);
		model.addAttribute("users", users);
		model.addAttribute("truckType", truckType);
		model.addAttribute("goodsownersIdentityType", goodsownersIdentityType);
		model.addAttribute("goodsowners", goodsowners);
		return "modules/goodsowner/goodsownerDetail";
	}
	
	/**
	 * @description	跳转到订单明细页面
	 * @author 文帅
	 * @date 2017年8月11日 上午11:29:10
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="order")
	public String order(Goodsowners goodsowners,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Goodsowners> page = goodsownerService.findGoodsownerOrderList(new Page<Goodsowners>(request, response), goodsowners); 
		for(Goodsowners d:page.getList()){
				d.setGoodsType(DictUtils.getDictLabel(d.getGoodsType(),"goods_type",d.getGoodsType()));
		}
		model.addAttribute("goodsowners", goodsowners);	
		model.addAttribute("page", page);	
		return "modules/goodsowner/goodsownerOrderList";
	}
	/**
	 * 锁定
	 */
	@RequestMapping(value="lock",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil lock(String id){
		return goodsownerService.lock(id);
	}
	/**
	 * 	解锁
	 * 
	 */
	@RequestMapping(value="clear",method=RequestMethod.POST)
	@ResponseBody
	public AjaxBeanUtil clear(String id){
		return goodsownerService.clear(id);
	}
	/**
	 * 根据Id查询订单详情
	 * 王涛
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goodsownerDetailOrder")
	public String detailOrder( Goodsowners doodsowner,HttpServletRequest request, HttpServletResponse response, Model model) {
		Goodsowners doodsowners=goodsownerService.findByOrderId(doodsowner.getId());
		doodsowners.setGoodsType(DictUtils.getDictLabel(doodsowners.getGoodsType(),"goods_type",doodsowners.getGoodsType()));
		model.addAttribute("doodsowners", doodsowners);
		return "modules/goodsowner/goodsownerDetailOrderList";
	}
	
	//上传图片
		@RequestMapping(value="/uploadImage",method=RequestMethod.POST)  
	    public void uploadImgApp(Users  users ,@RequestParam(value="file",required=false) MultipartFile file,
	    		@RequestParam(value="file1",required=false) MultipartFile file1,
	    		@RequestParam(value="file2",required=false) MultipartFile file2,
	    		@RequestParam(value="file3",required=false) MultipartFile file3,
	    		@RequestParam(value="file4",required=false) MultipartFile file4,
	    		HttpServletRequest request){
			Goodsowners goodsowners=goodsownerService.findByUserId(users.getId());
			try {
				//头像
				if(file!=null && StringUtils.isNotEmpty(file.getOriginalFilename())){
					String path=goodsownerService.fildUpload(file, request);
					users.setHeadImg(path);
				}
				//身份证正面
				if(file3!=null && StringUtils.isNotEmpty(file3.getOriginalFilename())){
					String path3=goodsownerService.fildUpload(file3, request);
					users.setCardFaceImg(path3);
				}
				//身份证反面
				if(file4!=null && StringUtils.isNotEmpty(file4.getOriginalFilename())){
					String path4=goodsownerService.fildUpload(file4, request);
					users.setCardOtherImg(path4);
				}
				goodsownerService.updateInfo(users);
				//营业执照正面
				if(file1!=null && StringUtils.isNotEmpty(file1.getOriginalFilename())){
					String path1=goodsownerService.fildUpload(file1, request);
					goodsowners.setBusinessLicenseFaceImg(path1);
				}
				//营业执照反面
				if(file2!=null && StringUtils.isNotEmpty(file2.getOriginalFilename())){
					String path2=goodsownerService.fildUpload(file2, request);
					goodsowners.setBusinessLicenseOtherImg(path2);
				}
				/*//企业性质
				if(file3!=null && StringUtils.isNotEmpty(file3.getOriginalFilename())){
					String path3=goodsownerService.fildUpload(file3, request);
					goodsowners.setBusinessLicenseImgs(path3);
				}*/
				goodsownerService.updateInfo1(goodsowners);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
		
		/**
		 * 王涛
		 * 编辑货主链接
		 */
		@RequestMapping(value = "edit")
		public String edit(Goodsowners doodsowner,HttpServletRequest request, HttpServletResponse response, Model model) {
			Goodsowners goodsowners=goodsownerService.findGoodsownersId(doodsowner.getId());
			Users  users=goodsownerService.findUserByUserId(goodsowners.getUserId());
			DictUtils.getDictLabel(users.getUsersStatus(),"users_status",users.getUsersStatus());
		    DictUtils.getDictValue(users.getLevel(), "goods_level",users.getLevel());
			List<Dict> usersStatus=DictUtils.getDictList("users_status");
			List<Dict>goodsLevel=DictUtils.getDictList("goods_level");
			List<Dict>truckType=DictUtils.getDictList("truck_type");
			List<Dict>goodsownersIdentityType=DictUtils.getDictList("goodsowners_identity_type");
			model.addAttribute("goodsLevel", goodsLevel);
			model.addAttribute("usersStatus", usersStatus);
			model.addAttribute("users", users);
			model.addAttribute("truckType", truckType);
			model.addAttribute("goodsownersIdentityType", goodsownersIdentityType);
			model.addAttribute("goodsowners", goodsowners);
			return "modules/goodsowner/editGoodsowners";
		}
		@RequestMapping(value = "update")
	    @ResponseBody
	    public AjaxBeanUtil  update(Users us,HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
	    	return goodsownerService.update(us, request);
	    }
}
