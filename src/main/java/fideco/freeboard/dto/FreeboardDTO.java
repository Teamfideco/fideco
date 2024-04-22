package fideco.freeboard.dto;

public class FreeboardDTO {

		private int num;			//게시판  ID
		private String member_id;          // 회원 ID
	    private String freeboard_title;    // 게시물 제목
	    private String freeboard_content;  // 게시물 내용
	    private String freeboard_registdate; // 등록일
	    
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getMember_id() {
			return member_id;
		}
		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}
		public String getFreeboard_title() {
			return freeboard_title;
		}
		public void setFreeboard_title(String freeboard_title) {
			this.freeboard_title = freeboard_title;
		}
		public String getFreeboard_content() {
			return freeboard_content;
		}
		public void setFreeboard_content(String freeboard_content) {
			this.freeboard_content = freeboard_content;
		}
		public String getFreeboard_registdate() {
			return freeboard_registdate;
		}
		public void setFreeboard_registdate(String freeboard_registdate) {
			this.freeboard_registdate = freeboard_registdate;
		}
		@Override
		public String toString() {
			return "FreeboardDTO [num=" + num + ", member_id=" + member_id + ", freeboard_title="
					+ freeboard_title + ", freeboard_content=" + freeboard_content + ", freeboard_registdate="
					+ freeboard_registdate + "]";
		}  
	    
}
	    
		