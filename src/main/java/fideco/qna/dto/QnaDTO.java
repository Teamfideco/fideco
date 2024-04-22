package fideco.qna.dto;

public class QnaDTO {
	
	private int num;
	private String Qna_id;
	private String Qna_title;
	private String Qna_content;
	private String Qna_regisdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getQna_id() {
		return Qna_id;
	}
	public void setQna_id(String qna_id) {
		Qna_id = qna_id;
	}
	public String getQna_title() {
		return Qna_title;
	}
	public void setQna_title(String qna_title) {
		Qna_title = qna_title;
	}
	public String getQna_content() {
		return Qna_content;
	}
	public void setQna_content(String qna_content) {
		Qna_content = qna_content;
	}
	public String getQna_regisdate() {
		return Qna_regisdate;
	}
	public void setQna_regisdate(String qna_regisdate) {
		Qna_regisdate = qna_regisdate;
	}
	@Override
	public String toString() {
		return "QnaDTO [num=" + num + ", Qna_id=" + Qna_id + ", Qna_title=" + Qna_title + ", Qna_content=" + Qna_content
				+ ", Qna_regisdate=" + Qna_regisdate + "]";
	}
	
	

}