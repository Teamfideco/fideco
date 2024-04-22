package fideco.payment.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.payment.dao.PaymentDAO;
import fideco.payment.dto.PaymentDTO;

public class PaymentInsertController implements Controller{
	private static Log log = LogFactory.getLog(PaymentInsertController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String payment_id = request.getParameter("payment_id");
		log.info("payment_id:"+payment_id);
		int payment_amount = Integer.parseInt(request.getParameter("payment_amount"));
		log.info("payment_amount:"+payment_amount);
		String payment_date = request.getParameter("payment_date");
		log.info("payment_date:"+payment_date);
		String payment_method = request.getParameter("payment_method");
		log.info("payment_method:"+payment_method);
		
		PaymentDAO paymentDAO = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		ArrayList<PaymentDTO> arrayList = new ArrayList<PaymentDTO>();
		
		arrayList = paymentDAO.paymentSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		paymentDTO.setPayment_id(payment_id);
		paymentDTO.setPayment_amount(payment_amount);
		paymentDTO.setPayment_date(payment_date);
		paymentDTO.setPayment_method(payment_method);
		
		paymentDTO = paymentDAO.paymentInsert(paymentDTO);
		log.info(paymentDTO);
		
		request.setAttribute("paymentDTO", paymentDTO);
		log.info("결제 정보 등록");
		
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_insert.jsp");
		return HandlerAdapter;
		
		
	}
	
}
