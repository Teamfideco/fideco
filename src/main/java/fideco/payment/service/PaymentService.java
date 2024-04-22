package fideco.payment.service;

import java.util.ArrayList;

import fideco.payment.dto.PaymentDTO;
// 서비스는 db에 DTO 객체를 전달해 정보 저장, 호출. 데이터베이스에 연동할 변수를 전송한다.
public interface PaymentService {

	// 전체 데이터를 조회
	public ArrayList<PaymentDTO> paymentSelectAll();

	// 개별 데이터를 조회
	public PaymentDTO paymentSelect(String payment_id);

	// 데이터 입력
	public PaymentDTO paymentInsert(PaymentDTO paymentDTO);

	// 데이터 수정
	public PaymentDTO paymentUpdate(PaymentDTO paymentDTO);

	// 데이터 삭제
	public PaymentDTO paymentDelete(String payment_id);
}
