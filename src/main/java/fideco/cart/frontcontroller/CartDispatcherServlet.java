package fideco.cart.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import fideco.cart.controller.CartDeleteController;
import fideco.cart.controller.CartInsertController;
import fideco.cart.controller.CartSelectController;
import fideco.cart.controller.CartSelectDetailController;
import fideco.cart.controller.CartUpdateController;
import fideco.cart.controller.CartUpdateViewController;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class CartDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(CartDispatcherServlet.class);   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		
		HandlerAdapter HandlerAdapter = null;
		Controller controller = null;
		
		if (pathURL.equals("/CartSelect.ct")) {
			controller = new CartSelectController();
			HandlerAdapter = controller.execute(request, response);
			log.info("장바구니 조회 확인" + HandlerAdapter);
			
		} else if (pathURL.equals("/CartSelectDetail.ct")) {
			controller = new CartSelectDetailController();
			HandlerAdapter = controller.execute(request, response);
			log.info("장바구니 상세 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/CartInsertView.ct")) {
			HandlerAdapter = new HandlerAdapter();
			HandlerAdapter.setPath("/WEB-INF/view/cart/cart_insert.jsp");
			log.info("장바구니 등록 화면 뷰 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/CartInsert.ct")) {
			controller = new CartInsertController();
			HandlerAdapter = controller.execute(request, response);
			log.info("장바구니 등록 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/CartUpdateView.ct")) {
			controller = new CartUpdateViewController();
			HandlerAdapter = controller.execute(request, response);
			log.info("장바구니 수정 화면 뷰 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/CartUpdate.ct")) {
			controller = new CartUpdateController();
			HandlerAdapter = controller.execute(request, response);
			log.info("장바구니 수정 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/CartDeleteView.ct")) {
			HandlerAdapter = new HandlerAdapter();
			HandlerAdapter.setPath("/WEB-INF/view/cart/cart_delete.jsp");
			log.info("장바구니 삭제 화면 뷰 확인 - " + HandlerAdapter);
		} else if (pathURL.equals("/CartDelete.ct")) {
			controller = new CartDeleteController();
			HandlerAdapter = controller.execute(request, response);
			log.info("부서 삭제 확인 - " + HandlerAdapter);
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
