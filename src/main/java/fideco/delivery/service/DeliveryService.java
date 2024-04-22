package fideco.delivery.service;

import java.util.ArrayList;

import fideco.delivery.DTO.DeliveryDTO;

public interface DeliveryService {
    public ArrayList<DeliveryDTO> deliverySelectAll();
    public DeliveryDTO deliverySelect(int order_id);
    public DeliveryDTO deliveryInsert(DeliveryDTO deliveryDTO);
    public DeliveryDTO deliveryUpdate(DeliveryDTO deliveryDTO);
    public DeliveryDTO deliveryDelete(int order_id);

}
