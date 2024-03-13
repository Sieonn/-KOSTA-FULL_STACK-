package dao;

import java.lang.reflect.Member;
import java.util.List;

import dto.BFile;
import dto.Board;

public interface MemberDao {

	double selectMemberCount();

	List<Member> selectMemberList(int row);

	void updateMemberViewCount(Integer num);

	Board selectMember(Integer num);

	void insertFile(BFile bFile);

	double selectMemberCount();

	double selectMemberCount();

}
