package fideco.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.dao.OrderDAO;
import fideco.order.dto.OrderDTO;

public class OrderDeleteController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setOrder_no(order_no);
		request.setAttribute("orderDTO", orderDTO);
		
		orderDTO = orderDAO.orderDelete(order_no);
		
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/order/order_delete_view.jsp");
		return HandlerAdapter;
	}


	
}
