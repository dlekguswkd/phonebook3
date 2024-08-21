<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>

	<h2>전화번호-수정폼</h2>

	<p>수정할 항목을 입력한 후 수정버튼을 클릭해 주세요</p>
	
	<form action="/phonebook3/edit" method="get">
		<div>
			<label for="txt-name">이름(name):</label> 
			<input id="txt-name" type="text" name="name" value="${personVo.name}" placeholder="">
		</div>
		
		<div>
			<label for="txt-hp">핸드폰(hp):</label> 
			<input id="txt-hp" type="text" name="hp" value="${personVo.hp}" placeholder="">
		</div>
		
		<div>
			<label for="txt-company">회사(company):</label> 
			<input id="txt-company" type="text" name="company" value="${personVo.company}" placeholder="">
		</div>
		
		<!-- <input type="text" name="action" value="update">  -->
		
		<!-- 			 여기 name에 no가 아닌 personId로 넣어야함	어느것을 바꿀것인지 알려주는 역할   -->
		<input type="hidden" name="personId" value="${personVo.personId}">
		<br>
		<button type="submit">수정(전송)</button>
	</form>
	
	<br><br>
	<a href="/phonebook3/list">리스트로 가기</a>
	
	
</body>
</html>