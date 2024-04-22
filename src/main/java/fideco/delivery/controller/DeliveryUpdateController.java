package fideco.delivery.controller;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.delivery.DAO.DeliveryDAO;
import fideco.delivery.DTO.DeliveryDTO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliveryUpdateController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryUpdateController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
        log.info(delivery_id);
        System.out.println(delivery_id);
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        DeliveryDAO deliveryDAO = new DeliveryDAO();

        deliveryDTO = deliveryDAO.deliverySelect(delivery_id);

        request.setAttribute("delivery_id",delivery_id);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("특정 배송정보 조회");

        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_update.jsp");
        return handlerAdapter;
    }
}
