package fideco.product.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;

public class ProductSelectController implements Controller {
	private static Log log = LogFactory.getLog(ProductSelectController.class);
	
	@Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO productDAO = new ProductDAO();
        ProductDTO productDTO = new ProductDTO();
        log.info(productDTO);
        
        ArrayList<ProductDTO> arrayList = new ArrayList<ProductDTO>();
        arrayList = productDAO.productSelectAll();
        log.info(arrayList);
        // 불러온 데이터를 request에 속성으로 추가한다.
        request.setAttribute("arrayList", arrayList);
        
        // 핸들러 어댑터를 생성하고 JSP 뷰 경로를 설정한다.
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("상품 정보 조회");
        handlerAdapter.setPath("/WEB-INF/view/product/product_select_view.jsp");
        return handlerAdapter;
    }
}
 