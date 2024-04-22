package fideco.review.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.review.dao.ReviewDAO;
import fideco.review.dto.ReviewDTO;

public class ReviewInsertController implements Controller {
	
	private static Log log = LogFactory.getLog(ReviewInsertController.class);


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
		
		
		ReviewDAO reviewDAO = new ReviewDAO();
		ReviewDTO reviewDTO = new ReviewDTO();	
//		ArrayList<QnaDTO> arrayList = new ArrayList<QnaDTO>();
//		arrayList = qnaDAO.QnaSelectAll();
//		request.setAttribute("ArrayList", arrayList);
//		log.info("List 확인 -" + arrayList);
		boolean result = false;
		try {
			
			reviewDTO.setReview_id(request.getParameter("review_id"));
			reviewDTO.setReview_title(request.getParameter("review_title"));
			reviewDTO.setReview_content(request.getParameter("review_content"));
			reviewDTO.setReview_regisdate(request.getParameter("review_regisdate"));
			
			result = reviewDAO.reviewInsert(reviewDTO);		
			log.info("DTO 확인 -"+reviewDTO);	
			log.info("글정보 등록 - " + result);
			request.setAttribute("result", result);
			
			HandlerAdapter handlerAdapter = new HandlerAdapter();
			handlerAdapter.setRedirect(true);
			handlerAdapter.setPath("./ReviewSelect.rb");
			
			return handlerAdapter;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
