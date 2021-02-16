<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
<h2> <font color="white"> 게시글 삭제 </font> </h2>
	<form action="boarddeleteproc.do" method="post">
	<input type="hidden" name="num" value="${num}">
	<table width="800" border="1" bordercolor="white"> 
	<tr height="40">
		<td width="200"><font size="2" color="white">비밀번호</font></td>
		<td width="600"><input type="password" name="passwd"> </td>
	</tr>
	<tr height="40">
		<td colspan="2">
		<input type="submit" value="삭제하기"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="게시글 보기" onclick="location.href='board.do'">		
		</td>
	</tr>
	</table>
	</form>
</center>
</body>
</html>