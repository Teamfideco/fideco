package fideco.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.freeboard.dto.FreeboardDTO;
import fideco.handler.HandlerAdapter;



public class FreeboardUpdateController implements Controller {
	
	private static Log log = LogFactory.getLog(FreeboardUpdateController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		FreeboardDAO freeboardDAO = new FreeboardDAO();
		FreeboardDTO freeboardDTO = new FreeboardDTO();
		boolean result = false;
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			freeboardDTO.setNum(num);
			freeboardDTO.setMember_id(request.getParameter("member_id"));
			freeboardDTO.setFreeboard_title(request.getParameter("freeboard_title"));
			freeboardDTO.setFreeboard_content(request.getParameter("freeboard_content"));
			freeboardDTO.setFreeboard_registdate(request.getParameter("freeboard_registdate"));
			
			result = freeboardDAO.freeboardUpdate(freeboardDTO);
			
			log.info("게시글 수정 - " + result);
			handlerAdapter.setRedirect(true);
			handlerAdapter.setPath("./FreeboardSelectDetail.fb?num=" + freeboardDTO.getNum());
			return handlerAdapter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
