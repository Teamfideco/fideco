package fideco.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;

public class ProductDeleteController implements Controller {
	private static Log log = LogFactory.getLog(ProductDeleteController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        // 요청에서 상품 ID 추출
        String product_id = request.getParameter("product_id");
        log.info("상품 ID: " + product_id);

        // ProductDAO 객체 생성
        ProductDAO productDAO = new ProductDAO();
        
        // 데이터베이스에서 상품 삭제
        ProductDTO productDTO = productDAO.productDelete(product_id);
        
        // 상품 삭제 후 결과를 요청 속성에 추가
        request.setAttribute("productDTO", productDTO);
        
        // MinHandlerAdapter 객체 생성 및 JSP 경로 설정
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("상품 삭제 완료");
        
        // 삭제 확인 페이지의 경로 설정 (예: /WEB-INF/view/product/product_delete_view.jsp)
        handlerAdapter.setPath("/WEB-INF/view/product/product_delete_view.jsp");
        
        // MinHandlerAdapter 객체 반환
        return handlerAdapter;
    }
}