package fideco.freeboard.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.freeboard.controller.FreeboardDeleteController;
import fideco.freeboard.controller.FreeboardInsertController;
import fideco.freeboard.controller.FreeboardSelectController;
import fideco.freeboard.controller.FreeboardSelectDetailController;
import fideco.freeboard.controller.FreeboardUpdateController;
import fideco.freeboard.controller.FreeboardUpdateDetailController;
import fideco.handler.HandlerAdapter;





public class FreeBoardDispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(FreeBoardDispatchServlet.class);

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		HandlerAdapter handlerAdapter = null;
		Controller controller = null;
				
		//게시판 전체 조회
				if(pathURL.equals("/FreeboardSelect.fb")) {
					controller = new FreeboardSelectController();
					handlerAdapter = controller.execute(request, response);
					log.info("게시판 전체 조회 확인 - " + handlerAdapter);
				}
				//게시판 등록 뷰
				else if(pathURL.equals("/FreeboardInsertView.fb")) {
						handlerAdapter = new HandlerAdapter();
						handlerAdapter.setPath("/WEB-INF/view/freeboard/freeboard_insert_view.jsp");
						log.info("글 등록 화면 뷰 확인 - " + handlerAdapter);
					}
				//게시판 등록
			else if(pathURL.equals("/FreeboardInsert.fb")) {
				controller = new FreeboardInsertController();
				handlerAdapter = controller.execute(request, response);
				log.info("글 등록 확인 - " + handlerAdapter);
			}
				//게시판 수정
			else if(pathURL.equals("/FreeboardUpdate.fb")) {
				controller = new FreeboardUpdateController();
				handlerAdapter = controller.execute(request, response);
				log.info("글 수정 확인 - " + handlerAdapter);
			}
				//게시판 수정 상세 조회
			else if(pathURL.equals("/FreeboardUpdateDetail.fb")) {
		controller = new FreeboardUpdateDetailController();
		handlerAdapter = controller.execute(request, response);
		log.info("글 상세 내용 수정 확인 - " + handlerAdapter);
			}
				//게시판 상세 조회
			else if(pathURL.equals("/FreeboardSelectDetail.fb")) {
				controller = new FreeboardSelectDetailController();
				handlerAdapter = controller.execute(request, response);
				log.info("게시판 상세 조회 확인 - " + handlerAdapter);
			}
				//글 삭제 확인 뷰
			else if(pathURL.equals("/FreeboardDeleteView.fb")) {
				handlerAdapter = new HandlerAdapter( );
				handlerAdapter.setPath("/WEB-INF/view/freeboard/freeboard_delete_view.jsp");
				log.info("글 삭제 화면 뷰 확인 - " + handlerAdapter);
			}
				//게시판 삭제
			else if(pathURL.equals("/FreeboardDelete.fb")) {
				controller = new FreeboardDeleteController();
				handlerAdapter = controller.execute(request, response);
				log.info("게시판 삭제 확인 - " + handlerAdapter);
			}
				if(handlerAdapter !=null) {
				if(handlerAdapter.isRedirect()) {
					response.sendRedirect(handlerAdapter.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
					dispatcher.forward(request, response);
				}
			}
		}
}