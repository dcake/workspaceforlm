package com.thinkgem.jeesite.mobile.common.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.mobile.utils.AjaxBeanUtil;

/**
 * @desc app版本更新
 * @author yaotengfei
 * @date 2017年8月10日下午2:51:16
 */
@Service
@Transactional
public class MobileCommonVersionService {

	/**
	 * @desc 版本更新
	 * @author yaotengfei
	 * @date 2017年8月10日下午2:56:33
	 * @param request
	 * @return
	 */
	public AjaxBeanUtil versionUpdate(HttpServletRequest request){
		String currVersion = request.getParameter("currVersion");
		String userSort = request.getParameter("userSort");
		try {
			@SuppressWarnings("deprecation")
			String configPath=request.getRealPath("/");
			String configUrl=configPath+"/APPVersion/app-version.xml";
		    File f = new File(configUrl);
		    SAXReader reader = new SAXReader();
		    Document doc = reader.read(f);
		    Element root = doc.getRootElement();   
		    Element foo;
		    String url="";
		    String version="";
		    String title="";
		    String userSortRoot = "";
		    if("0".equals(userSort)){
		    	userSortRoot = "SHIPPER";
		    }else if("1".equals(userSort)){
		    	userSortRoot = "OWNER";
		    }else{
		    	userSortRoot = "AGENT";
		    }
			for (Iterator i = root.elementIterator(userSortRoot); i.hasNext();) {   
				foo = (Element) i.next();
				url=foo.elementText("url");
				version=foo.elementText("version");
				title=foo.elementText("title");
			}
			Map<String,Object> param=new HashMap<String,Object>();
		   	if(compareVersion(currVersion,version) > 0){
			   	 param.put("version", version);
			     param.put("url", url);
			     param.put("title", title);
			     return new AjaxBeanUtil(title, true, param);
		   	}else{
		   		return new AjaxBeanUtil("已是最新版本！", false);
		   	}
	   } catch (Exception e) {   
	    e.printStackTrace();
	    return new AjaxBeanUtil("系统出错", false);
	   }
	}
	
	/**
	 * @desc 比较两个版本号大小,若有新版本返回1，否则返回0
	 * @author yaotengfei
	 * @date 2017年8月10日下午4:02:52
	 * @param currVersion 当前版本
	 * @param lastVersion 最新版本
	 * @return
	 */
	public int compareVersion(String currVersion,String lastVersion){
		String[] curr = currVersion.split(".");
		String[] last = lastVersion.split(".");
		int minLength = Math.min(curr.length,last.length);
		for(int i = 0; i < minLength; i++){
			//比较长度
			if(last[i].length() > curr[i].length()){
				return 1;
			}
			//比较大小 
			if(Integer.parseInt(last[i]) > Integer.parseInt(curr[i])){
				return 1;
			}
		}
		//比较位数
		if(last.length > curr.length){
			return 1;
		}
		return 0;
	}
}
