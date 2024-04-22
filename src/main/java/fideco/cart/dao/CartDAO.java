package fideco.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import fideco.cart.dto.CartDTO;
import fideco.cart.service.CartService;

public class CartDAO implements CartService{
	private static Log log = LogFactory.getLog(CartDAO.class);
	@Override
	public ArrayList<CartDTO> cartSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<CartDTO> arrayList = new ArrayList<CartDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select cart_no, product_id, order_amount, member_id, cart_id from cart";
			log.info("SQL확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CartDTO cartDTO = new CartDTO();
				cartDTO.setCart_no(resultSet.getInt("cart_no"));
				cartDTO.setProduct_id(resultSet.getString("product_id"));
				cartDTO.setOrder_amount(resultSet.getInt("order_amount"));
				cartDTO.setMember_id(resultSet.getString("member_id"));
				cartDTO.setCart_id(resultSet.getString("cart_id"));
				arrayList.add(cartDTO);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 장바구니 상품이 없습니다. 등록해 주세요.");
			}
		} catch (Exception e) {
			log.info("장바구니 전체 조회 실패" + e);
			
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public CartDTO cartSelect(int cart_no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CartDTO cartDTO = new CartDTO();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select cart_no, product_id, order_amount, member_id, cart_id from cart ";
			sql += " where cart_no = ?";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart_no);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				cartDTO.setCart_no(resultSet.getInt("cart_no"));
				cartDTO.setProduct_id(resultSet.getString("product_id"));
				cartDTO.setOrder_amount(resultSet.getInt("order_amount"));
				cartDTO.setMember_id(resultSet.getString("member_id"));
				cartDTO.setCart_id(resultSet.getString("cart_id"));
			}
		} catch (Exception e) {
			log.info("특정 부서 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartDTO;
	}

	@Override
	public CartDTO cartInsert(CartDTO cartDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into cart (cart_no, product_id, order_amount, member_id, cart_id)";
			sql += " values ( ?, ?, ?, ?, ? )";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartDTO.getCart_no());
			preparedStatement.setString(2, cartDTO.getProduct_id());
			preparedStatement.setInt(3, cartDTO.getOrder_amount());
			preparedStatement.setString(4, cartDTO.getMember_id());
			preparedStatement.setString(5, cartDTO.getCart_id());
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartDTO;
	}

	@Override
	public CartDTO cartUpdate(CartDTO cartDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update cart set product_id = ?, order_amount = ?, member_id = ?, cart_id = ? ";
			sql += " where cart_no = ?";
			log.info("SQL확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cartDTO.getProduct_id());
			preparedStatement.setInt(2, cartDTO.getOrder_amount());
			preparedStatement.setString(3, cartDTO.getMember_id());
			preparedStatement.setString(4, cartDTO.getCart_id());
			preparedStatement.setInt(5, cartDTO.getCart_no());
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartDTO;
	}

	@Override
	public CartDTO cartDelete(int cart_no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from cart ";
			sql += " where cart_no = ?";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart_no);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 삭제 실패 - " + e);
		}	finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
