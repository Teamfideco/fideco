package fideco.orderlist.controller;

import fideco.control.Controller;
import fideco.orderlist.DAO.OrderListDAO;
import fideco.orderlist.DTO.OrderListDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderListUpdateViewController implements Controller {
    private static Log log = LogFactory.getLog(OrderListUpdateViewController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

        String orderlist_num = request.getParameter("orderlist_num");
        log.info(orderlist_num);

        int orderlist_amount = Integer.parseInt(request.getParameter("orderlist_amount"));
        log.info(orderlist_amount);

        int orderlist_status = Integer.parseInt(request.getParameter("orderlist_status"));
        log.info(orderlist_status);

        String orderlist_date = request.getParameter("orderlist_date");
        log.info(orderlist_date);

        String  order_id = request.getParameter("order_id");
        log.info(order_id);
      

        OrderListDAO orderlistDAO = new OrderListDAO();
        OrderListDTO orderlistDTO = new OrderListDTO();

        orderlistDTO.setOrderlist_num(orderlist_num);
        orderlistDTO.setOrderlist_amount(orderlist_amount);
        orderlistDTO.setOrderlist_status(orderlist_status);
        orderlistDTO.setOrderlist_date(orderlist_date);
        orderlistDTO.setOrder_id(order_id);

        orderlistDTO = orderlistDAO.orderlistUpdate(orderlistDTO);
        log.info(orderlistDTO);

        request.setAttribute("orderlistDTO", orderlistDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();

        handlerAdapter.setPath("/WEB-INF/view/orderlist/orderlist_update_view.jsp");
        return handlerAdapter;
    }
}
