package fideco.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.qna.dao.QnaDAO;
import fideco.qna.dto.QnaDTO;

public class QnaUpdateDetailCotroller implements Controller {
	
	private static Log log = LogFactory.getLog(QnaUpdateDetailCotroller.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		QnaDAO qnaDAO = new QnaDAO();
		QnaDTO qnaDTO = new QnaDTO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		qnaDTO = qnaDAO.qnaSelect(num);
		log.info(qnaDTO);
		request.setAttribute("qnaDTO", qnaDTO);
		handlerAdapter.setPath("/WEB-INF/view/qna/qna_update.jsp");
		
		return handlerAdapter;
	}

}
