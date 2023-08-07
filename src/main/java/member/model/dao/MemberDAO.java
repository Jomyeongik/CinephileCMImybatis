package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

	public Member selectCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin",member);
		return mOne;
	}

	public Member selectOneById(SqlSession session, String memberId) {
		Member mOne = session.selectOne("MemberMapper.selectOneById",memberId);
		return mOne;
	}

}
