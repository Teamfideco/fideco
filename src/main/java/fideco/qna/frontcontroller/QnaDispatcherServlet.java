package fideco.qna.frontcontroller;

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
import fideco.qna.controller.QnaDeleteController;
import fideco.qna.controller.QnaInsertController;
import fideco.qna.controller.QnaSelectController;
import fideco.qna.controller.QnaSelectDetailController;
import fideco.qna.controller.QnaUpdateController;
import fideco.qna.controller.QnaUpdateDetailCotroller;


public class QnaDispatcherServlet extends HttpServlet {
	
	private static Log log = LogFactory.getLog(QnaDispatcherServlet.class);
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
		
		if (pathURL.equals("/QnaSelect.qb")) {
			controller = new QnaSelectController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 전체 조회 확인 -" + handlerAdapter);
		}else if (pathURL.equals("/QnaInsertView.qb")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/qna/qna_insert_view.jsp");
			log.info("글 등록 화면 뷰 확인-" + handlerAdapter);		
		}else if (pathURL.equals("/QnaInsert.qb")) {
			controller = new QnaInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 등록 확인-"+handlerAdapter);		
		}else if (pathURL.equals("/QnaUpdate.qb")) {
			controller = new QnaUpdateController();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/QnaUpdateDetail.qb")) {
			controller = new QnaUpdateDetailCotroller();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/QnaSelectDetail.qb")) {
			controller = new QnaSelectDetailController();
			handlerAdapter = controller.execute(request, response);
		}else if (pathURL.equals("/QnaDeleteView.qb")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/qna/qna_delete.jsp");
		}else if (pathURL.equals("/QnaDelete.qb")) {
			controller = new QnaDeleteController();
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
