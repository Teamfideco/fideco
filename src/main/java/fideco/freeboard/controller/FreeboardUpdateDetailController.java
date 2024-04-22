package fideco.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.freeboard.dto.FreeboardDTO;
import fideco.handler.HandlerAdapter;


public class FreeboardUpdateDetailController implements Controller {
	private static Log log = LogFactory.getLog(FreeboardUpdateDetailController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		FreeboardDAO freeboardDAO = new FreeboardDAO();
		FreeboardDTO freeboardDTO = new FreeboardDTO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		freeboardDTO = freeboardDAO.freeboardSelect(num);
		log.info(freeboardDTO);
		request.setAttribute("freeboardDTO", freeboardDTO);
		handlerAdapter.setPath("/WEB-INF/view/freeboard/freeboard_update.jsp");
		
		return handlerAdapter;
	}

}