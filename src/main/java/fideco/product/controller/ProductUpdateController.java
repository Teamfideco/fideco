package fideco.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;

public class ProductUpdateController implements Controller {
	  private static Log log = LogFactory.getLog(ProductUpdateController.class);

	  @Override
	    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	        // 요청에서 상품 ID 추출
	        String product_id = request.getParameter("product_id");
	        log.info("상품 ID: " + product_id);

	        // ProductDAO 객체 생성
	        ProductDAO productDAO = new ProductDAO();

	        // 데이터베이스에서 상품 정보 조회
	        ProductDTO productDTO = new ProductDTO();
	        
	        productDTO = productDAO.productSelect(product_id);
	        
	        // 조회된 상품 정보를 요청 속성에 추가
	        request.setAttribute("productDTO", productDTO);
	        
	        // HandlerAdapter 객체 생성
	        HandlerAdapter handlerAdapter = new HandlerAdapter();
	        
	        // 수정 페이지의 경로 설정
	        handlerAdapter.setPath("/WEB-INF/view/product/product_update.jsp");
	        
	        // 로그 출력
	        log.info("상품 정보 조회 완료");
	        
	        // HandlerAdapter 객체 반환
	        return handlerAdapter;
	    }
	}
