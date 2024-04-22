package fideco.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import fideco.payment.dao.PaymentDAO;
import fideco.payment.dto.PaymentDTO;

public class PaymentUpdateViewController implements Controller {
	private static Log log = LogFactory.getLog(PaymentUpdateViewController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		log.info("----1-1-1--1-11-1-");
		String payment_id = request.getParameter("payment_id");
		log.info("payment_id : "+payment_id);
		int payment_amount = Integer.parseInt(request.getParameter("payment_amount"));
		log.info(payment_amount);
		String payment_date = request.getParameter("payment_date");
		log.info(payment_date);
		String payment_method = request.getParameter("payment_method");
		log.info(payment_method);

		PaymentDAO paymentDAO = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();

		paymentDTO.setPayment_id(payment_id);
		paymentDTO.setPayment_amount(payment_amount);
		paymentDTO.setPayment_date(payment_date);
		paymentDTO.setPayment_method(payment_method);

		paymentDTO = paymentDAO.paymentUpdate(paymentDTO);
		log.info(paymentDTO);

		request.setAttribute("paymentDTO", paymentDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_update_view.jsp");
		return HandlerAdapter;
	}

}
