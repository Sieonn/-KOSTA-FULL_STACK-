package service;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
	void join(HttpServletRequest requset) throws Exception;
	void login(HttpServletRequest requset) throws Exception;
	boolean memberIdCheck(String id) throws Exception;
}
