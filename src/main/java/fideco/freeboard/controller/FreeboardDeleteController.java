package fideco.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.handler.HandlerAdapter;


public class FreeboardDeleteController implements Controller {
	private static Log log = LogFactory.getLog(FreeboardDeleteController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		boolean result = false;
		int num = Integer.parseInt(request.getParameter("num"));
		FreeboardDAO freeboardDAO = new FreeboardDAO();
		
		result = freeboardDAO.freeboardDelete(num);
		log.info("게시글 삭제 - "  + result);
		
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./FreeboardSelect.fb");
		return handlerAdapter;

	}

}
