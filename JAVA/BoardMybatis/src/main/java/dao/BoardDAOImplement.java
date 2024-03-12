package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import dto.File;
import util.MybatisSqlSessionFactory;

public class BoardDAOImplement implements BoardDAO {
	SqlSession sqlSession=MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertDAO(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);
		sqlSession.commit();
	}

	@Override
	public void insertFile(File file) throws Exception {
		sqlSession.insert("mapper.board.insertFile", file);
		sqlSession.commit();
	}

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList", row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}
	
}
