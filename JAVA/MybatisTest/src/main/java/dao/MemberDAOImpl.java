package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Member;
import util.MybatisSqlSessionFactory;

public class MemberDAOImpl implements MemderDAO {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession(); 
	@Override
	public void insertMember(dto.Member member) throws Exception {
		sqlSession.insert("mapper.board.insertMember", member);
		sqlSession.commit();
		
	}
	@Override
	public Member selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectMember", id);
	}
	
}
