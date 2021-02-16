<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
	<h2><font color="white"> 게시글 수정하기 </font> </h2>
	<form action="boardupdateproc.do" method="post">
	<input type="hidden" name="num" value="${bean.num}">
	<table width="800" border="1" bordercolor="white">
	<tr	height="40">
		<td width="200"><font size="2" color="white">작성자</font></td>
		<td width="600"><font size="2" color="white">${bean.writer} </font></td>
	</tr>
	<tr	height="40">
		<td width="200"><font size="2" color="white">제목</font></td>
		<td width="600"><font size="2" color="white">${bean.subject} </font></td>
	</tr>
	<tr	height="40">
		<td width="200"><font size="2" color="white">게시글 내용</font></td>
		<td width="600"><textarea rows="4" cols="50" name="content">${bean.content}  </textarea>  </td>
	</tr>
	<tr	height="40">
		<td width="200"><font size="2" color="white">패스워드</font></td>
		<td width="600"><input type="password" name="passwd"> </td>
	</tr>
	 <tr height="40">
	 	<td colspan="2">
	 	<input type="submit" value="수정완료"> &nbsp;&nbsp;&nbsp;
	 	<input type="reset" value="다시쓰기"></td>
	 </tr>	
	</table>	
	</form>	
	</center>
</body>
</html>




