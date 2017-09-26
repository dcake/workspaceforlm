package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class PlatformPayRule extends CommonEntity<PlatformPayRule>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private Double transportMinFee;
    private String transportMinFeeStr;

    private Double transportMaxFee;
    private String transportMaxFeeStr;

    public String getTransportMinFeeStr() {
		return transportMinFeeStr;
	}

	public void setTransportMinFeeStr(String transportMinFeeStr) {
		this.transportMinFeeStr = transportMinFeeStr;
	}

	public String getTransportMaxFeeStr() {
		return transportMaxFeeStr;
	}

	public void setTransportMaxFeeStr(String transportMaxFeeStr) {
		this.transportMaxFeeStr = transportMaxFeeStr;
	}

	private Double oilCardFee;
    private String oilCardFeeStr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getTransportMinFee() {
        return transportMinFee;
    }

    public void setTransportMinFee(Double transportMinFee) {
        this.transportMinFee = transportMinFee;
    }

    public Double getTransportMaxFee() {
        return transportMaxFee;
    }

    public void setTransportMaxFee(Double transportMaxFee) {
        this.transportMaxFee = transportMaxFee;
    }

    public Double getOilCardFee() {
        return oilCardFee;
    }

    public void setOilCardFee(Double oilCardFee) {
        this.oilCardFee = oilCardFee;
    }

	public String getOilCardFeeStr() {
		return oilCardFeeStr;
	}

	public void setOilCardFeeStr(String oilCardFeeStr) {
		this.oilCardFeeStr = oilCardFeeStr;
	}

}