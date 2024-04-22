package fideco.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.dao.OrderDAO;
import fideco.order.dto.OrderDTO;

public class OrderUpdateController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		System.out.println(order_no);
		
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO = orderDAO.orderSelect(order_no);
		request.setAttribute("orderDTO", orderDTO);
		HandlerAdapter orderHandlerAdapter = new HandlerAdapter();
		
		orderHandlerAdapter.setPath("/WEB-INF/view/order/order_update.jsp");
		return orderHandlerAdapter;
	}
	
}
