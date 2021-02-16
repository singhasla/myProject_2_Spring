<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<center>
	<h2><font color="white"> 게시글 보기  </font> </h2>
	<table width="800" border="1" bordercolor="white" bgcolor="black">
	<tr height="40">
		<td colspan="5" align="right">
		<a href="boardwrite.do" style="text-decoration:none">
		<font size="3" color="white"> 질문글쓰기 </font>
		</a></td>
	</tr>
	<tr height="40">
		<th width="50"><font size="2" color="white"> 번호 </font></th>
		<th width="300"><font size="2" color="white"> 제목 </font></th>
		<th width="100"><font size="2" color="white"> 작성자 </font></th>
		<th width="150"><font size="2" color="white"> 작성일 </font></th>
		<th width="100"><font size="2" color="white"> 조회수 </font></th>
	</tr>	
	<c:if test="${vbean !=null}">
	<c:forEach var="vbean" items="${vbean}">
	<tr height="40">
		<td align="center"><font size="2" color="white"> ${number} </font></td>
		<td align="center"><font size="2" color="white">
			<c:forEach var="j" begin="1" end="${vbean.re_step}" step="${j+1}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
			</c:forEach>
			<a href="boardinfo.do?num=${vbean.num}"> ${vbean.subject}   </a>
		</font></td>
		<td align="center"><font size="2" color="white"> ${vbean.writer}</font></td>
		<td align="center"><font size="2" color="white"> ${vbean.reg_date} </font></td>
		<td align="center"><font size="2" color="white"> ${vbean.readcount} </font></td>
		<c:set  var="number" value="${number-1}" />
	</tr>	
	</c:forEach>	
	</c:if>	
	</table>
	<p>
	<!-- 페이지 타운터링 소스 작성 -->
	<c:if test="${count >0}" >
	<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0 ? 0 : 1)}" />
	<!-- 시작 페이지 숫자를 설정 -->
	<c:set var="startPage" value="${1}" />
	<c:if test="${currentPage %10 != 0}">
		<fmt:parseNumber var="result" value="${currentPage/10}"
		integerOnly="true"	/>
		
		<c:set var="startPage" value="${result*10 +1}" />
		
	</c:if>
	<c:if test="${currentPage %10 == 0}">
		<c:set var="startPage" value="${(result-1)*10 +1}" />	
	</c:if>
	
	<!-- 화면에 보여질 페이징 처리 숫자를 표현 [1][2]... -->
	<c:set var="pageBlock" value="${10}" />
	<c:set var="endPage"  value="${startPage+pageBlock-1}" />
	
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}" />	
	</c:if>
	<!-- 이전이라는 링크를 걸지 파악  -->
	<c:if test="${startPage > 10}">
		<a href="board.do?pageNum=${startPage-10}"> [이전] </a>
	</c:if>
	
	<!-- 페이징 처리 -->
	<c:forEach var="i" begin="${startPage}" end="${endPage }">
		<a href="board.do?pageNum=${i}"> [${i}] </a>
	</c:forEach>	
	
	<!-- 다음 이라는 링크를 걸지 파악 -->	
	<c:if test="${endPage < pageCount}">
		<a href="board.do?pageNum=${startPage+10}"> [다음] </a>
	</c:if>	
	</c:if>	
</center>
</body>
</html>