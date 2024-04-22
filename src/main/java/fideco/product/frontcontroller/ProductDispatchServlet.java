package fideco.product.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.controller.ProductDeleteController;
import fideco.product.controller.ProductInsertController;
import fideco.product.controller.ProductSelectController;
import fideco.product.controller.ProductSelectDetailController;
import fideco.product.controller.ProductUpdateController;
import fideco.product.controller.ProductUpdateViewController;


public class ProductDispatchServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(ProductDispatchServlet.class);

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String pathURL = requestURI.substring(contextPath.length());

        log.info("매핑명 조회 - " + pathURL);

        HandlerAdapter handlerAdapter = null;
        Controller controller = null;

        // 상품 조회 매핑 설정
        if (pathURL.equals("/ProductSelect.pd")) {
            controller = new ProductSelectController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 조회 확인 - " + handlerAdapter);
        }
        // 상품 상세 조회 매핑 설정
        else if (pathURL.equals("/ProductSelectDetail.pd")) {
            controller = new ProductSelectDetailController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 상세 조회 확인 - " + handlerAdapter);
        }
        // 상품 등록 뷰 매핑 설정
        else if (pathURL.equals("/ProductInsertView.pd")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/product/product_insert_view.jsp");
            log.info("상품 등록 화면 뷰 확인 - " + handlerAdapter);
        }
        // 상품 정보 등록 매핑 설정
        else if (pathURL.equals("/ProductInsert.pd")) {
            controller = new ProductInsertController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 등록 확인 - " + handlerAdapter);
        }
        // 상품 수정 뷰 매핑 설정
        else if (pathURL.equals("/ProductUpdateView.pd")) {
            controller = new ProductUpdateViewController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 수정 화면 뷰 확인 - " + handlerAdapter);
        }
        // 상품 정보 수정 매핑 설정
        else if (pathURL.equals("/ProductUpdate.pd")) {
            controller = new ProductUpdateController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 수정 확인 - " + handlerAdapter);
        }
        // 상품 삭제 뷰 매핑 설정
        else if (pathURL.equals("/ProductDeleteView.pd")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/product/product_delete.jsp");
            log.info("상품 삭제 화면 뷰 확인 - " + handlerAdapter);
        }
        // 상품 정보 삭제 매핑 설정
        else if (pathURL.equals("/ProductDelete.pd")) {
            controller = new ProductDeleteController();
            handlerAdapter = controller.execute(request, response);
            log.info("상품 삭제 확인 - " + handlerAdapter);
        }

        if (handlerAdapter != null) {
            if (handlerAdapter.isRedirect()) {
                response.sendRedirect(handlerAdapter.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
                dispatcher.forward(request, response);
            }
        }
    }
}
