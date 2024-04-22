package fideco.order.dto;

public class OrderDTO {
	private int order_no;
	private int order_amount;
	private String product_id;
	private String member_id;
	private String cart_id;
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_no=" + order_no + ", order_amount=" + order_amount + ", product_id=" + product_id
				+ ", member_id=" + member_id + ", cart_id=" + cart_id + "]";
	}
	
}
