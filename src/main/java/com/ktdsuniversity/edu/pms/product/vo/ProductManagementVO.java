package com.ktdsuniversity.edu.pms.product.vo;

import com.ktdsuniversity.edu.pms.common.vo.PaginateVO;

public class ProductManagementVO extends PaginateVO {
	
	private String prdtMngId;
	private int prdtPrice;
	private String buyDt;
	private String lostYn;
	private String lostDt;
	private String brrwYn;
	private String prdtId;
	private String delYn;
	
	private ProductVO productVO;
	
	private String searchType; // option 선택
	private String searchKeyword; // 검색어
	
	public ProductVO getProductVO() {
		return productVO;
	}
	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
	public String getPrdtMngId() {
		return prdtMngId;
	}
	public void setPrdtMngId(String prdtMngId) {
		this.prdtMngId = prdtMngId;
	}
	public int getPrdtPrice() {
		return prdtPrice;
	}
	public void setPrdtPrice(int prdtPrice) {
		this.prdtPrice = prdtPrice;
	}
	public String getBuyDt() {
		return buyDt;
	}
	public void setBuyDt(String buyDt) {
		this.buyDt = buyDt;
	}
	public String getLostYn() {
		return lostYn;
	}
	public void setLostYn(String lostYn) {
		this.lostYn = lostYn;
	}
	public String getLostDt() {
		return lostDt;
	}
	public void setLostDt(String lostDt) {
		this.lostDt = lostDt;
	}
	public String getBrrwYn() {
		return brrwYn;
	}
	public void setBrrwYn(String brrwYn) {
		this.brrwYn = brrwYn;
	}
	public String getPrdtId() {
		return prdtId;
	}
	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	

}
