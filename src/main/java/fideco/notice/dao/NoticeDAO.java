package fideco.notice.dao;

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

import fideco.notice.dto.NoticeDTO;
import fideco.notice.service.NoticeService;

// DAO는 DB에 접근하는 객체를 생성해서 DB에 접근해서 데이터 조회,삽입,수정,삭제 등.
public class NoticeDAO implements NoticeService {
	private static Log log = LogFactory.getLog(NoticeDAO.class);

	@Override
	public ArrayList<NoticeDTO> noticeSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<NoticeDTO> arrayList = new ArrayList<NoticeDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select notice_num, notice_title, notice_content, notice_writer, notice_registday, notice_hit from notice ";
			sql += " order by notice_num desc";
			log.info("select sql문 확인 " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setNotice_num(resultSet.getInt("notice_num"));
				log.info("1번째 로그 " + noticeDTO);
				noticeDTO.setNotice_title(resultSet.getString("notice_title"));
				log.info("2번째 로그 " + noticeDTO);
				noticeDTO.setNotice_content(resultSet.getString("notice_content"));
				log.info("3번째 로그 " + noticeDTO);
				noticeDTO.setNotice_writer(resultSet.getString("notice_writer"));
				log.info("4번째 로그 " +noticeDTO);
				noticeDTO.setNotice_registday(resultSet.getString("notice_registday"));
				log.info("5번째 로그 " +noticeDTO);
				noticeDTO.setNotice_hit(resultSet.getInt("notice_hit"));
				log.info("6번째 로그 " +noticeDTO);
				arrayList.add(noticeDTO);
				log.info("arraylist :  " + arrayList);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 공지사항이 없습니다. 공지사항을 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("전체 공지사항 조회 실패 - " + e);
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
	public NoticeDTO noticeSelect(int notice_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		NoticeDTO noticeDTO = new NoticeDTO();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select notice_num, notice_title, notice_content, notice_writer, notice_registday, notice_hit from notice";
			sql += " where notice_num = ?";
			log.info("selectdetail sql문 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, notice_num);
			resultSet = preparedStatement.executeQuery();
			log.info("리절트 셋 : "+resultSet);
			while (resultSet.next()) {
				noticeDTO.setNotice_num(resultSet.getInt("notice_num"));
				noticeDTO.setNotice_title(resultSet.getString("notice_title"));
				noticeDTO.setNotice_content(resultSet.getString("notice_content"));
				noticeDTO.setNotice_writer(resultSet.getString("notice_writer"));
				noticeDTO.setNotice_registday(resultSet.getString("notice_registday"));
				noticeDTO.setNotice_hit(resultSet.getInt("notice_hit"));
				
				log.info("노티스디티오 : "+noticeDTO);
			}
		} catch (Exception e) {
			log.info("공지사항 상세 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noticeDTO;
	}

	@Override
	public NoticeDTO noticeInsert(NoticeDTO noticeDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into notice (notice_num, notice_title, notice_content, notice_writer, notice_registday, notice_hit)";
			sql += " values (notice_seq.nextval,?,?,?,sysdate,?)";
			log.info("sql 확인 : " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, noticeDTO.getNotice_title());
			preparedStatement.setString(2, noticeDTO.getNotice_content());
			preparedStatement.setString(3, noticeDTO.getNotice_writer());
			preparedStatement.setInt(4, 0);

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("공지사항 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noticeDTO;
	}

	@Override
	public NoticeDTO noticeUpdate(NoticeDTO noticeDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "update notice set notice_title = ?, notice_content = ?, notice_writer = ? ";
			sql += " where notice_num = ?";
			log.info("update sql문 확인 = " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, noticeDTO.getNotice_title());
			preparedStatement.setString(2, noticeDTO.getNotice_content());
			preparedStatement.setString(3, noticeDTO.getNotice_writer());

			preparedStatement.setInt(4, noticeDTO.getNotice_num());

			int count = preparedStatement.executeUpdate();
			log.info("count : "+count);
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("공지사항 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noticeDTO;

	}
	
	@Override
	public NoticeDTO noticehitUpdate(int notice_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "UPDATE notice SET notice_hit = notice_hit + 1 WHERE notice_num = ? ";
			log.info("update sql문 확인 = " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, notice_num);
			
			int count = preparedStatement.executeUpdate();
			log.info("count : "+count);
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("공지사항 조회수 수정 실패 - " + e);
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
 
	@Override
	public NoticeDTO noticeDelete(int notice_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from notice ";
			sql += " where notice_num = ?";
			log.info("delete sql문 확인 = " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, notice_num);
			

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("공지사항 삭제 실패 - " + e);
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
