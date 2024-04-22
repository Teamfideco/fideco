package fideco.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import fideco.cart.dao.CartDAO;
import fideco.cart.dto.CartDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class CartSelectDetailController implements Controller{
private static Log log = LogFactory.getLog(CartSelectDetailController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cart_no = Integer.parseInt(request.getParameter("cart_no"));
		log.info(cart_no);
		
		CartDAO cartDAO = new CartDAO();
		CartDTO cartDTO = new CartDTO();
		cartDTO = cartDAO.cartSelect(cart_no);
		log.info(cartDTO);
		
		request.setAttribute("cartDTO", cartDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("특정 부서 조회");
		
		HandlerAdapter.setPath("/WEB-INF/view/cart/cart_select_detail_view.jsp");
		return HandlerAdapter;
	}
	
}
