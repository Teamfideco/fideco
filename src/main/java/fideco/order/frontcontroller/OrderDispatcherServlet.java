package fideco.order.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.controller.OrderDeleteController;
import fideco.order.controller.OrderInsertController;
import fideco.order.controller.OrderSelectController;
import fideco.order.controller.OrderSelectDetailController;
import fideco.order.controller.OrderUpdateController;
import fideco.order.controller.OrderUpdateViewController;


public class OrderDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Log log = LogFactory.getLog(OrderDispatcherServlet.class);
       protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		
		HandlerAdapter HandlerAdapter = null;
		Controller controller = null;
		
		if (pathURL.equals("/OrderSelect.od")) {
			controller = new OrderSelectController();
			HandlerAdapter = controller.execute(request, response);
			
		} else if (pathURL.equals("/OrderSelectDetail.od")) {
			controller = new OrderSelectDetailController();
			HandlerAdapter = controller.execute(request, response);
			
		} else if (pathURL.equals("/OrderInsertView.od")) {
			HandlerAdapter = new HandlerAdapter();
			HandlerAdapter.setPath("/WEB-INF/view/order/order_insert.jsp");
			
		} else if (pathURL.equals("/OrderInsert.od")) {
			controller = new OrderInsertController();
			HandlerAdapter = controller.execute(request, response);
			
		} else if (pathURL.equals("/OrderUpdateView.od")) {
			controller = new OrderUpdateViewController();
			HandlerAdapter = controller.execute(request, response);
			
		} else if (pathURL.equals("/OrderUpdate.od")) {
			controller = new OrderUpdateController();
			HandlerAdapter = controller.execute(request, response);
			
		} else if (pathURL.equals("/OrderDeleteView.od")) {
			HandlerAdapter = new HandlerAdapter();
			HandlerAdapter.setPath("/WEB-INF/view/order/order_delete.jsp");
			
		} else if (pathURL.equals("/OrderDelete.od")) {
			controller = new OrderDeleteController();
			HandlerAdapter = controller.execute(request, response);
		}
		if (HandlerAdapter != null) {
			if (HandlerAdapter.isRedirect()) {
				response.sendRedirect(HandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(HandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
