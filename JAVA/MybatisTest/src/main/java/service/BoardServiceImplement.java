package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.bytecode.analysis.MultiArrayType;

import dao.BoardDao;
import dao.BoardDaoImplement;
import dto.Board;
import util.PageInfo;

public class BoardServiceImplement implements BoardService {
	private BoardDao boardDao=new BoardDaoImplement();
	
	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		//1. 페이지를 가져오고 없으면 페이지번호를 1로 한다.
		Integer page=1;
		String pageNo=request.getParameter("page");
		if(pageNo!=null) {
			page=Integer.parseInt(pageNo);
		}
		
		//2. PageInfo 계산하여 설정하기
		int maxPage=(int)Math.ceil((double)boardDao.selectBoardCount()/10);
		int startPage=(page-1)/10*10+1; //페이지 10을 고려하여 page-1을 한다.
		int endPage=startPage+10-1;
		if(endPage>maxPage) endPage=maxPage;
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		//3.해당 페이지에 해당하는 게시판 글 목록 조회
		int row=(page-1)*10;
		List<Board> boardList=boardDao.selectBoardList(row);
		
		//4.응답으로 보내기 위해 request영역에 담는다
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", boardList);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		return boardDao.selectBoard(num);
	}
public void boardModify(HttpServletRequest request) throws Exception{
	File file = MultiArrayType.getFile("file");
	if(file !=null) {
		BFile
	}
}
}
