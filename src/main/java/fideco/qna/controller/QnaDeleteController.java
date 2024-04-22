package fideco.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.qna.dao.QnaDAO;

public class QnaDeleteController implements Controller {

private static Log log = LogFactory.getLog(QnaDeleteController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		boolean result = false;
		int num = Integer.parseInt(request.getParameter("num"));
		QnaDAO qnaDAO = new QnaDAO();
		
		result = qnaDAO.qnaDelete(num);
		log.info("게시글 삭제-"+result);
		
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./QnaSelect.qb");
		return handlerAdapter;
	}

}
