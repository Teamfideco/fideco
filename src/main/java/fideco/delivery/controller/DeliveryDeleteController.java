package fideco.delivery.controller;

import fideco.control.Controller;
import fideco.delivery.DAO.DeliveryDAO;
import fideco.delivery.DTO.DeliveryDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliveryDeleteController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryDeleteController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
        log.info(delivery_id);
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setDelivery_id(delivery_id);

        request.setAttribute("deliveryDTO",deliveryDTO);

        deliveryDTO = deliveryDAO.deliveryDelete(delivery_id);
        log.info(deliveryDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_delete_view.jsp");
        return handlerAdapter;
    }
}
