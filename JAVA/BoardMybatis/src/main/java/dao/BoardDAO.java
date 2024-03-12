package dao;

import java.util.List;

import dto.Board;
import dto.File;

public interface BoardDAO {
	void insertDAO(Board board) throws Exception;
	void insertFile(File file) throws Exception;
	List<Board> selectBoardList(Integer row) throws Exception;
	Integer selectBoardCount() throws Exception;
}
