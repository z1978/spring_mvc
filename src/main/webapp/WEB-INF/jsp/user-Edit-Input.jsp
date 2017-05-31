<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="<c:url value="/resources/js/ajax_test.js" />"></script>
<html>
<body>

	<P>The time on the server is ${serverTime}.</P>
	<div id="ajax_data">
		<input type="button" id="ajax_btn" value="Ajax通信テスト" /><br />
	</div>
	<div id="ajax_data2">
		<input type="button" id="ajax_btn2" value="Ajax通信テスト2" /><br />
	</div>
	<div id="ajax_data3">
	<br /> outputData：
	<span id="output_data"></span>
	</div>
	<ul id="dateul">
		<li>Get time</li>
	</ul>
	<input type="button" value="显示时间" onclick="showDate(2);">

	<ul id="s">
		<li>11111111111111111</li>
		<li>22222222222222222</li>
		<li>33333333333333333</li>
		<li>44444444444444444</li>
		<li>55555555555555555</li>
	</ul>
	<input type="button" value="删除第2行" onclick="del(2);">
	<input type="button" value="删除第3行" onclick="del(3);">
	<input type="button" value="添加到最后行" onclick="add(-1,'最后行');">
	<input type="button" value="添加到第二行" onclick="add(2,'第二行');">

	<form:form action="confirm.html" method="POST" modelAttribute="form">
		<form:hidden path="user.id" />
		<table border="1">
			<tr>
				<th><spring:message code="model.user.name" /><br></th>
				<td><spring:bind path="user.name">${status.value}</spring:bind><br></td>
			</tr>
			<tr>
				<th><spring:message code="model.user.age" /><br></th>
				<td><form:input path="user.age" /><br> <form:errors
						path="user.age" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<th><spring:message code="model.user.upDate" /><br></th>
				<td><form:input path="user.upDate" maxlength="10" /><br>
					<form:errors path="user.upDate" cssStyle="color:red" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="確認" />
	</form:form>

</body>
</html>
