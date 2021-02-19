<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<!-- 아이디 중복체크 -->
<c:if test="${result==1}">
	<script type="text/javascript">
		alert("해당 아이디가 존재합니다. 다시 입력해 주세요.");
	</script>
</c:if>

<!-- 비밀번호 확인 -->
<c:if test="${result==2}">
	<script type="text/javascript">
		alert("패스워드가 틀립니다. 다시 입력해 주세요.");
	</script>
</c:if>

	<center>
		<h2><font color="white">회원가입</font></h2>

		<form action="joinproc.do" method="post">
			<table width="400" border="0" cellspacing="1" cellpadding="4">
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">아이디</font>
					</td>
					<td width="220">
						<input type="text" name="memid" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">패스워드</font>
					</td>
					<td width="220">
						<input type="password" name="mempasswd1" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">패스워드 확인</font>
					</td>
					<td width="220">
						<input type="password" name="mempasswd2" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">이름</font>
					</td>
					<td width="220">
						<input type="text" name="memname" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">전화번호</font>
					</td>
					<td width="220">
						<input type="text" name="memphone" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180">
						<font color="white" size="3">생년월일</font>
					</td>
					<td width="220">
						<input type="date" name="memdate" size="20">
					</td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center">
						<input type="submit" value="회원가입"> &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>