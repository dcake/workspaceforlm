package com.thinkgem.jeesite.mobile.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @desc 上传图片保存
 * @author yaotengfei
 * @date 2017年8月22日下午2:47:21
 */
public class SaveFileUtil {
	
	/**
	 * @desc 保存图片
	 * @author yaotengfei
	 * @date 2017年8月22日下午2:48:33
	 * @param file 图片文件
	 * @param tempURL	保存目录
	 * @return 返回图片存放相对路径
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String saveImg(HttpServletRequest request,MultipartFile file,String tempURL) throws IllegalStateException, IOException{
		if(file != null){
			//获取在Web服务器上的 绝对路径  
 	        String path =request.getSession().getServletContext().getRealPath("/")+tempURL;
 	        //创建文件夹
 	  		File folders=new File(path);
 	  	    if(!folders.exists() && !folders.isDirectory()){
 	  	    	folders.mkdirs();
 	  	    }
 	  	    //获取文件扩展名
  	  	    String tail="";
  			String[] tmps=file.getOriginalFilename().split("\\.");
  			if(tmps.length>1){
  				tail="."+tmps[tmps.length-1];
  			}
  	  	    //生成随机文件名
  	        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
  			String fileName = df.format(new Date()) + "_" + new Random().nextInt(1000);
  			//合并文件名和扩展名
  			fileName=fileName+tail;
            //定义上传路径  
            String imgPath = path + fileName;  
            File localFile = new File(imgPath);  
            file.transferTo(localFile); 
            return tempURL+fileName;
        }else{
        	return null;
        }
	}
}
