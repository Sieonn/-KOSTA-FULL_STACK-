package service;

import javax.servlet.http.HttpServletRequest;

import dto.Board;

public interface BoardService {
	void boardListByPage(HttpServletRequest request) throws Exception;
	Board boardDetail(Integer num) throws Exception; 
}
