package com.thinkgem.jeesite.common.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.FileOperatEntity;

/**
 * @ClassName SpringMCV
 * @description TODO(这里用一句话描述这个类的作用)
 * @author pangchengxiang
 * @date 2017年9月15日 上午9:11:51
 */
public class SpringMvcUploadUtil {
	private static  String SEPARATOR = File.separator;
	private static String UPLOAD_BASEPATH=Global.getUserfilesBaseDir();
	private static String DIRNAME="upLoadFile";
	//上传文件夹
	private static String UPLOAD_DIR;
	static{
		if(SEPARATOR.equals("\\")){
			UPLOAD_BASEPATH = UPLOAD_BASEPATH.replace("/", "\\");
		}
		if(SEPARATOR.equals("/")){
			UPLOAD_BASEPATH = UPLOAD_BASEPATH.replace("\\", "/");
		}
		UPLOAD_DIR=UPLOAD_BASEPATH+DIRNAME;
		createDir(UPLOAD_DIR);
	}
	
	public static List<FileOperatEntity> upload(HttpServletRequest request) throws IllegalStateException, IOException {  
		List<FileOperatEntity> list= getMultipartFileList(request);
		for(FileOperatEntity f:list){
			uploadFile(f);
		}
		return list;
    }
	
	public static void setObjectProperty(List<FileOperatEntity> list,Object obj){
		for(FileOperatEntity f:list){
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				Field field = Reflections.getAccessibleField(obj,proStr);
				if(null!=field){
					if(f.isOk()){
						Reflections.invokeSetter(obj, proStr, DIRNAME+SEPARATOR+f.getFileNewName());
					}
				}
			}
		}
	}
	
	public static void setObjectPropertyAndDelOldFile(List<FileOperatEntity> list,Object obj){
		for(FileOperatEntity f:list){
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				Field field = Reflections.getAccessibleField(obj,proStr);
				if(null!=field){
					if(f.isOk()){
						Object oldPath = Reflections.invokeGetter(obj, proStr);
						Reflections.invokeSetter(obj, proStr, DIRNAME+SEPARATOR+f.getFileNewName());
						if(null!=oldPath){
							File file = new File(UPLOAD_BASEPATH+oldPath.toString());
							if(file.exists()){
								file.delete();
							}
						}
						
					}
				}
			}
		}
	}
	
	
	private static List<FileOperatEntity> getMultipartFileList(HttpServletRequest request) throws IllegalStateException, IOException {  
        //创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        List<FileOperatEntity> fileList = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames(); 
            while(iter.hasNext()){ 
            	FileOperatEntity fileOperat = new FileOperatEntity();
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){
                    //取得当前上传文件的文件名称  
                    String originalFilename = file.getOriginalFilename().trim();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(!"".equals(originalFilename)){  
                    	fileOperat.setFile(file);
                    	fileOperat.setFormName(file.getName());
                    	fileOperat.setFileOrgName(originalFilename);
                    	fileOperat.setFileNewName(sf.format(new Date())+"_"+file.getOriginalFilename());
                    	fileList.add(fileOperat);
                    }  
                }  
            }  
              
        }
		return fileList;  
    }
	
	private static void uploadFile(FileOperatEntity f) throws IllegalStateException, IOException{
		boolean flag=false;
		if(null!=f){
			MultipartFile mf = f.getFile();
			if(null!=mf){
				File localFile = new File(UPLOAD_DIR+SEPARATOR+f.getFileNewName()); 
				//设置文件上传路径
				f.setFilePath(UPLOAD_DIR+SEPARATOR+f.getFileNewName());
				mf.transferTo(localFile);
				flag = true;
			}
		}
		f.setOk(flag);
	}
	
	public static Object upload(HttpServletRequest request,Object obj) throws IllegalStateException, IOException {
		List<FileOperatEntity> list= getMultipartFileList(request);
		for(FileOperatEntity f:list){
			boolean flag = false;
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				Field field = Reflections.getAccessibleField(obj,proStr);
				if(null!=field){
					uploadFile(f);
					if(f.isOk()){
						Reflections.invokeSetter(obj, proStr, DIRNAME+SEPARATOR+f.getFileNewName());
					}
				}
			}
			f.setOk(flag);
		}
		return obj;
    }
	
	public static Object uploadAndDelOldFile(HttpServletRequest request,Object obj) throws IllegalStateException, IOException {  
		List<FileOperatEntity> list= getMultipartFileList(request);
		for(FileOperatEntity f:list){
			boolean flag = false;
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				Field field = Reflections.getAccessibleField(obj,proStr);
				if(null!=field){
					uploadFile(f);
					if(f.isOk()){
						Object oldPath = Reflections.invokeGetter(obj, proStr);
						Reflections.invokeSetter(obj, proStr, DIRNAME+SEPARATOR+f.getFileNewName());
						if(null!=oldPath){
							File file = new File(UPLOAD_BASEPATH+oldPath.toString());
							if(file.exists()){
								file.delete();
							}
						}
					}
				}
			}
			f.setOk(flag);
		}
		return obj;
    }
	
	public static Object upload(HttpServletRequest request,Object obj,Set<String> keySet) throws IllegalStateException, IOException {
		List<FileOperatEntity> list= getMultipartFileList(request);
		for(FileOperatEntity f:list){
			boolean flag = false;
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				if(keySet.contains(proStr)){
					Field field = Reflections.getAccessibleField(obj,proStr);
					if(null!=field){
						uploadFile(f);
						if(f.isOk()){
							Reflections.invokeSetter(obj, proStr,DIRNAME+SEPARATOR+f.getFileNewName());
						}
					}
				}
			}
			f.setOk(flag);
		}
		return obj;
    }
	
	public static Object uploadAndDelOldFile(HttpServletRequest request,Object obj,Set<String> keySet) throws IllegalStateException, IOException {  
		List<FileOperatEntity> list= getMultipartFileList(request);
		for(FileOperatEntity f:list){
			boolean flag = false;
			if(null!=f.getFormName()&&StringUtils.endsWith(f.getFormName(), "_file")){
				String proStr = StringUtils.substringBeforeLast(f.getFormName(), "_file");
				if(keySet.contains(proStr)){
					Field field = Reflections.getAccessibleField(obj,proStr);
					if(null!=field){
						uploadFile(f);
						if(f.isOk()){
							Object oldPath = Reflections.invokeGetter(obj, proStr);
							Reflections.invokeSetter(obj, proStr, DIRNAME+SEPARATOR+f.getFileNewName());
							if(null!=oldPath){
								File file = new File(UPLOAD_BASEPATH+oldPath.toString());
								if(file.exists()){
									file.delete();
								}
							}
						}
					}
				}
			}
			f.setOk(flag);
		}
		return obj;
    }
	
	// 创建目录
	private static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			return true;
		} else {
			return false;
		}
	}
}
