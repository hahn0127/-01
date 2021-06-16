package ksmart39.mybatis.domain;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private String goodsPrice;
	private String goodsSellerId;
	private String goodsRegDate;
	
	//판매자의정보를 가지고와야하는 경우
	//Member객체에 getter,setter,toString이있어야 가능하다 
	//Member 면 1:1  association
	private Member member;

	
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsSellerId=" + goodsSellerId + ", goodsRegDate=" + goodsRegDate + ", member=" + member + "]";
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsSellerId() {
		return goodsSellerId;
	}

	public void setGoodsSellerId(String goodsSellerId) {
		this.goodsSellerId = goodsSellerId;
	}

	public String getGoodsRegDate() {
		return goodsRegDate;
	}

	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
