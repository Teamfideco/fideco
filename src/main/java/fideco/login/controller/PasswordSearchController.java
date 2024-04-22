package fideco.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PasswordSearchController implements Controller {
	private static final Log log = LogFactory.getLog(PasswordSearchController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		log.info(member_id);
		String member_email = request.getParameter("member_email");
		log.info(member_email);
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_email(member_email);

		MemberDAO memberDAO = new MemberDAO( );
		memberDTO = memberDAO.memberSearchPassword(member_id, member_email);
		log.info(memberDTO);
		request.setAttribute("member_pw", memberDTO.getMember_pw( ));

		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/login/password_search_view.jsp");

		return handlerAdapter;
	}

}
