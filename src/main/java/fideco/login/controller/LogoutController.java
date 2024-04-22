package fideco.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class LogoutController implements Controller {
	private static Log log = LogFactory.getLog(LogoutController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession( );
		String member_id = (String) httpSession.getAttribute("member_id");
		request.setAttribute("member_id", member_id);

		httpSession.invalidate( );
		Cookie[ ] cookies = request.getCookies( );
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName( ).equals("member_id")) {
					log.info(cookie.getName( ).equals("member_id"));
					// cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}

		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/login/logout.jsp");
		return handlerAdapter;
	}

}
