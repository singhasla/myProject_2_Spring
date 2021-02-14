<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="white">
	<center>
		<h2><font color="yellow">결제 완료 페이지</font></h2>

			<table width="800">
				<tr height="40">
					<td align="center" width="200">
						<font color="white" size="2">상품이미지</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">상품명</font>
					</td>
					<td align="center" width="100">
						<font color="white" size="2">상품가격</font>
					</td>
					<td align="center" width="100">
						<font color="white" size="2">상품수량</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">상품총금액</font>
					</td>
				</tr>

				<c:if test="${sessionScope.cart == null}">
					<tr height="80">
						<td align="center"><img src="img/${subean.suimg}" width="180" height="70"></td>
						<td align="center"><font color="white" size="2">${subean.suname}</font></td>
						<td align="center"><font color="white" size="2">${subean.suprice}</font></td>
						<td align="center"><font color="white" size="2">${subean.suqty}</font></td>
						<td align="center"><font color="white" size="2">${subean.suprice * subean.suqty}원</font></td>
					</tr>
				</c:if>
				
				<c:set var="total" value="${subean.suprice * subean.suqty}"/>
				<tr height="70">
					<td align="center" colspan="5">
						<font color="red" size="5">총 결제금액은 ${total}원 입니다.</font>
					</td>
				</tr>
				<tr height="70">
					<td align="center" colspan="5">
						<input type="button" onclick="location.href='index.do'" value="계산완료하기">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" onclick="location.href='index.do'" value="취소하기">
					</td>
				</tr>
			</table>
	</center>
</body>
</html>