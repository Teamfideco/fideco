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

public class CartInsertController implements Controller{
private static Log log = LogFactory.getLog(CartInsertController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cart_no = Integer.parseInt(request.getParameter("cart_no"));
		log.info(cart_no);
		
		String product_id = request.getParameter("product_id");
		log.info(product_id);
		
		int order_amount = Integer.parseInt(request.getParameter("order_amount"));
		log.info(order_amount);
		
		String member_id = request.getParameter("member_id");
		log.info(member_id);
		
		String cart_id = request.getParameter("cart_id");
		log.info(cart_id);
		
		CartDAO cartDAO = new CartDAO();
		CartDTO cartDTO = new CartDTO();
		ArrayList<CartDTO> arrayList = new ArrayList<CartDTO>();
		arrayList = cartDAO.cartSelectAll();
		log.info(arrayList);
		
		request.setAttribute("arrayList", arrayList);
		cartDTO.setCart_no(cart_no);
		cartDTO.setProduct_id(product_id);
		cartDTO.setOrder_amount(order_amount);
		cartDTO.setMember_id(member_id);
		cartDTO.setCart_id(cart_id);
		cartDTO = cartDAO.cartInsert(cartDTO);
		log.info(cartDTO);
		
		request.setAttribute("cartDTO", cartDTO);
		log.info("부서 정보 등록");
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/cart/cart_insert_view.jsp");
		return HandlerAdapter;
	}
	
}
