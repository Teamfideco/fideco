package fideco.order.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.dao.OrderDAO;
import fideco.order.dto.OrderDTO;

public class OrderInsertController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		String product_id = request.getParameter("product_id");
		String member_id = request.getParameter("member_id");
		String cart_id = request.getParameter("cart_id");
		
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		ArrayList<OrderDTO> arrayList = new ArrayList<OrderDTO>();
		arrayList = orderDAO.orderSelectAll();
		
		request.setAttribute("arrayList", arrayList);
		orderDTO.setOrder_amount(order_amount);;
		orderDTO.setProduct_id(product_id);
		orderDTO.setMember_id(member_id);
		orderDTO.setCart_id(cart_id);
		orderDTO = orderDAO.orderInsert(orderDTO);
		
		request.setAttribute("orderDTO", orderDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/order/order_insert_view.jsp");
		return HandlerAdapter;
	}

}
