package fideco.delivery.DAO;

import fideco.delivery.DTO.DeliveryDTO;
import fideco.delivery.service.DeliveryService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAO implements DeliveryService {
    private static Log log = LogFactory.getLog(DeliveryDAO.class);

    @Override
    public ArrayList<DeliveryDTO> deliverySelectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "select delivery_id,delivery_custname,delivery_phon,delivery_addr,delivery_busnum,delivery_comment,orderlist_num from delivery";
            log.info("SQL확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // 결과 처리
            while (resultSet.next()) {
                DeliveryDTO deliveryDTO = new DeliveryDTO();
                deliveryDTO.setDelivery_id(resultSet.getInt("delivery_id"));
                deliveryDTO.setDelivery_custname(resultSet.getString("delivery_custname"));
                deliveryDTO.setDelivery_phon(resultSet.getString("delivery_phon"));
                deliveryDTO.setDelivery_addr(resultSet.getString("delivery_addr"));
                deliveryDTO.setDelivery_busnum(resultSet.getString("delivery_busnum"));
                deliveryDTO.setDelivery_comment(resultSet.getString("delivery_comment"));
                deliveryDTO.setOrderlist_num(resultSet.getString("orderlist_num"));
                deliveryList.add(deliveryDTO);
            }
            resultSet.getRow();
            if (resultSet.getRow() == 0) {
                log.info("등록된 배송 정보가 없습니다. 주문을 해주세요.");
            }
        } catch (Exception e) {
            log.info("배송 정보 조회에 실패 - " + e);
        } finally {
            // 연결 종료
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return deliveryList;
    }

    @Override
    public DeliveryDTO deliverySelect(int delivery_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "SELECT * FROM delivery WHERE delivery_id = ?";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, delivery_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                deliveryDTO.setDelivery_id(resultSet.getInt("delivery_id"));
                deliveryDTO.setDelivery_custname(resultSet.getString("delivery_custname"));
                deliveryDTO.setDelivery_phon(resultSet.getString("delivery_phon"));
                deliveryDTO.setDelivery_addr(resultSet.getString("delivery_addr"));
                deliveryDTO.setDelivery_busnum(resultSet.getString("delivery_busnum"));
                deliveryDTO.setDelivery_comment(resultSet.getString("delivery_comment"));
                deliveryDTO.setOrderlist_num(resultSet.getString("orderlist_num"));
            }
            // 결과 처리
        } catch (Exception e) {
            log.error("특정 배송 조회 실패 " + e);
        } finally {
            // 연결 종료
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deliveryDTO;
    }

    @Override
    public DeliveryDTO deliveryInsert(DeliveryDTO deliveryDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // SQL 문 실행
            String sql = "insert into delivery (delivery_id, delivery_custname, delivery_phon, delivery_addr, delivery_busnum, delivery_comment, orderlist_num) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            log.info("sql확인-" + sql);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deliveryDTO.getDelivery_id());
            preparedStatement.setString(2, deliveryDTO.getDelivery_custname());
            preparedStatement.setString(3, deliveryDTO.getDelivery_phon());
            preparedStatement.setString(4, deliveryDTO.getDelivery_addr());
            preparedStatement.setString(5, deliveryDTO.getDelivery_busnum());
            preparedStatement.setString(6, deliveryDTO.getDelivery_comment());
            preparedStatement.setString(7, deliveryDTO.getOrderlist_num());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋 되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.error("배송 입력 실패 " + e);
        } finally {
            // 연결 종료
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deliveryDTO;
    }

    @Override
    public DeliveryDTO deliveryUpdate(DeliveryDTO deliveryDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();


            // SQL 문 실행
            String sql = "UPDATE delivery SET delivery_custname=?, delivery_phon=?, delivery_addr=?, delivery_busnum=?, delivery_comment=?, orderlist_num=? WHERE delivery_id=?";
            log.info("sql확인 " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deliveryDTO.getDelivery_custname());
            preparedStatement.setString(2, deliveryDTO.getDelivery_phon());
            preparedStatement.setString(3, deliveryDTO.getDelivery_addr());
            preparedStatement.setString(4, deliveryDTO.getDelivery_busnum());
            preparedStatement.setString(5, deliveryDTO.getDelivery_comment());
            preparedStatement.setString(6, deliveryDTO.getOrderlist_num());
            preparedStatement.setInt(7, deliveryDTO.getDelivery_id());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋 되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백 되었습니다.");
            }
        } catch (Exception e) {
            log.error("배송정보 수정 실패 - " + e);
        } finally {
            // 연결 종료
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deliveryDTO;
    }

    @Override
    public DeliveryDTO deliveryDelete(int delivery_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "DELETE FROM delivery WHERE delivery_id=?";
            log.info("sql 확인 - " + sql);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, delivery_id);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋 되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.info("배송정보 삭제 실패 - " + e);
        } finally {
            // 연결 종료
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