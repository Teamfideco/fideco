package fideco.freeboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.dao.FreeboardDAO;
import fideco.freeboard.dto.FreeboardDTO;
import fideco.handler.HandlerAdapter;

public class FreeboardInsertController implements Controller {
	
	private static Log log = LogFactory.getLog(FreeboardInsertController.class);
    
	@Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
      
		// 자유 게시판 데이터 액세스 객체를 생성합니다.
        FreeboardDAO freeboardDAO = new FreeboardDAO();
        // 자유 게시판 데이터 전송 객체를 생성합니다.
        FreeboardDTO freeboardDTO = new FreeboardDTO();

        boolean result = false;
		try {
			
        // 요청 파라미터로부터 자유 게시판 글 정보를 DTO에 설정합니다.
        freeboardDTO.setMember_id(request.getParameter("member_id"));
        freeboardDTO.setFreeboard_title(request.getParameter("freeboard_title"));
        freeboardDTO.setFreeboard_content(request.getParameter("freeboard_content"));
        freeboardDTO.setFreeboard_registdate(request.getParameter("freeboard_registdate"));
        // 자유 게시판 글 등록을 시도합니다.
        // freeboardDTO를 이용하여 자유 게시판 글을 등록하고 결과를 반환합니다.
       result = freeboardDAO.freeboardInsert(freeboardDTO);
       log.info("DTO 확인 - " +freeboardDTO);
       log.info("글 등록 - " +result);
       request.setAttribute("result", result);
       
        // 요청 처리 결과를 리다이렉트 방식으로 전송합니다.
        // HandlerAdapter를 생성하여 리다이렉트 설정 및 경로를 지정합니다.
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setRedirect(true); // 리다이렉트 방식을 사용합니다.
        // 글 등록에 성공하면 자유 게시판 전체 목록으로 이동합니다.
    	handlerAdapter.setPath("./FreeboardSelect.fb");
    	
    	 // 처리 결과를 반환합니다.
        return handlerAdapter;
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
        
