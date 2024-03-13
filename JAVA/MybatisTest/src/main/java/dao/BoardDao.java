package dao;

import java.util.List;

import dto.Board;

public interface BoardDao {
	List<Board> selectBoardList(Integer row) throws Exception;
	Integer selectBoardCount() throws Exception;
	Board selectBoard(Integer num) throws Exception;
}
