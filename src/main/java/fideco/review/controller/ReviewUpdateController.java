package fideco.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.review.dao.ReviewDAO;
import fideco.review.dto.ReviewDTO;

public class ReviewUpdateController implements Controller {
	
	private static Log log = LogFactory.getLog(ReviewUpdateController.class);


	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {	
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		ReviewDAO reviewDAO = new ReviewDAO();
		ReviewDTO reviewDTO = new ReviewDTO();
		boolean result = false;
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			reviewDTO.setNum(num);
			reviewDTO.setReview_id(request.getParameter("review_id"));
			reviewDTO.setReview_title(request.getParameter("review_title"));
			reviewDTO.setReview_content(request.getParameter("review_content"));
			reviewDTO.setReview_regisdate(request.getParameter("review_regisdate"));
			
			result = reviewDAO.reviewUpdate(reviewDTO);
			log.info("게시글 수정 -" + result);
			handlerAdapter.setRedirect(true);
			handlerAdapter.setPath("./ReviewSelectDetail.rb?num=" + reviewDTO.getNum());
			return handlerAdapter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
