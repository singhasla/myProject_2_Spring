<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="black">
<center>
	<table width="1000" height="5">
		<tr height="50">
			<td align="left" width="500">
				<a href="ShoppingMain.jsp">
					<img alt="" src="img/logo.JPG" border="0" align="left">
				</a>
			</td>
			
			<c:if test="${mbean==null}">
				<td align="right" width="300">
					<input type="button" onclick="location.href='login.do'" value="로그인">
					&nbsp;&nbsp;&nbsp;
					<input type="button" onclick="location.href='joinform.do'" value="회원가입">
				</td>
			</c:if>
			<c:if test="${mbean!=null}">
				<td align="right" width="300">
					<font size="3" color="white">${mbean.memid}님 환영합니다.</font>
					&nbsp;&nbsp;&nbsp;
					<input type="button" onclick="location.href='logout.do'" value="로그아웃">
				</td>
			</c:if>
		</tr>
	</table>
	
	<!-- 상단메뉴 -->
	<table width="1000" height="5">
		<tr>
			<td align="center" bgcolor="black">
				<a href="sujak.do"><!-- 수작업공구 -->
					<img src="img/sujak.JPG">
				</a>
			</td>
			<td align="center" bgcolor="black">
				<a href="#"><!-- 전동공구(jundong.do) -->
					<img src="img/jundong.JPG">
				</a>
			</td>
			<td align="center" bgcolor="black">
				<a href="stanlyinfo.do"><!-- 스텐리 소개 -->
					<img src="img/stanlyinfo.JPG">
				</a>
			</td>
			<td align="center" bgcolor="black">
				<a href="tooluse.do"><!-- 공구사용법 -->
					<img src="img/tooluse.JPG">
				</a>
			</td>
			<td align="center" bgcolor="black">
				<a href="download.do"><!-- 다운로드 -->
					<img src="img/download.JPG">
				</a>
			</td>
			<td align="center" bgcolor="black">
				<a href="board.do"><!-- 고객센터 -->
					<img src="img/gogak.JPG">
				</a>
			</td>
		</tr>
	</table>
</center>
</body>
</html>