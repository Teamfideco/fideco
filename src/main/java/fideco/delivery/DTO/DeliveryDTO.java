package fideco.delivery.DTO;

public class DeliveryDTO {
    private int delivery_id; // order_id
    private String delivery_custname;
    private String delivery_phon;
    private String delivery_addr;
    private String delivery_busnum;
    private String delivery_comment;
    private String orderlist_num;


    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDelivery_custname() {
        return delivery_custname;
    }

    public void setDelivery_custname(String delivery_custname) {
        this.delivery_custname = delivery_custname;
    }

    public String getDelivery_phon() {
        return delivery_phon;
    }

    public void setDelivery_phon(String delivery_phon) {
        this.delivery_phon = delivery_phon;
    }

    public String getDelivery_addr() {
        return delivery_addr;
    }

    public void setDelivery_addr(String delivery_addr) {
        this.delivery_addr = delivery_addr;
    }

    public String getDelivery_busnum() {
        return delivery_busnum;
    }

    public void setDelivery_busnum(String delivery_busnum) {
        this.delivery_busnum = delivery_busnum;
    }

    public String getDelivery_comment() {
        return delivery_comment;
    }

    public void setDelivery_comment(String delivery_comment) {
        this.delivery_comment = delivery_comment;
    }

    public String getOrderlist_num() {
        return orderlist_num;
    }

    public void setOrderlist_num(String orderlist_num) {
        this.orderlist_num = orderlist_num;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "order_id=" + delivery_id +
                ", delivery_custname='" + delivery_custname + '\'' +
                ", delivery_phon='" + delivery_phon + '\'' +
                ", delivery_addr='" + delivery_addr + '\'' +
                ", delivery_busnum='" + delivery_busnum + '\'' +
                ", delivery_comment='" + delivery_comment + '\'' +
                ", orderlist_num='" + orderlist_num + '\'' +
                '}';
    }
}
