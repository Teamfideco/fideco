package fideco.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class MemberDeleteController implements Controller {
	private static final Log log = LogFactory.getLog(MemberDeleteController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		log.info(member_id);
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_id(member_id);
		MemberDAO memberDAO = new MemberDAO( );
		memberDTO = memberDAO.memberDelete(memberDTO);
		log.info(memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/member/member_delete.jsp");
		return handlerAdapter;
	}
}

