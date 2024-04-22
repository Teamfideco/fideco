package fideco.payment.frontcontroller;

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
import fideco.payment.controller.PaymentDeleteController;
import fideco.payment.controller.PaymentInsertController;
import fideco.payment.controller.PaymentSelectController;
import fideco.payment.controller.PaymentSelectDetailController;
import fideco.payment.controller.PaymentUpdateController;
import fideco.payment.controller.PaymentUpdateViewController;

@WebServlet("/PaymentDispatcherServlet")
public class PaymentDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(PaymentDispatcherServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());

		HandlerAdapter HandlerAdapter = null; // 객체 처리 후 모델과 뷰에 반환
		Controller controller = null; // 공통 기능 서블릿 메소드 설정

		// 결제 정보 등록할 뷰의 매핑명 설정
		if (pathURL.equals("/PaymentInsertView.py")) {
			HandlerAdapter = new HandlerAdapter();
			HandlerAdapter.setPath("/WEB-INF/view/payment/payment_insert_view.jsp");
			log.info("결제 정보 등록 화면 뷰 확인 - " + HandlerAdapter);
		}
		// 결제 정보 등록 매핑명 설정
		else if (pathURL.equals("/PaymentInsert.py")) {
			controller = new PaymentInsertController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 등록 확인 - " + HandlerAdapter);

		} else if (pathURL.equals("/PaymentSelectAll.py")) {
			controller = new PaymentSelectController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 전체 조회 확인 - " + HandlerAdapter);

		} else if (pathURL.equals("/PaymentSelectDetail.py")) {
			controller = new PaymentSelectDetailController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 상세 조회 확인 - " + HandlerAdapter);

		} else if (pathURL.equals("/PaymentUpdate.py")) {
			controller = new PaymentUpdateController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 수정 확인 - " + HandlerAdapter);

		} else if (pathURL.equals("/PaymentUpdateView.py")) {
			controller = new PaymentUpdateViewController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 수정 화면 뷰 확인 - " + HandlerAdapter);

		}else if (pathURL.equals("/PaymentDeleteView.py")) {
				HandlerAdapter = new HandlerAdapter();
				HandlerAdapter.setPath("/WEB-INF/view/payment/payment_delete.jsp");
				log.info("결제 정보 삭제 화면 뷰 확인 - " + HandlerAdapter);
			
		} else if (pathURL.equals("/PaymentDelete.py")) {
			controller = new PaymentDeleteController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 정보 삭제 확인 - " + HandlerAdapter);
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
