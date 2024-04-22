package fideco.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.payment.dao.PaymentDAO;
import fideco.payment.dto.PaymentDTO;

public class PaymentDeleteController implements Controller {
	private static Log log = LogFactory.getLog(PaymentDeleteController.class);
	 
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String payment_id = request.getParameter("payment_id");
		log.info(payment_id);
		PaymentDAO paymentDAO = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO.setPayment_id(payment_id);
		request.setAttribute("paymentDTO", paymentDTO);
		paymentDTO = paymentDAO.paymentDelete(payment_id);
		log.info(paymentDTO);
		
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_delete_view.jsp");
		
		return HandlerAdapter;
	}

}
