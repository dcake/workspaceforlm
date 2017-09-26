package com.thinkgem.jeesite.common.entity;


import com.thinkgem.jeesite.common.persistence.CommonEntity;

public class InseranceRule extends CommonEntity<InseranceRule>{
    //
	private static final long serialVersionUID = 1L;

	private String id;

    private String inseranceCompanyId;

    private String goodsType;

    private Double priceMin;

    private Double priceMax;

    private Double money;
    private String companyName;//保险公司
    private String goodsTypeStr;//货物类型字符串


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInseranceCompanyId() {
        return inseranceCompanyId;
    }

    public void setInseranceCompanyId(String inseranceCompanyId) {
        this.inseranceCompanyId = inseranceCompanyId == null ? null : inseranceCompanyId.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Double priceMin) {
        this.priceMin = priceMin;
    }

    public Double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Double priceMax) {
        this.priceMax = priceMax;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGoodsTypeStr() {
		return goodsTypeStr;
	}

	public void setGoodsTypeStr(String goodsTypeStr) {
		this.goodsTypeStr = goodsTypeStr;
	}

}