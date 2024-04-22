package fideco.orderlist.controller;

import fideco.control.Controller;
import fideco.orderlist.DAO.OrderListDAO;
import fideco.orderlist.DTO.OrderListDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderListDeleteController implements Controller {
    private static Log log = LogFactory.getLog(OrderListDeleteController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
       String orderlist_num = request.getParameter("orderlist_num");
       log.info(orderlist_num);

       OrderListDTO orderlistDTO = new OrderListDTO();
       OrderListDAO orderlistDAO = new OrderListDAO();

       orderlistDTO.setOrderlist_num(orderlist_num);
        request.setAttribute("orderDTO",orderlistDTO);

        orderlistDTO = orderlistDAO.orderlistDelete(orderlist_num);
        log.info(orderlistDTO);

        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("./WEB-INF/view/orderlist/orderlist_delete_view.jsp");
        return handlerAdapter;
    }
}
