package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import dto.BFile;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
//	private SqlSession sqlSession = new MybatisSqlSession.getSqlSession().openSession();
	
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList",row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard", num);
	}
	// 파라미터 값이 있으면 써줘야 하고 없으면 없이 그대로

	@Override
	public void insertBoard(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard",board);
		sqlSession.commit();
		
	}

	@Override
	public void insertFile(BFile file) throws Exception {
		sqlSession.insert("mapper.board.insertFile",file);
		sqlSession.commit();
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoardViewCount", board);
		sqlSession.commit();
	}

	@Override
	public void updateBoardViewCount(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateBoardViewCount", num);
		sqlSession.commit();
	}
}
