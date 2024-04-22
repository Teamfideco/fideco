package fideco.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.notice.dao.NoticeDAO;
import fideco.notice.dto.NoticeDTO;

public class NoticeInsertController implements Controller{
	private static Log log = LogFactory.getLog(NoticeInsertController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String notice_title = request.getParameter("notice_title");
		log.info("notice_title:"+notice_title);
		String notice_content = request.getParameter("notice_content");
		log.info("notice_content:"+notice_content);
		String notice_writer = request.getParameter("notice_writer");
		log.info("notice_writer:"+notice_writer);
		
		
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeDTO noticeDTO = new NoticeDTO();
		ArrayList<NoticeDTO> arrayList = new ArrayList<NoticeDTO>();
		
		arrayList = noticeDAO.noticeSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		
		noticeDTO.setNotice_title(notice_title);
		noticeDTO.setNotice_content(notice_content);
		noticeDTO.setNotice_writer(notice_writer);
		
		
		
		noticeDTO = noticeDAO.noticeInsert(noticeDTO);
		log.info(noticeDTO);
		
		request.setAttribute("noticeDTO", noticeDTO);
		log.info("공지사항 등록");
		
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/notice/notice_insert.jsp");
		return HandlerAdapter;
		
		
	}
	
}
