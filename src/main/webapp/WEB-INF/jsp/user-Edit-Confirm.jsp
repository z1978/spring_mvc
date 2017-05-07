<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<body>
<form:form action="finish.html" method="POST" modelAttribute="form">
<form:hidden path="user.id"/>
<table border="1">
 <tr>
  <th><spring:message code="model.user.name" /><br></th>
  <td><spring:bind path="user.name">${status.value}</spring:bind></td>
 </tr>
 <tr>
  <th><spring:message code="model.user.age"/><br></th>
  <td><spring:bind path="user.age">${status.value}</spring:bind>
  <form:hidden path="user.age"/> </td>
 </tr>
 <tr>
  <th><spring:message code="model.user.upDate"/><br></th>
  <td><spring:bind path="user.upDate">${status.value}</spring:bind>
  <form:hidden path="user.upDate" /></td>
 </tr>
</table>

<input type="submit" value="完了" />
</form:form>
</body>
</html>
