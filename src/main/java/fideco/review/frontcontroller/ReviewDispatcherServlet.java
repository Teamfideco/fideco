package fideco.review.frontcontroller;

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
import fideco.review.controller.ReviewDeleteController;
import fideco.review.controller.ReviewInsertController;
import fideco.review.controller.ReviewSelectController;
import fideco.review.controller.ReviewSelectDetailController;
import fideco.review.controller.ReviewUpdateController;
import fideco.review.controller.ReviewUpdateDetailCotroller;


public class ReviewDispatcherServlet extends HttpServlet {
	
	private static Log log = LogFactory.getLog(ReviewDispatcherServlet.class);
	private static final long serialVersionUID = 1L;	

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
		HandlerAdapter handlerAdapter = null;
		Controller controller = null;
		
		if (pathURL.equals("/ReviewSelect.rb")) {
			controller = new ReviewSelectController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 전체 조회 확인 -" + handlerAdapter);
		}else if (pathURL.equals("/ReviewInsertView.rb")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/review/review_insert_view.jsp");
			log.info("글 등록 화면 뷰 확인-" + handlerAdapter);		
		}else if (pathURL.equals("/ReviewInsert.rb")) {
			controller = new ReviewInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 등록 확인-"+handlerAdapter);		
		}else if (pathURL.equals("/ReviewUpdate.rb")) {
			controller = new ReviewUpdateController();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/ReviewUpdateDetail.rb")) {
			controller = new ReviewUpdateDetailCotroller();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/ReviewSelectDetail.rb")) {
			controller = new ReviewSelectDetailController();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/ReviewDeleteView.rb")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/review/review_delete.jsp");
		}else if (pathURL.equals("/ReviewDelete.rb")) {
			controller = new ReviewDeleteController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 삭제 확인 -" + handlerAdapter);
		}
		
		
		if(handlerAdapter != null) {
			if(handlerAdapter.isRedirect( )) {
				response.sendRedirect(handlerAdapter.getPath( ));
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath( ));
				dispatcher.forward(request, response);
			}
		}
	}
}
