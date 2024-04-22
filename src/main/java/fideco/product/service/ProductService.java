package fideco.product.service;

import java.util.ArrayList;

import fideco.product.dto.ProductDTO;

public interface ProductService {
	// 제네릭 ProductDTO 클래스 반환 타입으로 연동할 인스턴스 변수를 전달하고 전체 데이터를 조회한다.
    public ArrayList<ProductDTO> productSelectAll();

    // ProductDTO 클래스 반환 타입으로 연동할 인스턴스 변수를 전달하고 특정 데이터를 조회한다.
    public ProductDTO productSelect(String product_id);

    // ProductDTO 클래스 반환 타입으로 연동할 인스턴스 변수를 전달하고 데이터를 입력한다.
    public ProductDTO productInsert(ProductDTO productDTO);

    // ProductDTO 클래스 반환 타입으로 연동할 인스턴스 변수를 전달하고 데이터를 수정한다.
    public ProductDTO productUpdate(ProductDTO productDTO);

    // ProductDTO 클래스 반환 타입으로 연동할 인스턴스 변수를 전달하고 데이터를 삭제한다.
    public ProductDTO productDelete(String product_id);
}