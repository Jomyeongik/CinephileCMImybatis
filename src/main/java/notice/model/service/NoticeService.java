package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO nDao;

	public NoticeService() {
		nDao = new NoticeDAO();
	}
	
	public int insertNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.insertDao(session,notice);
		if(result >0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	public List<Notice> selectNoticeList() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = new ArrayList<>();
		nList = nDao.selectNoticeList(session);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOneByNo(session,noticeNo);
		session.close();
		return notice;
	}

}
