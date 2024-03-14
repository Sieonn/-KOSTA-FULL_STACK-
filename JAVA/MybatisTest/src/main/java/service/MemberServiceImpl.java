package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public void join(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		Member smember = memberDao.selectMember(id);
		if(smember!=null) throw new Exception("아이디 중복 오류");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Member member = new Member(id,name,password,email,address);
		memberDao.insertMember(member);
	}

	@Override
	public void login(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = memberDao.selectMember(id);
		if(member==null) throw new Exception("아이디 오류");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호 오류");
		
		//로그인 정상
		HttpSession session = request.getSession();
		member.setPassword("");
		session.setAttribute("user", member);
	}

	@Override
	public boolean memberIdCheck(String id) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) return false;
		return true;
	}
}
