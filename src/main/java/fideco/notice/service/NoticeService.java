package fideco.notice.service;

import java.util.ArrayList;

import fideco.notice.dto.NoticeDTO;

// 서비스는 db에 DTO 객체를 전달해 정보 저장, 호출. 데이터베이스에 연동할 변수를 전송한다.
public interface NoticeService {

	// 전체 데이터를 조회
	public ArrayList<NoticeDTO> noticeSelectAll();

	// 개별 데이터를 조회
	public NoticeDTO noticeSelect(int notice_num);

	// 데이터 입력
	public NoticeDTO noticeInsert(NoticeDTO noticeDTO);

	// 데이터 수정
	public NoticeDTO noticeUpdate(NoticeDTO noticeDTO);

	// 데이터 삭제
	public NoticeDTO noticeDelete(int notice_num);
	
	//조회수 증가
	public NoticeDTO noticehitUpdate(int notice_hit);
}
