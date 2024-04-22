package fideco.payment.dao;

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

import fideco.payment.dto.PaymentDTO;
import fideco.payment.service.PaymentService;

// DAO는 DB에 접근하는 객체를 생성해서 DB에 접근해서 데이터 조회,삽입,수정,삭제 등.
public class PaymentDAO implements PaymentService {
	private static Log log = LogFactory.getLog(PaymentDAO.class);

	@Override
	public ArrayList<PaymentDTO> paymentSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<PaymentDTO> arrayList = new ArrayList<PaymentDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select payment_id, payment_amount, payment_date, payment_method from payment ";
			sql += " order by payment_id desc ";
			log.info("select sql문 확인 " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PaymentDTO paymentDTO = new PaymentDTO();
				paymentDTO.setPayment_id(resultSet.getString("payment_id"));
				log.info("1번째 로그 " + paymentDTO);
				paymentDTO.setPayment_amount(resultSet.getInt("payment_amount"));
				log.info("2번째 로그 " + paymentDTO);
				paymentDTO.setPayment_date(resultSet.getString("payment_date"));
				log.info("3번째 로그 " + paymentDTO);
				paymentDTO.setPayment_method(resultSet.getString("payment_method"));
				arrayList.add(paymentDTO);
				log.info("arraylist :  " + arrayList);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 결제정보가 없습니다. 결제정보를 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("전체 결제정보 조회 실패 - " + e);
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
	public PaymentDTO paymentSelect(String payment_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PaymentDTO paymentDTO = new PaymentDTO();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select payment_id,payment_amount, payment_date, payment_method from payment";
			sql += " where payment_id = ?";
			log.info("selectdetail sql문 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, payment_id);
			resultSet = preparedStatement.executeQuery();
			log.info("리절트 셋 : " + resultSet);
			while (resultSet.next()) {
				paymentDTO.setPayment_id(resultSet.getString("payment_id"));
				paymentDTO.setPayment_amount(resultSet.getInt("payment_amount"));
				paymentDTO.setPayment_date(resultSet.getString("payment_date"));
				paymentDTO.setPayment_method(resultSet.getString("payment_method"));
				log.info("페이먼트디티오 : " + paymentDTO);
			}
		} catch (Exception e) {
			log.info("특정 결제 정보 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return paymentDTO;
	}

	@Override
	public PaymentDTO paymentInsert(PaymentDTO paymentDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into payment(payment_id, payment_amount, payment_date, payment_method)";
			sql += " values (?,?,?,?)";
			log.info("sql 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paymentDTO.getPayment_id());
			preparedStatement.setInt(2, paymentDTO.getPayment_amount());
			preparedStatement.setString(3, paymentDTO.getPayment_date());
			preparedStatement.setString(4, paymentDTO.getPayment_method());

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("결제정보 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return paymentDTO;
	}

	@Override
	public PaymentDTO paymentUpdate(PaymentDTO paymentDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update payment set payment_amount=?, payment_date=?, payment_method=?";
			sql += " where payment_id=?";
			log.info("sql문 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, paymentDTO.getPayment_amount());
			log.info("---1----");
			preparedStatement.setString(2, paymentDTO.getPayment_date());
			log.info("---2----");
			preparedStatement.setString(3, paymentDTO.getPayment_method());
			log.info("---3----");
			preparedStatement.setString(4, paymentDTO.getPayment_id());
			log.info("---4----");

			int count = preparedStatement.executeUpdate();
			log.info("count:"+count);
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("결제 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return paymentDTO;

	}

	@Override
	public PaymentDTO paymentDelete(String payment_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from payment ";
			sql += " where payment_id = ?";
			log.info("delete sql문 확인 = " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, payment_id);

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("결제 정보 삭제 실패 - " + e);
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
