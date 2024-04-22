package fideco.order.service;

import java.util.ArrayList;

import fideco.order.dto.OrderDTO;

public interface OrderService {
	public ArrayList<OrderDTO> orderSelectAll();
	public OrderDTO orderSelect(int order_no);
	public OrderDTO orderInsert(OrderDTO orderDTO);
	public OrderDTO orderUpdate(OrderDTO orderDTO);
	public OrderDTO orderDelete(int order_no);
}
