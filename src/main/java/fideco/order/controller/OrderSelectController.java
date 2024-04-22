package fideco.order.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.order.dao.OrderDAO;
import fideco.order.dto.OrderDTO;

public class OrderSelectController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		ArrayList<OrderDTO> arrayList = new ArrayList<OrderDTO>();
		arrayList = orderDAO.orderSelectAll();
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter orderHandlerAdapter = new HandlerAdapter();
		orderHandlerAdapter.setPath("/WEB-INF/view/order/order_select_view.jsp");
		return orderHandlerAdapter;
	}

}
