package fideco.delivery.controller;

import fideco.control.Controller;
import fideco.delivery.DAO.DeliveryDAO;
import fideco.delivery.DTO.DeliveryDTO;
import fideco.handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;

public class DeliveryInsertController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryInsertController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        // 요청 파라미터에서 받은 데이터를 가져옴
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


        DeliveryDAO deliveryDAO = new DeliveryDAO();
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList = deliveryDAO.deliverySelectAll();

        deliveryDTO.setDelivery_id(delivery_id);
        deliveryDTO.setDelivery_custname(delivery_custname);
        deliveryDTO.setDelivery_phon(delivery_phon);
        deliveryDTO.setDelivery_addr(delivery_addr);
        deliveryDTO.setDelivery_busnum(delivery_busnum);
        deliveryDTO.setDelivery_comment(delivery_comment);
        deliveryDTO.setOrderlist_num(orderlist_num);

        deliveryDTO = deliveryDAO.deliveryInsert(deliveryDTO);
        // 등록된 배송 정보를 로그에 출력
        log.info("등록된 배송 정보: " + deliveryDTO);

        // 등록된 배송 정보를 request 속성에 설정하여 View로 전달
        request.setAttribute("deliveryDTO", deliveryDTO);

        // HandlerAdapter 객체를 생성하여 View의 경로를 설정하여 반환
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_insert_view.jsp");
        return handlerAdapter;
    }
}
