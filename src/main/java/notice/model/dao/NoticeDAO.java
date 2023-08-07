package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertDao(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice",notice);
		return result;
	}

	public List<Notice> selectNoticeList(SqlSession session) {
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList");
		return nList;
	}

	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

}
