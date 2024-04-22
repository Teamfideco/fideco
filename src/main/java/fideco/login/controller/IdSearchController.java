package fideco.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IdSearchController implements Controller {
	private static final Log log = LogFactory.getLog(IdSearchController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_name = request.getParameter("member_name");
		log.info(member_name);
		String member_email = request.getParameter("member_email");
		log.info(member_email);
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_name(member_name);
		memberDTO.setMember_email(member_email);

		MemberDAO memberDAO = new MemberDAO( );
		memberDTO = memberDAO.memberSearchmember_Id(member_name, member_email);
		log.info(memberDTO);
		request.setAttribute("member_id", memberDTO.getMember_id( ));

		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/login/id_search_view.jsp");

		return handlerAdapter;
	}

}
