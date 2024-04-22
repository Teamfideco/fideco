package fideco.freeboard.dao;

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

import fideco.freeboard.dto.FreeboardDTO;
import fideco.freeboard.service.FreeboardService;


public class FreeboardDAO implements FreeboardService {
	 private static Log log = LogFactory.getLog(FreeboardDAO.class);

	@Override
	public ArrayList<FreeboardDTO> freeboardSelectAll() {
		 Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    ArrayList<FreeboardDTO> arrayList = new ArrayList<FreeboardDTO>( );
		    try {
		        // 데이터 소스를 찾아 데이터베이스에 연결합니다.
		        Context context = new InitialContext();
		        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		        connection = dataSource.getConnection();
		        
		        // SQL 쿼리를 구성하여 페이징 처리된 레코드를 조회합니다.
		        String sql = "select num, member_id, freeboard_title, freeboard_content, to_char(freeboard_registdate, 'yyyy-mm-dd') freeboard_registdate from freeboard";
				log.info("SQL 전체글 보기 확인-" + sql);
				 // PreparedStatement 객체를 생성하고 파라미터를 설정합니다.
		        preparedStatement = connection.prepareStatement(sql);
		        // 쿼리를 실행하고 결과를 ResultSet 객체로 받습니다.
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		        	FreeboardDTO freeboardDTO = new FreeboardDTO();
		        	freeboardDTO.setNum(resultSet.getInt("num"));
		            freeboardDTO.setMember_id(resultSet.getString("member_id"));
		            freeboardDTO.setFreeboard_title(resultSet.getString("freeboard_title"));
		            freeboardDTO.setFreeboard_content(resultSet.getString("freeboard_content"));
		            freeboardDTO.setFreeboard_registdate(resultSet.getString("freeboard_registdate"));
		        	
		            arrayList.add(freeboardDTO);
		        }
		        return arrayList;
		        
		    } catch(Exception e) {
		        // 예외 발생 시 로그를 출력합니다.
		        log.info("글 목록보기 실패 - " + e);
		    } finally {
		        // 자원을 해제합니다.
		        try {
		            resultSet.close();
		            preparedStatement.close();
		            connection.close();
		        } catch(SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    // 예외가 발생했을 때 null을 반환합니다.
		    return arrayList;
		}


	@Override
	public FreeboardDTO freeboardSelect(int num) {
		FreeboardDTO freeboardDTO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select num, member_id, freeboard_title, freeboard_content, freeboard_registdate from freeboard where num=?";
			log.info("SQL 상세 조회 확인 -" +sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				freeboardDTO = new FreeboardDTO();
	            freeboardDTO.setNum(resultSet.getInt("num"));
	            freeboardDTO.setMember_id(resultSet.getString("member_id"));
	            freeboardDTO.setFreeboard_title(resultSet.getString("freeboard_title"));
	            freeboardDTO.setFreeboard_content(resultSet.getString("freeboard_content"));
	            freeboardDTO.setFreeboard_registdate(resultSet.getString("freeboard_registdate"));
			}
			return freeboardDTO;
		} catch (Exception e) {
			log.info("글 상세 내용 보기 실패-" + e);
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
	public boolean freeboardInsert(FreeboardDTO freeboardDTO) {
		
		int num = 0;
		 String sql = "";
		 int result = 0;
		 
		 Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 ResultSet resultSet = null;
		 
		 try {
		        // 데이터 소스를 찾고 데이터베이스 연결을 가져옵니다.
		        Context context = new InitialContext();
		        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		        connection = dataSource.getConnection();
		        
		     // SQL 쿼리 문을 준비합니다.
		        // 시퀀스를 사용하여 num 값을 자동으로 할당합니다.
		        sql = "select max(num) from freeboard";
		        log.info("SQL 글번호 증가 확인- " + sql);
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					num = resultSet.getInt(1) + 1;
				}else {
					num = 1;
				}
				preparedStatement.close();	
				
				 sql = "insert into freeboard (num, member_id, freeboard_title, freeboard_content, freeboard_registdate) values(?, ?, ?, ?, sysdate)";
				log.info("SQL 글등록 확인 - " + sql);
				
				 // PreparedStatement를 사용하여 쿼리를 준비하고 파라미터를 설정합니다.
		        preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.setInt(1, num);
		        preparedStatement.setString(2, freeboardDTO.getMember_id());
		        preparedStatement.setString(3, freeboardDTO.getFreeboard_title());
		        preparedStatement.setString(4, freeboardDTO.getFreeboard_content());
		        
		        // 쿼리를 실행합니다
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
	public boolean freeboardUpdate(FreeboardDTO freeboardDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "update freeboard set member_id=?, freeboard_title=?, freeboard_content=? where num=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, freeboardDTO.getMember_id( ));
			preparedStatement.setString(2, freeboardDTO.getFreeboard_title( ));
			preparedStatement.setString(3, freeboardDTO.getFreeboard_content( ));
			preparedStatement.setInt(4, freeboardDTO.getNum());
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
	public boolean freeboardDelete(int num) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from freeboard where num=?";
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
	
	