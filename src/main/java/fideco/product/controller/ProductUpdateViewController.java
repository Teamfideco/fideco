package fideco.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.product.dao.ProductDAO;
import fideco.product.dto.ProductDTO;


public class ProductUpdateViewController implements Controller {
	  private static Log log = LogFactory.getLog(ProductUpdateViewController.class);

	  @Override
	    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	        // 요청에서 상품 정보를 추출
	        String product_id = request.getParameter("product_id");
	        log.info("상품 ID: " + product_id);
	        
	        String product_name = request.getParameter("product_name");
	        log.info("상품 이름: " + product_name);
	        
	        int product_price = Integer.parseInt(request.getParameter("product_price"));
	        log.info("상품 가격: " + product_price);
	        
	        String product_intro = request.getParameter("product_intro");
	        log.info("상품 소개: " + product_intro);
	        
	        String product_category = request.getParameter("product_category");
	        log.info("상품 카테고리: " + product_category);
	        
	        String product_image = request.getParameter("product_image");
	        log.info("상품 이미지: " + product_image);

	        // ProductDAO 객체 생성
	        ProductDAO productDAO = new ProductDAO();

	        // ProductDTO 객체 생성 및 요청에서 추출한 정보를 저장
	        ProductDTO productDTO = new ProductDTO();
	        productDTO.setProduct_id(product_id);
	        productDTO.setProduct_name(product_name);
	        productDTO.setProduct_price(product_price);
	        productDTO.setProduct_intro(product_intro);
	        productDTO.setProduct_category(product_category);
	        productDTO.setProduct_image(product_image);

	        // 상품 정보 업데이트
	        productDTO = productDAO.productUpdate(productDTO);
	        log.info("업데이트된 상품 정보: " + productDTO);

	        // 요청 속성에 ProductDTO 객체 추가
	        request.setAttribute("productDTO", productDTO);

	        // HandlerAdapter 객체 생성
	        HandlerAdapter handlerAdapter = new HandlerAdapter();

	        // 업데이트된 상품 정보를 표시할 페이지 설정
	        handlerAdapter.setPath("/WEB-INF/view/product/product_update_view.jsp");

	        // HandlerAdapter 객체 반환
	        return handlerAdapter;
	    }
	}
