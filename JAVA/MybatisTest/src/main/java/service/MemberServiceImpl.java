package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAOImpl;
import dao.MemderDAO;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	private MemderDAO memberDAO = new MemberDAOImpl();
	@Override
	public void join(HttpServletRequest request) throws Exception {
		// 확장성을 위해서 http이것을 사용
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Member smember = memberDAO.selectMember(id);
		if (smember != null) {
			throw new Exception("아이디 중복 오류");
		}
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Member member = new Member(id,name,password,email,address);
		memberDAO.insertMember(member);
	}
	@Override
	public void login(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member member = memberDAO.selectMember(id);
		
		if(member == null) {
			throw new Exception("아이디 틀림");
		}
		if (!member.getPassword().equals(password)) {
			throw new Exception("비밀번호 오류");
		}
		
		HttpSession session = request.getSession();
		member.setPassword("");
		session.setAttribute("user", member);
		// "user"는 메인jsp에 있는 유저
	}
	@Override
	public boolean memberIdCheck(String id) throws Exception {
		Member member = memberDAO.selectMember(id);
		if (member == null) {
			return false;
		}
		return true;
	}
	
}
