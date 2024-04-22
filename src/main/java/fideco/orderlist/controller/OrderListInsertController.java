package fideco.orderlist.controller;

import fideco.control.Controller;
import fideco.orderlist.DAO.OrderListDAO;
import fideco.orderlist.DTO.OrderListDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderListInsertController implements Controller {
    private static Log log = LogFactory.getLog(OrderListInsertController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
  
        // 요청 파라미터에서 받은 데이터를 가져옴
    	
    	String orderlist_num = request.getParameter("orderlist_num");
    	int orderlist_amount = Integer.parseInt(request.getParameter("orderlist_amount"));
        
        int orderlist_status = Integer.parseInt(request.getParameter("orderlist_status"));
        
        String orderlist_date = request.getParameter("orderlist_date");
        
        String order_id = request.getParameter("order_id");
     
        // OrderDTO 객체에 입력된 데이터를 설정
        OrderListDTO orderlistDTO = new OrderListDTO();
        orderlistDTO.setOrderlist_num(orderlist_num);
        orderlistDTO.setOrderlist_amount(orderlist_amount);
        orderlistDTO.setOrderlist_status(orderlist_status);
        orderlistDTO.setOrderlist_date(orderlist_date);
        orderlistDTO.setOrder_id(order_id);
      
        // OrderDAO 객체를 생성하고 입력된 주문 정보를 등록
        OrderListDAO orderlistDAO = new OrderListDAO();
        orderlistDTO = orderlistDAO.orderlistInsert(orderlistDTO);

        // 등록된 주문 정보를 로그에 출력
        log.info("등록된 주문 정보: " + orderlistDTO);

        // 등록된 주문 정보를 request 속성에 설정하여 View로 전달
        request.setAttribute("orderlistDTO", orderlistDTO);

        // HandlerAdapter 객체를 생성하여 View의 경로를 설정하여 반환
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WEB-INF/view/orderlist/orderlist_insert_view.jsp");
        return handlerAdapter;
    }
}
