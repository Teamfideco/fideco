package fideco.qna.dao;

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

import fideco.qna.dto.QnaDTO;
import fideco.qna.service.QnaService;

public class QnaDAO implements QnaService {
	
	private static Log log = LogFactory.getLog(QnaDAO.class);


	@Override
	public ArrayList<QnaDTO> qnaSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<QnaDTO> arrayList = new ArrayList<QnaDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select num, qna_id, qna_title, qna_content, to_char(Qna_regisdate, 'yyyy-mm-dd') Qna_regisdate from qna";
			log.info("SQL 확인-" + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				QnaDTO qnaDTO = new QnaDTO();		
				qnaDTO.setNum(resultSet.getInt("num"));
				qnaDTO.setQna_id(resultSet.getString("qna_id"));
				qnaDTO.setQna_title(resultSet.getString("qna_title"));
				qnaDTO.setQna_content(resultSet.getString("qna_content"));
				qnaDTO.setQna_regisdate(resultSet.getString("qna_regisdate"));
				arrayList.add(qnaDTO);				
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
	public QnaDTO qnaSelect(int num) {
		QnaDTO qnaDTO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select num, qna_id, qna_title, qna_content, qna_regisdate from qna";
			sql += " where num=?";
			log.info("SQL 확인 -" +sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				qnaDTO = new QnaDTO();
				qnaDTO.setNum(resultSet.getInt("num"));
				qnaDTO.setQna_id(resultSet.getString("qna_id"));
				qnaDTO.setQna_title(resultSet.getString("qna_title"));
				qnaDTO.setQna_content(resultSet.getString("qna_content"));
				qnaDTO.setQna_regisdate(resultSet.getString("qna_regisdate"));
			}
			return qnaDTO;
			
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
	public boolean qnaInsert(QnaDTO qnaDTO) {
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
			
			sql = "select max(num) from qna";
			log.info("SQL 확인- " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				num = resultSet.getInt(1) + 1;
			}else {
				num = 1;
			}
			preparedStatement.close();				
			
			sql = "insert into qna (num , qna_id, qna_title, qna_content, qna_regisdate)";
			sql += " values(?, ?, ?, ?, sysdate)";
			log.info("sql 확인-" + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, qnaDTO.getQna_id());
			preparedStatement.setString(3, qnaDTO.getQna_title());
			preparedStatement.setString(4, qnaDTO.getQna_content());
//			preparedStatement.setString(5, qnaDTO.getQna_regisdate());
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
	public boolean qnaUpdate(QnaDTO qnaDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "update qna set qna_id=?, qna_title=?, qna_content=? ";
			sql += " where num=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, qnaDTO.getQna_id( ));
			preparedStatement.setString(2, qnaDTO.getQna_title( ));
			preparedStatement.setString(3, qnaDTO.getQna_content( ));
			preparedStatement.setInt(4, qnaDTO.getNum());
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
	public boolean qnaDelete(int num) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from qna where num=?";
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
