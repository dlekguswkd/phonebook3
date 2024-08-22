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

	<h2>전화번호-수정폼2</h2>

	<p>수정할 항목을 입력한 후 수정버튼을 클릭해 주세요</p>
	
	<form action="/phonebook3/edit" method="get">
		<div>
			<label for="txt-name">이름(name):</label> 	<!-- 원래는 requestScope.personMap.get("name")  -->
			<input id="txt-name" type="text" name="name" value="${personMap.name}" placeholder="">
		</div>
		
		<div>
			<label for="txt-hp">핸드폰(hp):</label> 
			<input id="txt-hp" type="text" name="hp" value="${personMap.hp}" placeholder="">
		</div>
		
		<div>
			<label for="txt-company">회사(company):</label> 
			<input id="txt-company" type="text" name="company" value="${personMap.company}" placeholder="">
		</div>
		
		<!-- <input type="text" name="action" value="update">  -->
		
		<!-- 			         주소에 나와지는거                원래 나의 데이터 -->
		<input type="hidden" name="personId" value="${personMap.person_id}">
		<br>
		<button type="submit">수정(전송)</button>
	</form>
	
	<br><br>
	<a href="/phonebook3/list">리스트로 가기</a>
	
	
</body>
</html>