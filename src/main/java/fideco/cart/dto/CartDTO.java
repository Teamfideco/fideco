package fideco.cart.dto;

public class CartDTO {
	private int cart_no;
	private int order_amount;
	private String product_id;
	private String member_id;
	private String cart_id;
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
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
		return "CartDTO [cart_no=" + cart_no + ", order_amount=" + order_amount + ", product_id=" + product_id
				+ ", member_id=" + member_id + ", cart_id=" + cart_id + "]";
	}
	
	
	
}
