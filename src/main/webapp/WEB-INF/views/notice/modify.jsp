<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
		<title>공지사항 수정</title>
		<link rel="stylesheet" href="/resources/css/noticeDetail.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<h1>공지사항 수정</h1>
		<form action="/notice/modify.do" method="post">
			<input type="hidden" name="noticeNo" value = '${notice.noticeNo }'>
			<fieldset>
				<legend>공지사항 수정</legend>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" id="" name="noticeSubject" value="${notice.noticeSubject }">
					</li>
					<li>
						<label>내용</label>
						<textarea rows="30" cols="40" id="" name="noticeContent">${notice.noticeContent }</textarea>
					</li>
				</ul>
			</fieldset>
			<div id="btn1">
				<input type="submit" class="btn" value="수정">
				<input type="reset" class="btn" value="초기화">
			</div>
		</form>
	</body>
</html>