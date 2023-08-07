package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertDao(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice",notice);
		return result;
	}

	public List<Notice> selectNoticeList(SqlSession session,int currentPage) {
		int limit = 10;
		int offset= (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList",null,rowBounds);
		return nList;
	}

	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int updateDao(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.updateNotice",notice);
		return result;
	}

	public int deleteDao(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public String generatePageNavi(SqlSession session,int currentPage) {
		int totalCount = getTotalCount(session);
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		int totalNaviCount;
		if(totalCount%recordCountPerPage >0) {
			totalNaviCount = totalCount/ recordCountPerPage+1;			
		}else {
			totalNaviCount = totalCount/ recordCountPerPage;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage +1;
		int endNavi = startNavi + naviCountPerPage -1;
		if(endNavi>totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == totalNaviCount) {
			needNext = false;
		}
		if(needPrev) result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"''>[이전]</a>");
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/notice/list.do?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;");			
		}
		if(needNext) {
			result.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}

	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}

}
