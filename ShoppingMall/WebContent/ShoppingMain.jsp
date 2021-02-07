<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<center>
	<c:set var="center" value="${center}"/>
	<c:set var="left" value="${left}"/>
	
	<c:if test="${center==null}">
		<c:set var="center" value="Center.jsp"/>
	</c:if>
	
	<table width="1000">
		<tr height="80" align="center">
			<td align="center" colspan="2"><jsp:include page="Top.jsp"/></td>
		</tr>
		
		<tr height="470" align="center" valign="top">
			<c:if test="${left==null}">
				<td align="center">
					<jsp:include page="${center}"/>
				</td>
			</c:if>
			<c:if test="${left!=null}">
				<td align="center" width="200">
					<jsp:include page="${left}"/>
				</td>
			</c:if>
		</tr>
	</table>
</center>
</body>
</html>