package fideco.cart.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.cart.dao.CartDAO;
import fideco.cart.dto.CartDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class CartSelectController implements Controller{
private static Log log = LogFactory.getLog(CartSelectController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		CartDAO cartDAO = new CartDAO();
		CartDTO cartDTO = new CartDTO();
		log.info(cartDTO);
		
		ArrayList<CartDTO> arrayList = new ArrayList<CartDTO>();
		arrayList = cartDAO.cartSelectAll();
		log.info(arrayList);
		
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("장바구니 정보 조회");
		HandlerAdapter.setPath("/WEB-INF/view/cart/cart_select_view.jsp");
		return HandlerAdapter;
	}
	
}
