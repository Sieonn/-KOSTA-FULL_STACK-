package service;

import javax.servlet.http.HttpServletRequest;

import dto.Board;

public interface MemberService {

	void MemberListByPage(HttpServletRequest request) throws Exception;

	Board memberDetail(Integer num) throws Exception;

	void memberWrite(HttpServletRequest request) throws Exception;

	void memberModify(HttpServletRequest request) throws Exception;

}
