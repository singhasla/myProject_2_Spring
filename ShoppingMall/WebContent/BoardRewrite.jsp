<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<h2> <font color="white"> 답글 쓰기  </font> </h2>
	<form action="boardrewriteproc.do" method="post">
	<input type="hidden" name="num" value="${bean.num}">
	<input type="hidden" name="ref" value="${bean.ref}">
	<input type="hidden" name="re_step" value="${bean.re_step}">
	<input type="hidden" name="re_level" value="${bean.re_level}">
	
	<table width="800" border="1" bordercolor="white" align="center">
	<tr height="40">
		<td align="center" width="200"><font color="white" size="2"> 이름  </font></td>
		<td align="left" width="600">
			<input type="text" name="writer" size="40"></td>
	</tr>		
	<tr height="40">
		<td align="center" width="200"><font color="white" size="2"> 제목 </font> </td>
		<td align="left" width="600">
			<input type="text" name="subject" size="40" value=" [답글] "></td>
	</tr>
	<tr height="40">
		<td align="center" width="200"><font color="white" size="2"> 이메일  </font></td>
		<td align="left" width="600">
			<input type="text" name="email" size="40"></td>
	</tr>
	<tr height="40">
		<td align="center" width="200"> <font color="white" size="2">글내용  </font></td>
		<td align="left" width="600">
			<textarea rows="13" cols="60" name="content"></textarea>
		</td>
	</tr>
	<tr height="40">
		<td align="center" width="200"><font color="white" size="2"> 패스워드 </font></td>
		<td align="left" width="600">
			<input type="password" name="passwd" size="40"></td>
	</tr>
	<tr height="40">
		<td align="center" colspan="2"> 
		<input type="submit" value="답글쓰기완료">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="다시쓰기">&nbsp;&nbsp;&nbsp;
		<input type="button" value="전체글보기" 
		  onclick="location.href='board.do'">		
		</td>
	</tr>	
	</table>
	</form>
</center>
</body>
</html>