package fideco.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.notice.dao.NoticeDAO;
import fideco.notice.dto.NoticeDTO;


public class NoticeUpdateController implements Controller {
	private static Log log = LogFactory.getLog(NoticeUpdateController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		log.info(notice_num);
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeDTO noticeDTO = new NoticeDTO();

		noticeDTO = noticeDAO.noticeSelect(notice_num);
		log.info("DTO : "+ noticeDTO);
		request.setAttribute("noticeDTO", noticeDTO);

		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/notice/notice_update.jsp");

		return HandlerAdapter;
	}

}
