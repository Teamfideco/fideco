package fideco.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.dao.OrderDAO;
import fideco.order.dto.OrderDTO;

public class OrderUpdateViewController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		String product_id = request.getParameter("product_id");
		String member_id = request.getParameter("member_id");
		String cart_id = request.getParameter("cart_id");
		
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setOrder_no(order_no);
		orderDTO.setOrder_amount(order_amount);
		orderDTO.setProduct_id(product_id);
		orderDTO.setMember_id(member_id);
		orderDTO.setCart_id(cart_id);
		orderDTO = orderDAO.orderUpdate(orderDTO);
		
		request.setAttribute("orderDTO", orderDTO);
		HandlerAdapter orderHandlerAdapter = new HandlerAdapter();
		orderHandlerAdapter.setPath("/WEB-INF/view/order/order_update_view.jsp");
		return orderHandlerAdapter;
	}
	
}
