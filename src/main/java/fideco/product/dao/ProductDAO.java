package fideco.product.dao;

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

import fideco.product.dto.ProductDTO;
import fideco.product.service.ProductService;


public class ProductDAO implements ProductService{
    private static Log log = LogFactory.getLog(ProductDAO.class);

	@Override
	public ArrayList<ProductDTO> productSelectAll() {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ProductDTO> arrayList = new ArrayList<>();
        
        try {
            // 컨텍스트에서 DataSource 객체를 가져와서 데이터베이스 연결을 설정합니다.
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            
            // 전체 상품 데이터를 조회하는 SQL 문을 설정합니다.
            String sql = "select product_id, product_name, product_price, product_regisdate, product_intro, product_image, product_category from product";
            log.info("SQL 확인 - " + sql);
            
            // SQL 문을 실행하고 결과를 resultSet에 저장합니다.
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            // 결과 세트를 반복하면서 각 행의 데이터를 ProductDTO 객체로 저장합니다.
            while (resultSet.next()) {
                ProductDTO productDTO = new ProductDTO();
                
                // resultSet에서 각 열의 값을 가져와 ProductDTO 객체에 설정합니다.
                productDTO.setProduct_id(resultSet.getString("product_id"));
                productDTO.setProduct_name(resultSet.getString("product_name"));
                productDTO.setProduct_price(resultSet.getInt("product_price"));
                productDTO.setProduct_regisdate(resultSet.getString("product_regisdate"));
                productDTO.setProduct_intro(resultSet.getString("product_intro"));
                productDTO.setProduct_image(resultSet.getString("product_image"));
                productDTO.setProduct_category(resultSet.getString("product_category"));
                
                // ProductDTO 객체를 arrayList에 추가합니다.
                arrayList.add(productDTO);
            }
            
            // 결과 세트의 행 번호를 검색합니다.
            resultSet.getRow();
            if (resultSet.getRow() == 0) {
                log.info("등록한 상품이 없습니다. 상품을 등록해 주세요.");
            }
            
        } catch (Exception e) {
            log.info("전체 상품 조회 실패 - " + e);
        } finally {
            // 리소스를 닫아줍니다.
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // 전체 상품 데이터를 반환합니다.
        return arrayList;
    }
	
	@Override
	public ProductDTO productSelect(String product_id) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductDTO productDTO = new ProductDTO();

        try {
            // 데이터 소스 및 데이터베이스 연결 설정
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // 상품 정보를 조회하는 SQL 쿼리 작성
            String sql = "select product_id, product_name, product_price, product_regisdate, product_intro, product_image, product_category from product";
            sql += " WHERE product_id = ?";

            // 쿼리 로그 출력
            log.info("SQL 확인 - " + sql);

            // SQL 문 실행 준비
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product_id);

            // SQL 쿼리 실행 및 결과 조회
            resultSet = preparedStatement.executeQuery();

            // 결과를 반복하며 `ProductDTO` 인스턴스에 저장
            while (resultSet.next()) {
                productDTO.setProduct_id(resultSet.getString("product_id"));
                productDTO.setProduct_name(resultSet.getString("product_name"));
                productDTO.setProduct_price(resultSet.getInt("product_price"));
                productDTO.setProduct_regisdate(resultSet.getString("product_regisdate"));
                productDTO.setProduct_intro(resultSet.getString("product_intro"));
                productDTO.setProduct_image(resultSet.getString("product_image"));
                productDTO.setProduct_category(resultSet.getString("product_category"));
            }
        } catch (Exception e) {
            // 오류 처리 로그
            log.info("상품 상세 정보 조회 실패 - " + e);
        } finally {
            // 데이터베이스 자원 해제
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // `ProductDTO` 반환
        return productDTO;
    }

	@Override
	public ProductDTO productInsert(ProductDTO productDTO) {
		 Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            Context context = new InitialContext();
	            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	            connection = dataSource.getConnection();
	            
	            // SQL 쿼리 작성
	            String sql =  "insert into product (product_id, product_name, product_price, product_regisdate, product_intro, product_category, product_image) ";
	            sql += "VALUES (?, ?, ?, sysdate, ?, ?, ?)";
	            log.info("SQL 확인 - " + sql);
	            
	            // 준비된 문장 설정
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, productDTO.getProduct_id());
	            preparedStatement.setString(2, productDTO.getProduct_name());
	            preparedStatement.setInt(3, productDTO.getProduct_price());
	            preparedStatement.setString(4, productDTO.getProduct_intro());
	            preparedStatement.setString(5, productDTO.getProduct_category());
	            preparedStatement.setString(6, productDTO.getProduct_image());
	            
	            // SQL 실행 및 데이터 입력
	            int count = preparedStatement.executeUpdate();
	            if (count > 0) {
	                connection.commit();
	                log.info("커밋되었습니다.");
	            } else {
	                connection.rollback();
	                log.info("롤백되었습니다.");
	            }
	        } catch (Exception e) {
	            log.info("상품 입력 실패 - " + e);
	        } finally {
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        // 입력된 ProductDTO 반환
	        return productDTO;
	    }


	@Override
	public ProductDTO productUpdate(ProductDTO productDTO) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // 상품 정보 수정 SQL 쿼리
            String sql = "update product set product_name = ?, product_price = ?, product_intro = ?, product_category = ?, product_image = ?";
            sql += " WHERE product_id = ?";
            
            log.info("SQL 확인 - " + sql);
            
            // PreparedStatement 설정
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productDTO.getProduct_name());
            preparedStatement.setInt(2, productDTO.getProduct_price());
            preparedStatement.setString(3, productDTO.getProduct_intro());
            preparedStatement.setString(4, productDTO.getProduct_category());
            preparedStatement.setString(5, productDTO.getProduct_image());
            preparedStatement.setString(6, productDTO.getProduct_id());

            // 상품 정보 수정 실행
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋되었습니다.");
            } else {
                connection.rollback();
                log.info("롤백되었습니다.");
            }
        } catch (Exception e) {
            log.info("상품 정보 수정 실패 - " + e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productDTO;
    }

	@Override
	public ProductDTO productDelete(String product_id) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        Context context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = dataSource.getConnection();
	        
	        // 상품을 삭제하는 SQL 쿼리
	        String sql = "delete from product where product_id = ?";
	        log.info("SQL 확인 - " + sql);
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, product_id);
	        
	        // SQL 쿼리를 실행하여 상품 삭제
	        int count = preparedStatement.executeUpdate();
	        if (count > 0) {
	            connection.commit();
	            log.info("상품 삭제 커밋 완료");
	        } else {
	            connection.rollback();
	            log.info("상품 삭제 롤백 완료");
	        }
	    } catch (Exception e) {
	        log.info("상품 삭제 실패 - " + e);
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
