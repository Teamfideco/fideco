package fideco.product.dto;

public class ProductDTO {
	
	private String product_id;
    private String product_name;
    private int product_price;
    private String product_regisdate;
    private String product_intro;
    private String product_image;
    private String product_category;
    
    
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_regisdate() {
		return product_regisdate;
	}
	public void setProduct_regisdate(String product_regisdate) {
		this.product_regisdate = product_regisdate;
	}
	public String getProduct_intro() {
		return product_intro;
	}
	public void setProduct_intro(String product_intro) {
		this.product_intro = product_intro;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_regisdate=" + product_regisdate + ", product_intro=" + product_intro
				+ ", product_image=" + product_image + ", product_category=" + product_category + "]";
	}
    
    
}
