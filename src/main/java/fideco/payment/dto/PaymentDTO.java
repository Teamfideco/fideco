package fideco.payment.dto;

public class PaymentDTO {
	public String payment_id; //결제 아이디
	public int payment_amount; // 결제 금액
	public String payment_date; //결제 일자
	public String payment_method; // 결제 수단

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	@Override
	public String toString() {
		return "PaymentDTO [payment_id=" + payment_id + ", payment_amount=" + payment_amount + ", payment_date="
				+ payment_date + ", payment_method=" + payment_method + "]";
	}

}
