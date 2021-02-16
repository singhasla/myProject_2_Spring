<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
<h2> <font color="white"> 게시글 보기 </font> </h2>
	<table width="800" border="1" bordercolor="white">
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">글번호</font></td>
	<td align="center" width="600"><font color="white" size="2">${bean.num}</font></td>
	</tr>
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">조회수</font></td>
	<td align="center" width="600"><font color="white" size="2">${bean.readcount}</font></td>
	</tr>
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">작성자</font></td>
	<td align="center" width="600"><font color="white" size="2">${bean.writer}</font></td>
	</tr>
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">작성일</font></td>
	<td align="center" width="600"><font color="white" size="2">${bean.reg_date}</font></td>
	</tr>
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">제목</font></td>
	<td align="center" width="600"><font color="white" size="2">${bean.subject}</font></td>
	</tr>
	<tr height="40">
	<td align="center" width="200"> <font color="white" size="2">내용</font></td>
	<td align="center" width="600">
	<textarea rows="10" cols="60" >${bean.content}
		</textarea></td>
	</tr>
	<tr height="40">
	<td align="center" colspan="2"> 
	<input type="button" value="답글쓰기" onclick="location.href='boardrewrite.do?num=${bean.num}&ref=${bean.ref}&re_step=${bean.re_step}&re_level=${bean.re_level}'">
	
	<input type="button" value="수정하기" onclick="location.href='boardupdate.do?num=${bean.num}&subject=${bean.subject}&content=${bean.content}&writer=${bean.writer}'">
	
	<input type="button" value="삭제하기" onclick="location.href='boarddelete.do?num=${bean.num}'">
	
	<input type="button" value="전체글보기" onclick="location.href='board.do'">
	
	</td>
	</tr>
	
	</table>


</center>

</body>
</html>