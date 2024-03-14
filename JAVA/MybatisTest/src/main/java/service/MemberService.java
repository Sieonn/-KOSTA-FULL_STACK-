package service;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {
	void join(HttpServletRequest request) throws Exception;
	
	void login(HttpServletRequest request) throws Exception;
	
	boolean memberIdCheck(String id) throws Exception;
}
