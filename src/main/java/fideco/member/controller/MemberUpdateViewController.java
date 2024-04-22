package fideco.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class MemberUpdateViewController implements Controller {
	private static final Log log = LogFactory.getLog(MemberUpdateViewController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO memberDAO = new MemberDAO( );
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_id(request.getParameter("member_id"));
		memberDTO.setMember_name(request.getParameter("member_name"));
		memberDTO.setMember_pw(request.getParameter("member_pw"));
		memberDTO.setMember_address(request.getParameter("member_address"));
		memberDTO.setMember_phone(request.getParameter("member_phone"));
		memberDTO.setMember_email(request.getParameter("member_email"));
		memberDTO.setMember_auth(request.getParameter("member_auth"));

		log.info("업데이터 정보 - " + memberDTO);
		memberDTO = memberDAO.memberUpdate(memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/member/member_update_view.jsp");
		return handlerAdapter;
	}
}
