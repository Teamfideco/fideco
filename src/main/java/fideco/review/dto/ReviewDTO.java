package fideco.review.dto;

public class ReviewDTO {
	
	private int num;
	private String Review_id;
	private String Review_title;
	private String Review_content;
	private String Review_regisdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReview_id() {
		return Review_id;
	}
	public void setReview_id(String review_id) {
		Review_id = review_id;
	}
	public String getReview_title() {
		return Review_title;
	}
	public void setReview_title(String review_title) {
		Review_title = review_title;
	}
	public String getReview_content() {
		return Review_content;
	}
	public void setReview_content(String review_content) {
		Review_content = review_content;
	}
	public String getReview_regisdate() {
		return Review_regisdate;
	}
	public void setReview_regisdate(String review_regisdate) {
		Review_regisdate = review_regisdate;
	}
	@Override
	public String toString() {
		return "ReviewDTO [num=" + num + ", Review_id=" + Review_id + ", Review_title=" + Review_title
				+ ", Review_content=" + Review_content + ", Review_regisdate=" + Review_regisdate + "]";
	}
	
	
	
	

}