package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/member/mypage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = null;
		MemberService service = new MemberService();
		String memberId = request.getParameter("memberId");
		member = service.selectOneById(memberId);
		request.setAttribute("member",member);
		if(member != null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp");
		    view.forward(request, response);
		}else {
			response.sendRedirect("/member/login.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("member-name");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		Member member = new Member(memberName, memberId, memberPw, memberEmail, memberPhone);
		MemberService service = new MemberService();
		//UPDATE MEMBER_TBL SET MEMBER_PW=?,MEMBER_EMAIL=?,MEMBER_PHONE=? WHERE MEMBER_ID=?
		int result = service.updateMember(member);
		if(result>0) {
			request.setAttribute("msg", "정보 수정이 완료되었습니다.");
			request.setAttribute("url", "/member/mypage.do?memberId="+ memberId); // 마이페이지 이동으로 수정 요망
			request.getRequestDispatcher("/common/success.do").forward(request, response);
		}else {
			request.setAttribute("msg", "정보 수정이 완료되지 않았습니다.");
			request.setAttribute("url", "/member/mypage.do?memberId="+ memberId); // 마이페이지 이동으로 수정 요망
			request.getRequestDispatcher("/common/fail.do").forward(request, response);
		}

	}

}
