package fideco.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.cart.dao.CartDAO;
import fideco.cart.dto.CartDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class CartDeleteController implements Controller{
private static Log log = LogFactory.getLog(CartDeleteController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cart_no = Integer.parseInt(request.getParameter("cart_no"));
		log.info(cart_no);
		
		CartDAO cartDAO = new CartDAO();
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCart_no(cart_no);;
		request.setAttribute("cartDTO", cartDTO);
		cartDTO = cartDAO.cartDelete(cart_no);
		log.info(cartDTO);
		
		HandlerAdapter cartHandlerAdapter = new HandlerAdapter();
		cartHandlerAdapter.setPath("/WEB-INF/view/cart/cart_delete_view.jsp");
		return cartHandlerAdapter;
	}
	
}
