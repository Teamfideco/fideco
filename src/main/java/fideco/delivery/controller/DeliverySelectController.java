package fideco.delivery.controller;

import fideco.control.Controller;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.delivery.DAO.DeliveryDAO;
import fideco.delivery.DTO.DeliveryDTO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;

public class DeliverySelectController implements Controller {
    private static Log log = LogFactory.getLog(DeliverySelectController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        log.info(deliveryDTO);

        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList = deliveryDAO.deliverySelectAll();
        log.info(deliveryList);

        // 배송 정보 조회 결과를 request 속성에 저장
        request.setAttribute("deliveryList", deliveryList);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("배송 정보 조회 성공");

        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_select_view.jsp");
        // HandlerAdapter 반환
        return handlerAdapter;
    }
}
