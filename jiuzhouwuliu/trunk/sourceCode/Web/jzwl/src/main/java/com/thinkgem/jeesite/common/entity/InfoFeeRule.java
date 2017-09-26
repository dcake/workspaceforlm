package com.thinkgem.jeesite.common.entity;

import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class InfoFeeRule extends CommonEntity<InfoFeeRule> {
	//
	private static final long serialVersionUID = 1L;

	private String id;

	private String dictvalue;

	private String dictlabel;

	private Double infoFee;
	private String infoFeeStr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getDictvalue() {
		return dictvalue;
	}

	public void setDictvalue(String dictvalue) {
		this.dictvalue = dictvalue == null ? null : dictvalue.trim();
	}

	public String getDictlabel() {
		return dictlabel;
	}

	public void setDictlabel(String dictlabel) {
		this.dictlabel = dictlabel == null ? null : dictlabel.trim();
	}

	public Double getInfoFee() {
		return infoFee;
	}

	public void setInfoFee(Double infoFee) {
		this.infoFee = infoFee;
	}

	public String getInfoFeeStr() {
		return infoFeeStr;
	}

	public void setInfoFeeStr(String infoFeeStr) {
		this.infoFeeStr = infoFeeStr;
	}

}