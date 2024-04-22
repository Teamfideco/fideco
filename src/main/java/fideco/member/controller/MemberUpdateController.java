package fideco.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class MemberUpdateController implements Controller {
	private static final Log log = LogFactory.getLog(MemberUpdateController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO memberDTO = new MemberDTO( );
		MemberDAO memberDAO = new MemberDAO( );
		memberDTO.setMember_id(request.getParameter("member_id"));
		log.info(memberDTO);
		memberDTO = memberDAO.memberSelect(memberDTO);
		log.info(memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/member/member_update.jsp");
		return handlerAdapter;

	}
}