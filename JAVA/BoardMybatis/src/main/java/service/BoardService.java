package service;

import javax.servlet.http.HttpServletRequest;


public interface BoardService {
	void boardWrite(HttpServletRequest request) throws Exception;
	void boardListByPage(HttpServletRequest request) throws Exception;
}
