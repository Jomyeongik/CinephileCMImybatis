<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
		<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
        <title>공지사항</title>
        <link rel="stylesheet" href="/resources/css/mypage.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <h1>마이페이지</h1>
        <hr><hr>
        <div class="mypage">
            <div id="info">
                <img src="/resources/images/mypage.png" alt="마이페이지이미지">
                <br><br><br><br><br>
                <ul>
                    <li><a href="#">회원정보</a></li>
                    <li><a href="#">결제정보</a></li>
                    <li><a href="#">참여이력</a></li>
                </ul>
            </div>
            <div id="detailInfo">
                <h1>회원정보</h1>
                <div>
                	<form action="/member/mypage.do" method="post">
						<fieldset>
							<legend>회원 상세 정보</legend>
							<ul>
								<li>
									<label for="member-name">이름</label>
									<input type="text" id="member-name" name="member-name" value="${member.memberName }" readonly }> 
								</li>
								<br><br>
								<li>
									<label for="member-id">아이디</label>
									<input type="text" id="member-id" name="member-id"value="${member.memberId }" > 
								</li>
								<br><br>
								<li>
									<label for="member-pw">비밀번호</label>
									<input type="password" id="member-pw" name="member-pw" value="${member.memberPw}">
								</li>
								<br><br>
								<li>
									<label for="member-email">이메일</label>
									<input type="text" id="member-email" name="member-email"value="${member.memberEmail}"> 
								</li>
								<br><br>
								<li>
									<label for="member-phone">전화번호</label>
									<input type="text" id="member-phone" name="member-phone"value="${member.memberPhone}"> 
								</li>
								<br><br>
								<li>
									<label for="enroll-date">가입날짜</label>
									<input type="text" id="enroll-date"value="${member.enrollDate}" readonly> 
								</li>
							</ul>
							<input type="submit" value="수정">
							<a href="javascript:void(0)" onclick="checkDelete();">탈퇴하기</a>
						</fieldset>
					</form>
					<script>			
						function checkDelete(){
							const memberId = '${sessionScope.memberId }';
							if(confirm("탈퇴하시겠습니까?")){
								location.href="/member/delete.do?memberId="+memberId;
							}
						}
					</script>
                </div>
            </div>
        </div>
    </body>
</html>