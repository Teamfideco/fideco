package fideco.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.review.dao.ReviewDAO;

public class ReviewDeleteController implements Controller {

private static Log log = LogFactory.getLog(ReviewDeleteController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		boolean result = false;
		int num = Integer.parseInt(request.getParameter("num"));
		ReviewDAO reviewDAO = new ReviewDAO();
		
		result = reviewDAO.reviewDelete(num);
		log.info("게시글 삭제-"+result);
		
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./ReviewSelect.rb");
		return handlerAdapter;
	}

}
