package fideco.member.dao;

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

import fideco.member.dto.MemberDTO;
import fideco.member.service.MemberService;

public class MemberDAO implements MemberService {
    private static final Log log = LogFactory.getLog(MemberDAO.class);

    // MemberDTO 클래스 반환 자료형으로 전체 데이터를 조회한다.
    @Override
    public ArrayList<MemberDTO> memberSelectAll(int page, int limit) {
        ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // 쿼리문 입력
            String sql = "select member_id, member_name, member_pw, member_address, member_phone, member_email, member_auth from member ";
            sql += "where member_id != 'admin' order by member_id desc";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setMember_id(resultSet.getString("member_id"));
                memberDTO.setMember_name(resultSet.getString("member_name"));
                memberDTO.setMember_pw(resultSet.getString("member_pw"));
                memberDTO.setMember_address(resultSet.getString("member_address"));
                memberDTO.setMember_phone(resultSet.getString("member_phone"));
                memberDTO.setMember_email(resultSet.getString("member_email"));
               memberDTO.setMember_auth(resultSet.getString("member_auth"));
                arrayList.add(memberDTO);
                log.info("조회 데이터 확인" + memberDTO);
            }
            if (resultSet.getRow() == 0) {
                log.info("등록된 회원이 없습니다.");
            }
        } catch (Exception e) {
            log.info("전체 회원 조회 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    // MemberDTO 반환 자료형으로 데이터를 입력한다.
    @Override
    public MemberDTO memberInsert(MemberDTO memberDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "insert into member(member_id, member_name, member_pw, member_address, member_phone, member_email, member_auth) ";
            sql += " values (?, ?, ?, ?, ?, ?, ?)";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberDTO.getMember_id());
            preparedStatement.setString(2, memberDTO.getMember_name());
            preparedStatement.setString(3, memberDTO.getMember_pw());
            preparedStatement.setString(4, memberDTO.getMember_address());
            preparedStatement.setString(5, memberDTO.getMember_phone());
            preparedStatement.setString(6, memberDTO.getMember_email());
           preparedStatement.setString(7, memberDTO.getMember_auth());
            int count = preparedStatement.executeUpdate();
            log.info("입력 데이터 확인 - " + memberDTO);
            if (count > 0) {
                connection.commit();
                log.info("커밋되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.info("회원 가입 실패 - " + e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

    // MemberDTO 클래스 반환 자료형으로 데이터를 수정한다.
    @Override
    public MemberDTO memberUpdate(MemberDTO memberDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        log.info("업데이트 정보 - " + memberDTO);
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "update member set member_name = ?,  member_pw = ?,  member_address = ?, member_phone = ?, member_email = ?, member_auth = ?  ";
            sql += "where member_id = ?";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberDTO.getMember_name());
            preparedStatement.setString(2, memberDTO.getMember_pw());
            preparedStatement.setString(3, memberDTO.getMember_address());
            preparedStatement.setString(4, memberDTO.getMember_phone());
            preparedStatement.setString(5, memberDTO.getMember_email());
            preparedStatement.setString(6, memberDTO.getMember_auth());
            preparedStatement.setString(7, memberDTO.getMember_id());
            int count = preparedStatement.executeUpdate();
            log.info("수정 데이터 확인 - " + memberDTO);
            if (count > 0) {
                connection.commit();
                log.info("커밋되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.info("회원 정보 수정 실패 - " + e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

    // MemberDTO 클래스 반환 자료형으로 데이터를 삭제한다.
    @Override
    public MemberDTO memberDelete(MemberDTO memberDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "delete from member ";
            sql += " where member_id = ? ";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberDTO.getMember_id());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.info("회원 삭제 실패 - " + e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

    // MemberDTO 클래스 반환 자료형으로 특정 회원 데이터를 조회한다.
    @Override
    public MemberDTO memberSelect(MemberDTO memberDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // 쿼리문 작성
            String sql = "select member_id, member_name, member_pw, member_address, member_phone, member_email, member_auth from member";
            sql += " where member_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberDTO.getMember_id());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                log.info("아이디 확인 - " + resultSet.getString("member_id"));
                memberDTO.setMember_name(resultSet.getString("member_name"));
                memberDTO.setMember_id(resultSet.getString("member_id"));
                memberDTO.setMember_pw(resultSet.getString("member_pw"));
                memberDTO.setMember_address(resultSet.getString("member_address"));
                memberDTO.setMember_phone(resultSet.getString("member_phone"));
                memberDTO.setMember_email(resultSet.getString("member_email"));
                memberDTO.setMember_auth(resultSet.getString("member_auth"));
            }
        } catch (Exception e) {
            log.info("개별 회원 조회 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

    // int 반환 자료형으로 입력 데이터의 번호를 구한다.
    @Override
    public int memberNumber() {
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "select max(member_id) from member";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            if (resultSet.next()) {
                i = resultSet.getInt("max(member_id)");
            }
        } catch (Exception e) {
            log.info("최대 회원 번호 검색 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    // int 반환 자료형으로 입력 데이터의 개수를 구한다.
    @Override
    public int memberCount() {
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "select count(*) from member where member_id != 'admin'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (Exception e) {
            log.info("현재 회원 수 검색 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    // 제네릭 MemberDTO 클래스 반환 자료형으로 데이터를 검색한다.
    @Override
    public ArrayList<MemberDTO> memberSearch(String keyword, int page, int limit) {
        log.info("검색 단어 확인 - " + keyword);
        String searchCall = "";
        if (!keyword.equals("")) {
            searchCall = "where member_id like '%" + keyword + "%'";
        }
        ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
        int startrow = (page - 1) * 10 + 1;
        int endrow = startrow + limit - 1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "select member_id, member_name, member_pw, member_address, member_phone, member_email, member_auth from member ";
            sql += "from member " + searchCall + " order by member_id desc) where member_id != 'admin')";
            sql += " where rnum between " + startrow + " and " + endrow;
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setMember_id(resultSet.getString("member_id"));
                memberDTO.setMember_name(resultSet.getString("member_name"));
                memberDTO.setMember_pw(resultSet.getString("member_pw"));
                memberDTO.setMember_address(resultSet.getString("member_address"));
                memberDTO.setMember_phone(resultSet.getString("member_phone"));
                memberDTO.setMember_email(resultSet.getString("member_email"));
                memberDTO.setMember_auth(resultSet.getString("member_auth"));
                arrayList.add(memberDTO);
                log.info("조회 데이터 확인" + memberDTO);
            }
            if (resultSet.getRow() == 0) {
                log.info("등록된 회원이 없습니다.");
            }
        } catch (Exception e) {
            log.info("회원 포인트 검색 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    // int 반환 자료형으로 검색 데이터의 개수를 구한다.
    @Override
    public int memberSearchCount(String keyword) {
        int i = 0;
        log.info("검색 단어 확인 - " + keyword);
        String searchCall = "";
        if (!keyword.equals("")) {
            searchCall = "member_id like '%" + keyword + "%'";
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "select count(*) from (select * from member where member_id != 'admin') where " + searchCall;
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (Exception e) {
            log.info("아이디 검색 회원 수 검색 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

  //MemberDTO 클래스 반환 자료형으로 로그인 데이터를 조회한다.
  	@Override
  	public MemberDTO memberLogin(MemberDTO memberDTO) {
  		Connection connection = null;
  		PreparedStatement preparedStatement = null;
  		ResultSet resultSet = null;
  		try {
  			Context context = new InitialContext( );
  			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
  			connection = dataSource.getConnection( );
  			String sql = "select * from member ";
  			sql += " where member_id = ?";
  			log.info("SQL - " + sql);
  			preparedStatement = connection.prepareStatement(sql);
  			preparedStatement.setString(1, memberDTO.getMember_id( ));
  			// SQL 문인 select…from…where 문을 실행하고 데이터를 조회한다.
  			resultSet = preparedStatement.executeQuery( );
  			// 커서를 현재 위치에서 한 행 앞으로 이동하면서 조건을 확인한다.
  			if(resultSet.next( )) {
  				// 입력한 아이디와 비밀번호가 기존의 아이디와 비밀번호가 일치하는지를 검사한다.
  				memberDTO.setMember_name(resultSet.getString("member_name"));
  				memberDTO.setMember_id(resultSet.getString("member_id"));
  				log.info("아이디 확인 - " + resultSet.getString("member_id"));
  				if(resultSet.getString("member_pw").equals(memberDTO.getMember_pw( ))) {
  					memberDTO.setMember_pw(resultSet.getString("member_pw"));
  					log.info("비밀번호 확인 - " + resultSet.getString("member_pw"));
  				} else {
  					memberDTO.setMember_pw("");
  				}
  			} else {
  				memberDTO.setMember_id("");
  			}
  		} catch(Exception e) {
  			log.info("로그인 실패 - " + e);
  		} finally {
  			try {
  				resultSet.close( );
  				preparedStatement.close( );
  				connection.close( );
  			} catch(SQLException e) {
  				e.printStackTrace( );
  			}
  		}
  		return memberDTO;
  	}

  	@Override
  	public MemberDTO memberLoginMain(MemberDTO memberDTO) {
  	    Connection connection = null;
  	    PreparedStatement preparedStatement = null;
  	    ResultSet resultSet = null;

  	    try {
  	        Context context = new InitialContext();
  	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
  	        connection = dataSource.getConnection();

  	        // 사용자 인증을 위한 쿼리 작성
  	        String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw = ? AND member_name";
  	        preparedStatement = connection.prepareStatement(sql);
  	        preparedStatement.setString(1, memberDTO.getMember_id());
  	        preparedStatement.setString(2, memberDTO.getMember_pw());
  	        preparedStatement.setString(3, memberDTO.getMember_name());
  	        resultSet = preparedStatement.executeQuery();

  	        if (resultSet.next()) {
  	            // 사용자 인증에 성공한 경우
  	            // 세션에 사용자 정보를 저장하는 등의 작업을 수행할 수 있습니다.
  	            // 예를 들어, 세션에 사용자 아이디를 저장한다면:
  	            // session.setAttribute("loggedInUserId", memberDTO.getmember_Id());
  	            // 혹은 로그인 여부를 저장할 수도 있습니다.
  	            // session.setAttribute("isLoggedIn", true);

  	            // 사용자 인증에 성공하면 memberDTO를 반환합니다.
  	            return memberDTO;
  	        } else {
  	            // 사용자 인증에 실패한 경우
  	            // 실패한 이유를 사용자에게 알려주는 등의 작업을 수행할 수 있습니다.
  	            // 예를 들어, 인증 실패 메시지를 설정하여 반환할 수 있습니다.
  	            
  	            return null;
  	        }
  	    } catch (Exception e) {
  	        // 예외 처리
  	        e.printStackTrace();
  	        // 예외가 발생하면 null을 반환하거나 예외를 다시 던지는 등의 처리를 할 수 있습니다.
  	        return null;
  	    } finally {
  	        // 리소스 해제
  	        try {
  	            if (resultSet != null) resultSet.close();
  	            if (preparedStatement != null) preparedStatement.close();
  	            if (connection != null) connection.close();
  	        } catch (SQLException e) {
  	            e.printStackTrace();
  	        }
  	    }
  	}
  	
  	
    // int 반환 자료형으로 아이디 데이터를 조회한다.
    @Override
    public int membermember_Id(String member_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int idCheck = 0;

        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            String sql = "select * from member ";
            sql += "where member_id=? ";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next() || member_id.equals("")) {

                // 존재하는 경우
                idCheck = 1;
            } else {
                // 존재하지 않는 경우
                idCheck = 0;
            }

        } catch (Exception e) {
            log.info("회원 아이디 체크 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idCheck;
    }

    // MemberDTO 클래스 반환 자료형으로 아이디 데이터를 검색한다.
    @Override
    public MemberDTO memberSearchmember_Id(String member_name, String member_email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        MemberDTO memberDTO = new MemberDTO();
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // 쿼리문 작성
            String sql = "select * from member where member_name=? and member_email=?";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member_name);
            preparedStatement.setString(2, member_email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                memberDTO.setMember_id(resultSet.getString("member_id"));
                memberDTO.setMember_name(resultSet.getString("member_name"));
                memberDTO.setMember_pw(resultSet.getString("member_pw"));
                memberDTO.setMember_address(resultSet.getString("member_address"));
                memberDTO.setMember_phone(resultSet.getString("member_phone"));
                memberDTO.setMember_email(resultSet.getString("member_email"));

                log.info("조회 데이터 확인" + memberDTO);
            }
        } catch (Exception e) {
            log.info("아이디 찾기 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

    // MemberDTO 클래스 반환 자료형으로 비밀번호 데이터를 검색한다.
    public MemberDTO memberSearchPassword(String member_id, String member_email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        MemberDTO memberDTO = new MemberDTO();
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // 쿼리문 작성
            String sql = "select * from member where member_id=? and member_email=?";
            log.info("SQL - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member_id);
            preparedStatement.setString(2, member_email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                memberDTO.setMember_id(resultSet.getString("member_id"));
                memberDTO.setMember_name(resultSet.getString("member_name"));
                memberDTO.setMember_pw(resultSet.getString("member_pw"));
                memberDTO.setMember_address(resultSet.getString("member_address"));
                memberDTO.setMember_phone(resultSet.getString("member_phone"));
                memberDTO.setMember_email(resultSet.getString("member_email"));
                log.info("조회 데이터 확인" + memberDTO);
            }
        } catch (Exception e) {
            log.info("비밀번호 찾기 실패 - " + e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberDTO;
    }

	@Override
	public MemberDTO memberSearchmember_Pw(String member_id, String member_email) {
		// TODO Auto-generated method stub
		return null;
	}

}
