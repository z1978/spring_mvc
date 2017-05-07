<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<form:form action="confirm.html" method="POST" modelAttribute="form">
<form:hidden path="user.id"/>
<table border="1">
 <tr>
  <th><spring:message code="model.user.name" /><br></th>
  <td><spring:bind path="user.name">${status.value}</spring:bind><br></td>
 </tr>
 <tr>
  <th><spring:message code="model.user.age"/><br></th>
  <td><form:input path="user.age"/><br><form:errors path="user.age" cssStyle="color:red"/></td>
 </tr>
 <tr>
  <th><spring:message code="model.user.upDate"/><br></th>
  <td><form:input path="user.upDate" maxlength="10"/><br><form:errors path="user.upDate" cssStyle="color:red"/></td>
 </tr>
</table>
<br>
 <input type="submit" value="確認" />
</form:form>

</body>
</html>
