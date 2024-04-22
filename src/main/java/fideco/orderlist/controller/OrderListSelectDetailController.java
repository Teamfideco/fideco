package fideco.orderlist.controller;

import fideco.control.Controller;
import fideco.orderlist.DAO.OrderListDAO;
import fideco.orderlist.DTO.OrderListDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderListSelectDetailController implements Controller {
   private static Log log = LogFactory.getLog(OrderListSelectDetailController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        String orderlist_num = request.getParameter("orderlist_num");
        log.info(orderlist_num);

        OrderListDTO orderlistDTO = new OrderListDTO();
        OrderListDAO orderlistDAO = new OrderListDAO();

        orderlistDTO = orderlistDAO.orderlistSelect(orderlist_num);
        log.info(orderlistDTO);

        request.setAttribute("orderlistDTO",orderlistDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("특정 주문내역 조회");

        handlerAdapter.setPath("/WEB-INF/view/orderlist/orderlist_select_detail_view.jsp");

        return handlerAdapter;
    }
}
