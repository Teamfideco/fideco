package fideco.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.order.dto.OrderDTO;
import fideco.order.service.OrderService;

public class OrderDAO implements OrderService{
private static Log log = LogFactory.getLog(OrderDAO.class);
	@Override
	public ArrayList<OrderDTO> orderSelectAll() {
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		ArrayList<OrderDTO> arrayList = new ArrayList<OrderDTO>();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select order_no, order_amount, product_id, member_id, cart_id from torder order by order_no asc ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setOrder_no(resultSet.getInt("order_no"));
				orderDTO.setOrder_amount(resultSet.getInt("order_amount"));
				orderDTO.setProduct_id(resultSet.getString("product_id"));
				orderDTO.setMember_id(resultSet.getString("member_id"));
				orderDTO.setCart_id(resultSet.getString("cart_id"));
				arrayList.add(orderDTO);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 주문내역이 없습니다. 주문내역을 등록해주세요.");
			}
		} catch (Exception e) {
			log.info("전체 주문내역 조회 실패" + e);
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
	public OrderDTO orderSelect(int order_no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		OrderDTO orderDTO = new OrderDTO();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select order_no, order_amount, product_id, member_id, cart_id from torder ";
			sql += " where order_no = ? ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, order_no);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				orderDTO.setOrder_no(resultSet.getInt("order_no"));
				orderDTO.setOrder_amount(resultSet.getInt("order_amount"));
				orderDTO.setProduct_id(resultSet.getString("product_id"));
				orderDTO.setMember_id(resultSet.getString("member_id"));
				orderDTO.setCart_id(resultSet.getString("cart_id"));
			}
		} catch (Exception e) {
			log.info("특정 주문내역 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderDTO;
	}

	@Override
	public OrderDTO orderInsert(OrderDTO orderDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into torder (order_no, order_amount, product_id, member_id, cart_id )";
			sql += " values (torder_seq.nextval, ?, ?, ?, ?)";
			log.info("SQL확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderDTO.getOrder_amount());
			preparedStatement.setString(2, orderDTO.getProduct_id());
			preparedStatement.setString(3, orderDTO.getMember_id());
			preparedStatement.setString(4, orderDTO.getCart_id());
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("주문정보 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return orderDTO;
	}

	@Override
	public OrderDTO orderUpdate(OrderDTO orderDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update torder set order_amount = ?, product_id = ?, member_id = ?, cart_id = ? ";
			sql += " where order_no = ?";
			log.info("SQL 확인 -" + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderDTO.getOrder_amount());
			preparedStatement.setString(2, orderDTO.getProduct_id());
			preparedStatement.setString(3, orderDTO.getMember_id());
			preparedStatement.setString(4, orderDTO.getCart_id());
			preparedStatement.setInt(5, orderDTO.getOrder_no());
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("주문정보 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderDTO;
	}

	@Override
	public OrderDTO orderDelete(int order_no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from torder ";
			sql += " where order_no = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, order_no);
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("주문내역 삭제 실패 - " + e);
		} finally {
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
