package fideco.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.payment.dao.PaymentDAO;
import fideco.payment.dto.PaymentDTO;

public class PaymentSelectDetailController implements Controller{
	 private static Log log = LogFactory.getLog(PaymentSelectDetailController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String payment_id = request.getParameter("payment_id");
		log.info("payment_id - "+payment_id);
		PaymentDAO paymentDAO = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO = paymentDAO.paymentSelect(payment_id);
		log.info(paymentDTO);
		
		request.setAttribute("paymentDTO", paymentDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("결제 정보 상세 조회");
		
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_select_detail_view.jsp");
		
		return HandlerAdapter;
	}
	
}
