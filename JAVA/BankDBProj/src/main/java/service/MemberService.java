package service;

import dto.Member;

public interface MemberService {
	void join(Member member) throws Exception;
	void login(String id, String password) throws Exception;

}
