package fideco.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.handler.HandlerAdapter;

public interface Controller {
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}
