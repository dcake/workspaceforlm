package com.thinkgem.jeesite.common.persistence;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileOperatEntity
 * @description 用于文件上传、下载数据传输
 * @author pangchengxiang
 * @date 2017年9月15日 上午9:16:09
 */
public class FileOperatEntity {

	private String fileOrgName;
	private String fileNewName;
	private String fileSize;
	private String filePath;
	private String formName; // 上传附件file输入框的名称
	private boolean isOk = false; // 上传是否成功

	private MultipartFile file;

	public String getFileOrgName() {
		return fileOrgName;
	}

	public void setFileOrgName(String fileOrgName) {
		this.fileOrgName = fileOrgName;
	}

	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
