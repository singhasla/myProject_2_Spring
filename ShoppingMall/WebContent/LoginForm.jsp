<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<!-- 로그인 정보 확인 -->
<c:if test="${login==1}">
	<script type="text/javascript">
		alert("아이디 & 패스워드를 확인하세요");
	</script>
</c:if>

	<center>
		<h2><font color="white">회원 로그인</font></h2>

		<form action="loginproc.do" method="post">
			<table width="500">
				<tr height="40">
					<td width="200" align="center">
						<font size="2" color="white">아이디</font>
					</td>
					<td width="200" align="center">
						<input type="text" name="memid" size="30">
					</td>
				</tr>
				<tr height="40">
					<td width="200" align="center">
						<font size="2" color="white">패스워드</font>
					</td>
					<td width="200" align="center">
						<input type="password" name="mempasswd1" size="30">
					</td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center">
						<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2" color="white">아이디 / 패스워드 찾기</font>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>