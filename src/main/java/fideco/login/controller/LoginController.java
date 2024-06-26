package fideco.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fideco.member.dao.MemberDAO;
import fideco.member.dto.MemberDTO;
import fideco.control.Controller;
import fideco.handler.HandlerAdapter;

public class LoginController implements Controller {
	private static Log log = LogFactory.getLog(LoginController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		log.info(member_id+ "sdfhsf");
		
	
		String member_pw = request.getParameter("member_pw");
		log.info(member_pw+ "sdfhsf");
		
		String member_name = request.getParameter("member_name");
		log.info(member_name+ "sdfhsf");
		
		String save = request.getParameter("save");
		log.info(save);
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_pw(member_pw);
		log.info(memberDTO);

		MemberDAO memberDAO = new MemberDAO( );
		memberDTO = memberDAO.memberLogin(memberDTO);
		log.info("로그인 내용" + memberDTO);
		request.setAttribute("member_name", memberDTO.getMember_name( ));
	request.setAttribute("memberDTO", memberDTO);
		if(!memberDTO.getMember_id( ).equals("") & !memberDTO.getMember_pw( ).equals("")) {
			HttpSession httpSession = request.getSession( );
			httpSession.setAttribute("member_id", memberDTO.getMember_id( ));
			httpSession.setAttribute("member_name", memberDTO.getMember_name( ));
			Cookie cookie = new Cookie("member_id", memberDTO.getMember_id( ));
			cookie.setMaxAge(60 * 60 * 24);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		HandlerAdapter handlerAdapter = new HandlerAdapter( );
		handlerAdapter.setPath("/WEB-INF/view/login/login_check.jsp");
		return handlerAdapter;
	}

}
