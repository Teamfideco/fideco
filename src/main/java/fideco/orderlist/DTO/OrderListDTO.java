package fideco.orderlist.DTO;

public class OrderListDTO {
    //주문 내역 번호
    private String orderlist_num;
    //주문 총금액
    private int orderlist_amount;
    //주문 상태
    private int orderlist_status;
    //주문 일시
    private String orderlist_date;
    //주문번호
    private String order_id;

    public String getOrderlist_num() {
        return orderlist_num;
    }

    public void setOrderlist_num(String orderlist_num) {
        this.orderlist_num = orderlist_num;
    }

    public int getOrderlist_amount() {
        return orderlist_amount;
    }

    public void setOrderlist_amount(int orderlist_amount) {
        this.orderlist_amount = orderlist_amount;
    }

    public int getOrderlist_status() {
        return orderlist_status;
    }

    public void setOrderlist_status(int orderlist_status) {
        this.orderlist_status = orderlist_status;
    }

    public String getOrderlist_date() {
        return orderlist_date;
    }

    public void setOrderlist_date(String orderlist_date) {
        this.orderlist_date = orderlist_date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderlist_num='" + orderlist_num + '\'' +
                ", orderlist_amount=" + orderlist_amount +
                ", orderlist_status=" + orderlist_status +
                ", orderlist_date='" + orderlist_date + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
