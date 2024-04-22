package fideco.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.qna.dao.QnaDAO;
import fideco.qna.dto.QnaDTO;

public class QnaUpdateController implements Controller {
	
	private static Log log = LogFactory.getLog(QnaUpdateController.class);


	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {	
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		QnaDAO qnaDAO = new QnaDAO();
		QnaDTO qnaDTO = new QnaDTO();
		boolean result = false;
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			qnaDTO.setNum(num);
			qnaDTO.setQna_id(request.getParameter("qna_id"));
			qnaDTO.setQna_title(request.getParameter("qna_title"));
			qnaDTO.setQna_content(request.getParameter("qna_content"));
			qnaDTO.setQna_regisdate(request.getParameter("qna_regisdate"));
			
			result = qnaDAO.qnaUpdate(qnaDTO);
			log.info("게시글 수정 -" + result);
			handlerAdapter.setRedirect(true);
			handlerAdapter.setPath("./QnaSelectDetail.qb?num=" + qnaDTO.getNum());
			return handlerAdapter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
