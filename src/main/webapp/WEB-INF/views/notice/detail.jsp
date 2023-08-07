<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
		<title>공지사항 상세조회</title>
		<link rel="stylesheet" href="/resources/css/noticeDetail.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<h1>공지사항 상세</h1>
		<br><br><br><br><br><br>
		<div id="detail">
			<ul>
				<li>
					<label>글번호:  </label>
					<span>${notice.noticeNo }</span>
				</li>
				<br><br>
				<li>
					<label>작성일:  </label>
					<span>${notice.noticeDate }</span>
				</li>
				<br><br>
				<li>
					<label>글쓴이:  </label>
					<span>${notice.noticeWriter }</span>
				</li>
				<br><br>
				<li>
					<label>제목:  </label>
					<span>${notice.noticeSubject }</span>
				</li>
				<br><br>
				<li>
					<label>내용:  </label>
					<p>${notice.noticeContent }</p>
				</li>
			</ul>
			<a href="/notice/list.do">목록으로 이동</a>
			<a href="/notice/modify.do?noticeNo=${notice.noticeNo }">수정하기</a>
			<a href="javascript:void(0)" onclick="deleteCheck();">삭제하기</a>
		</div>
		<script>
			const deleteCheck = ()=>{
				const noticeNo = '${notice.noticeNo }';
				if(confirm("삭제 하시겠습니까?")){
					location.href="/notice/delete.do?noticeNo="+noticeNo;
				}
			}
		</script>
	</body>
</html>