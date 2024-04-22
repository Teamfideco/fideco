package fideco.freeboard.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.freeboard.dto.FreeboardDTO;
import fideco.handler.HandlerAdapter;

public class FreeboardSelectController implements Controller {
    private static final Log log = LogFactory.getLog(FreeboardSelectController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        
    	FreeboardDAO freeboardDAO = new FreeboardDAO();
    	FreeboardDTO freeboardDTO = new FreeboardDTO();
    	log.info(freeboardDTO);
    	
    	ArrayList<FreeboardDTO> arrayList = new ArrayList<FreeboardDTO>();
		arrayList = freeboardDAO.freeboardSelectAll();		
		log.info(arrayList);
    	
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		log.info("자유 게시판 정보 조회 - ");

            handlerAdapter.setPath("/WEB-INF/view/freeboard/freeboard_select_view.jsp");
            return handlerAdapter;

        }
}