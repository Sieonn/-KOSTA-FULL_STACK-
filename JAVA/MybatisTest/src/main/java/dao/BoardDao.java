package dao;

import java.util.List;

import dto.Board;
import dto.BFile;

public interface BoardDao {
	List<Board> selectBoardList(Integer row) throws Exception;
	Integer selectBoardCount() throws Exception;
	Board selectBoard(Integer num) throws Exception;
	void insertBoard(Board board) throws Exception;
	void insertFile(BFile file) throws Exception;
	void updateBoard(Board board) throws Exception;
	void updateBoardViewCount(Integer num) throws Exception;
}
