package fideco.delivery.frontcontroller;

import java.io.*;

import fideco.control.Controller;
import fideco.delivery.controller.*;
import fideco.handler.HandlerAdapter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import org.apache.commons.logging.*;

public class DeliveryDispatcherServlet extends HttpServlet {

    private static Log log = LogFactory.getLog(DeliveryDispatcherServlet.class);
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI( );

        String contextPath = request.getContextPath( );

        String pathURL = requestURI.substring(contextPath.length( ));
        log.info("매핑명 조회 - " + pathURL);

        HandlerAdapter handlerAdapter = null;

        Controller controller = null;

        if (pathURL.equals("/DeliverySelect.de")) {
            controller = new DeliverySelectController();
            handlerAdapter = controller.execute(request, response);
            log.info("배송 조회 확인 " + handlerAdapter);
        }

         else if (pathURL.equals("/DeliverySelectDetail.de")) {
            controller = new DeliverySelectDetailController();
            handlerAdapter = controller.execute(request,response);
            log.info("상세 배송 조회 확인 - "+handlerAdapter);

        } else if (pathURL.equals("/DeliveryInsertView.de")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_insert.jsp");
            log.info("배송 등록 화면 뷰 확인 - "+handlerAdapter);

        } else if (pathURL.equals("/DeliveryInsert.de")) {
            controller = new DeliveryInsertController();
            handlerAdapter = controller.execute(request,response);
            log.info("배송 등록 확인"+ handlerAdapter);
        }

        else if (pathURL.equals("/DeliveryUpdateView.de")) {
            controller = new DeliveryUpdateViewController();
            handlerAdapter = controller.execute(request,response);
            log.info("배송 수정 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/DeliveryUpdate.de")) {
            controller = new DeliveryUpdateController();
            handlerAdapter = controller.execute(request,response);
            log.info("배송 수정 확인 - "+handlerAdapter);

        } else if (pathURL.equals("/DeliveryDeleteView.de")){
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_delete.jsp");
            log.info("배송내역 삭제 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/DeliveryDelete.de")) {
            controller = new DeliveryDeleteController();
            handlerAdapter = controller.execute(request,response);
            log.info("배송 삭제 확인 "+handlerAdapter);
        }

        if (handlerAdapter != null){
            if (handlerAdapter.isRedirect()){
                response.sendRedirect(handlerAdapter.getPath());
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
                dispatcher.forward(request,response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }
}