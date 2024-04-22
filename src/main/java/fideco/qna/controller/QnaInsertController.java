package fideco.qna.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.qna.dao.QnaDAO;
import fideco.qna.dto.QnaDTO;

public class QnaInsertController implements Controller {
	
	private static Log log = LogFactory.getLog(QnaInsertController.class);


	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	   
//		String qna_id = request.getParameter("qna_id");
//		log.info("id-"+qna_id);
//		String qna_title = request.getParameter("qna_title");
//		log.info("title-"+qna_title);
//		String qna_content = request.getParameter("qna_content");
//		log.info("content-"+qna_content);
//		String qna_regisdate = request.getParameter("qna_regisdate");
//		log.info("date-"+qna_regisdate);
		
		
		QnaDAO qnaDAO = new QnaDAO();
		QnaDTO qnaDTO = new QnaDTO();	
//		ArrayList<QnaDTO> arrayList = new ArrayList<QnaDTO>();
//		arrayList = qnaDAO.QnaSelectAll();
//		request.setAttribute("ArrayList", arrayList);
//		log.info("List 확인 -" + arrayList);
		boolean result = false;
		try {
			
			qnaDTO.setQna_id(request.getParameter("qna_id"));
			qnaDTO.setQna_title(request.getParameter("qna_title"));
			qnaDTO.setQna_content(request.getParameter("qna_content"));
			qnaDTO.setQna_regisdate(request.getParameter("qna_regisdate"));
			
			result = qnaDAO.qnaInsert(qnaDTO);		
			log.info("DTO 확인 -"+qnaDTO);	
			log.info("글정보 등록 - " + result);
			request.setAttribute("result", result);
			
			HandlerAdapter handlerAdapter = new HandlerAdapter();
			handlerAdapter.setRedirect(true);
			handlerAdapter.setPath("./QnaSelect.qb");
			
			return handlerAdapter;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
