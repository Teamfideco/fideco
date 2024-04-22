package fideco.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class LoginMainController implements Controller {
 
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        // 사용자가 로그인한 경우
  
 
	        
	        // 로그인 폼을 보여주는 페이지로 리턴
	        HandlerAdapter handlerAdapter = new HandlerAdapter();
	        handlerAdapter.setPath("/WEB-INF/view/login/login_main.jsp");
	        return handlerAdapter;
	    }
	
	}
