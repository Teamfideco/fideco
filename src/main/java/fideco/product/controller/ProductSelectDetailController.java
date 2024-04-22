package fideco.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;

public class ProductSelectDetailController implements Controller {
	
	  private static final Log log = LogFactory.getLog(ProductSelectDetailController.class);

	    @Override
	    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	        // 요청 파라미터에서 productId 가져오기
	        String product_id = request.getParameter("product_id");
	        log.info("Product ID: " + product_id);

	        // ProductDAO를 사용하여 상품 정보 조회
	        ProductDAO productDAO = new ProductDAO();
	        ProductDTO productDTO = productDAO.productSelect(product_id);
	        
	        // 조회된 상품 정보를 요청 속성에 저장
	        request.setAttribute("productDTO", productDTO);

	        // MinHandlerAdapter를 생성하여 경로 설정
	        HandlerAdapter handlerAdapter = new HandlerAdapter();
	        log.info("상품 상세 정보 조회");

	        // JSP 파일 경로 설정
	        handlerAdapter.setPath("/WEB-INF/view/product/product_select_detail_view.jsp");

	        // MinHandlerAdapter 반환
	        return handlerAdapter;
	    }
	}