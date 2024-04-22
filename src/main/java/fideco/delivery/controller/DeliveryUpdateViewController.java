package fideco.delivery.controller;

import fideco.control.Controller;
import fideco.delivery.DAO.DeliveryDAO;
import fideco.delivery.DTO.DeliveryDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliveryUpdateViewController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryUpdateViewController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
        log.info(delivery_id);

        String delivery_custname = request.getParameter("delivery_custname");
        log.info(delivery_custname);

        String delivery_phon = request.getParameter("delivery_phon");
        log.info(delivery_phon);

        String delivery_addr = request.getParameter("delivery_addr");
        log.info(delivery_addr);

        String delivery_busnum = request.getParameter("delivery_busnum");
        log.info(delivery_busnum);

        String delivery_comment = request.getParameter("delivery_comment");
        log.info(delivery_comment);

        String orderlist_num = request.getParameter("orderlist_num");
        log.info(orderlist_num);

        DeliveryDAO delveryDAO = new DeliveryDAO();
        DeliveryDTO delveryDTO = new DeliveryDTO();

        delveryDTO.setDelivery_id(delivery_id);
        delveryDTO.setDelivery_custname(delivery_custname);
        delveryDTO.setDelivery_phon(delivery_phon);
        delveryDTO.setDelivery_addr(delivery_addr);
        delveryDTO.setDelivery_busnum(delivery_busnum);
        delveryDTO.setDelivery_comment(delivery_comment);
        delveryDTO.setOrderlist_num(orderlist_num);

        delveryDTO = delveryDAO.deliveryUpdate(delveryDTO);
        log.info(delveryDTO);

        request.setAttribute("deliveryDTO",delveryDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();

        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_update_view.jsp");
        return handlerAdapter;
    }
}
