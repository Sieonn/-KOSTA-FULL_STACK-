package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDaoImplement implements BoardDao {
	private SqlSession sqlSession=MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList", row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard",num);
	}
}
