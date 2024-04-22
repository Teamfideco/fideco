package fideco.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.notice.dao.NoticeDAO;
import fideco.notice.dto.NoticeDTO;

public class NoticeDeleteController implements Controller {
	private static Log log = LogFactory.getLog(NoticeDeleteController.class);
	 
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		log.info(notice_num);
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeDTO noticeDTO = new NoticeDTO();
		
		noticeDTO.setNotice_num(notice_num);
		request.setAttribute("noticeDTO", noticeDTO);
		noticeDTO = noticeDAO.noticeDelete(notice_num);
		log.info(noticeDTO);
		
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/notice/notice_delete_view.jsp");
		
		return HandlerAdapter;
	}

}
