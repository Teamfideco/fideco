package fideco.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;

public class ProductInsertController implements Controller {
	private static Log log = LogFactory.getLog(ProductInsertController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	    // 요청에서 전달된 상품 정보를 추출
	    String product_id = request.getParameter("product_id");
	    log.info(product_id);
	    String product_name = request.getParameter("product_name");
	    log.info(product_name);
	    int product_price = Integer.parseInt(request.getParameter("product_price"));
	    log.info(product_price);
	    String product_regisdate = request.getParameter("product_regisdate");
	    log.info(product_regisdate);
	    String product_intro = request.getParameter("product_intro");
	    log.info(product_intro);
	    String product_category = request.getParameter("product_category");
	    log.info(product_category);
	    String product_image = request.getParameter("product_image");
	    log.info(product_image);

	    // 데이터 액세스 객체를 사용하여 상품 정보를 저장
	    ProductDAO productDao = new ProductDAO();
	    ProductDTO productDTO = new ProductDTO();
	    
	    // ProductDTO 클래스의 인스턴스에 입력된 상품 정보를 저장
	    productDTO.setProduct_id(product_id);
	    productDTO.setProduct_name(product_name);
	    productDTO.setProduct_price(product_price);
	    productDTO.setProduct_regisdate(product_regisdate);
	    productDTO.setProduct_intro(product_intro);
	    productDTO.setProduct_category(product_category);
	    productDTO.setProduct_image(product_image);
	    
	    // 상품 정보를 데이터베이스에 저장
	    productDTO = productDao.productInsert(productDTO);
	    log.info(productDTO);
	    
	    // 저장된 상품 정보를 요청에 속성으로 추가
	    request.setAttribute("productDTO", productDTO);
	    log.info("상품 정보 등록");

	    // 상품 입력 완료 페이지로 포워드
	    HandlerAdapter handlerAdapter = new HandlerAdapter();
	    handlerAdapter.setPath("/WEB-INF/view/product/product_insert.jsp");
	    
	    return handlerAdapter;
	}
}