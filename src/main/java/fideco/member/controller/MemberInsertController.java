package fideco.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class MemberInsertController implements Controller {
	private static final Log log = LogFactory.getLog(MemberInsertController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		log.info(member_id);
		String member_name = request.getParameter("member_name");
		log.info(member_name);
		String member_pw = request.getParameter("member_pw");
		log.info(member_pw);
		String member_address = request.getParameter("member_address");
		log.info(member_address);
		String member_phone = request.getParameter("member_phone");
		log.info(member_phone);
		String member_email = request.getParameter("member_email");
		log.info(member_email);
		String member_auth = request.getParameter("member_auth");
		log.info(member_auth);
		MemberDTO memberDTO = new MemberDTO( );
		MemberDAO memberDAO = new MemberDAO( );
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_name(member_name);
		memberDTO.setMember_pw(member_pw);
		memberDTO.setMember_address(member_address);
		memberDTO.setMember_phone(member_phone);
		memberDTO.setMember_email(member_email);
		memberDTO.setMember_auth(member_auth);
		log.info(memberDTO);
		memberDTO = memberDAO.memberInsert(memberDTO);
		request.setAttribute("member_id", memberDTO.getMember_id( ));
		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/member/member_insert_view.jsp");
		return handlerAdapter;
	}

}