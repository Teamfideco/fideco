package fideco.cart.service;

import java.util.ArrayList;

import fideco.cart.dto.CartDTO;

public interface CartService {
	public ArrayList<CartDTO> cartSelectAll();
	public CartDTO cartSelect(int cart_no);
	public CartDTO cartInsert(CartDTO cartDTO);
	public CartDTO cartUpdate(CartDTO cartDTO);
	public CartDTO cartDelete(int cart_no);
}
