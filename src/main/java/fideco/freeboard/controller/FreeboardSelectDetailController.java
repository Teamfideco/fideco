package fideco.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.freeboard.dto.FreeboardDTO;
import fideco.handler.HandlerAdapter;

public class FreeboardSelectDetailController implements Controller {

	private static Log log = LogFactory.getLog(FreeboardSelectDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		FreeboardDAO freeboardDAO = new FreeboardDAO();
    	FreeboardDTO freeboardDTO = new FreeboardDTO();
    	
    	int num = Integer.parseInt(request.getParameter("num"));
    	freeboardDTO = freeboardDAO.freeboardSelect(num);
    	log.info("DTO 확인 - " + freeboardDTO);
    	
    	request.setAttribute("freeboardDTO", freeboardDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/freeboard/freeboard_select_detail_view.jsp");
		return handlerAdapter;
	}
}
