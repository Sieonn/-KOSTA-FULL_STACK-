package service;

import dao.BoardLikeDao;
import dao.BoardLikeDaoImpl;

public abstract class BoardLikeServiceImpl implements BoardLikeService {
	private BoardLikeDao boardLikeDao = new BoardLikeDaoImpl();
	@Override
	public boolean boardLike(String memberId, Integer boardNum) throws Exception {
		Integer num = boardLikeDao.selectBoardLike(memberId, boardNum);
		if(num==null) return false;
		return true;
	}
}
