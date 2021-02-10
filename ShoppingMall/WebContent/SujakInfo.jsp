<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="white">
	<center>
		<h2><font color="yellow">수작업 공구 구매</font></h2>

		<form action="sutoolbuy.do" method="post">
			<table width="800" border="0" align="center">
				<tr align="center">
					<td rowspan="4" width="300">
						<img alt="" src="img/${sbean.suimg}" width="300">
					</td>
					<td align="center" width="100">
						<font color="white" size="2">공구명</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">${sbean.suname}</font>
					</td>
				</tr>
				<tr align="center">
					<td align="center" width="100">
						<font color="white" size="2">구매수량</font>
					</td>
					<td align="center" width="150">
						<select name="suqty" id="qtyid">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td align="center" width="100">
						<font color="white" size="2">판매금액</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">${sbean.suprice}원</font>
					</td>
				</tr>
				<tr align="center">
					<td align="center" colspan="2">
						<input type="hidden" name="suno" id="sunoid" value="${sbean.suno}">
						<input type="hidden" name="suimg" id="suimgid" value="${sbean.suimg}">
						<input type="hidden" name="suprice" id="supriceid" value="${sbean.suprice}">
						<input type="hidden" name="suname" id="sunameid" value="${sbean.suname}">
						
						<input type="button" onclick="location.href='sujak.do'" value="목록보기">
						<input type="hidden" onclick="cart()" value="카트담기">
						<input type="submit" value="구매하기">
					</td>
				</tr>
			</table>
		</form>
		<p>
		<hr color="yellow">
		<font color="white" size="2">
			<b>상품 상세보기</b>
			<p>${sbean.suinfo}</p>
		</font>
	</center>
</body>
</html>