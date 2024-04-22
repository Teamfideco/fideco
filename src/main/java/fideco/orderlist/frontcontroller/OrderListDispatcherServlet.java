package fideco.orderlist.frontcontroller;

import java.io.*;

import fideco.control.Controller;
import fideco.orderlist.controller.*;
import fideco.handler.HandlerAdapter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import org.apache.commons.logging.*;


public class OrderListDispatcherServlet extends HttpServlet implements Servlet {

    private static Log log = LogFactory.getLog(OrderListDispatcherServlet.class);
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        String contextPath = request.getContextPath();

        String pathURL = requestURI.substring(contextPath.length());
        log.info("매핑명 조회 - " + pathURL);

        HandlerAdapter handlerAdapter = null;

        Controller controller = null;

        if (pathURL.equals("/OrderListSelect.ol")) {
            controller = new OrderListSelectController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 조회 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderListSelectDetail.ol")) {
            controller = new OrderListSelectDetailController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 상세 조회 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderListInsertView.ol")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/orderlist/orderlist_insert.jsp");
            log.info("주문 등록 화면 뷰 확인 - " + handlerAdapter);

        } else if (pathURL.equals("/OrderListInsert.ol")) {
            controller = new OrderListInsertController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 등록 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderListUpdateView.ol")) {
            controller = new OrderListUpdateViewController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문 수정 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/OrderListUpdate.ol")) {
            controller = new OrderListUpdateController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 수정 확인"+ handlerAdapter);

        } else if (pathURL.equals("/OrderListDeleteView.ol")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/orderlist/orderlist_delete.jsp");
            log.info("주문내역 삭제 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/OrderListDelete.ol")) {
            controller = new OrderListDeleteController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 삭제 확인 " + handlerAdapter);
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        service(request, response);
    }
}