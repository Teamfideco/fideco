package fideco.review.dao;

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

import fideco.review.dto.ReviewDTO;
import fideco.review.service.ReviewService;

public class ReviewDAO implements ReviewService {
	
	private static Log log = LogFactory.getLog(ReviewDAO.class);


	@Override
	public ArrayList<ReviewDTO> reviewSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ReviewDTO> arrayList = new ArrayList<ReviewDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select num, review_id, review_title, review_content, to_char(review_regisdate, 'yyyy-mm-dd') review_regisdate from review";
			log.info("SQL 확인-" + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ReviewDTO reviewDTO = new ReviewDTO();	
				reviewDTO.setNum(resultSet.getInt("num"));
				reviewDTO.setReview_id(resultSet.getString("review_id"));
				reviewDTO.setReview_title(resultSet.getString("review_title"));
				reviewDTO.setReview_content(resultSet.getString("review_content"));
				reviewDTO.setReview_regisdate(resultSet.getString("review_regisdate"));
				arrayList.add(reviewDTO);				
			}
			return arrayList;
			
		} catch (Exception e) {
			log.info("글 목록보기 실패 - "+e);
		}finally {
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
	public ReviewDTO reviewSelect(int num) {
		ReviewDTO reviewDTO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select num, review_id, review_title, review_content, review_regisdate from review";
			sql += " where num=?";
			log.info("SQL 확인 -" +sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				reviewDTO = new ReviewDTO();
				reviewDTO.setNum(resultSet.getInt("num"));
				reviewDTO.setReview_id(resultSet.getString("review_id"));
				reviewDTO.setReview_title(resultSet.getString("review_title"));
				reviewDTO.setReview_content(resultSet.getString("review_content"));
				reviewDTO.setReview_regisdate(resultSet.getString("review_regisdate"));
			}
			return reviewDTO;
			
		} catch (Exception e) {
			log.info("글 내용 보기 실패-" + e);
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return null;
	}
	

	@Override
	public boolean reviewInsert(ReviewDTO reviewDTO) {
		int num = 0;
		 String sql = "";
		 int result = 0;		
		 
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 ResultSet resultSet = null;
		 
		 try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();		
			
			sql = "select max(num) from review";
			log.info("SQL 확인- " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				num = resultSet.getInt(1) + 1;
			}else {
				num = 1;
			}
			preparedStatement.close();				
			
			sql = "insert into review (num , review_id, review_title, review_content, review_regisdate)";
			sql += " values(?, ?, ?, ?, sysdate)";
			log.info("sql 확인-" + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, reviewDTO.getReview_id());
			preparedStatement.setString(3, reviewDTO.getReview_title());
			preparedStatement.setString(4, reviewDTO.getReview_content());

			result = preparedStatement.executeUpdate();
			if (result == 0) {
				return false;
			} return true;
		} catch (Exception e) {
			log.info("글 등록 실패-"+ e);
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		 
		return false;
	}

	@Override
	public boolean reviewUpdate(ReviewDTO reviewDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "update review set review_id=?, review_title=?, review_content=? ";
			sql += " where num=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reviewDTO.getReview_id( ));
			preparedStatement.setString(2, reviewDTO.getReview_title( ));
			preparedStatement.setString(3, reviewDTO.getReview_content( ));
			preparedStatement.setInt(4, reviewDTO.getNum());
			preparedStatement.executeUpdate( );
			
			return true;

		} catch(Exception e) {
			log.info("글 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close( );
				connection.close( );
			} catch(SQLException e) {
				e.printStackTrace( );
			}
		}
		return false;
	}

	@Override
	public boolean reviewDelete(int num) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from review where num=?";
			log.info("SQL del -" + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			result = preparedStatement.executeUpdate();
			
			if (result == 0) {
				return false;
			}
		} catch (Exception e) {
			log.info("글 삭제 실패"+e);
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return false;
	}

	}


