<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Meeliana
  Date: 8/7/2017
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/register" modelAttribute="modelatt">
    <table>
        <tr>
            <td><form:label path="Id">ID Number: </form:label></td>
            <td><form:input disabled="true" path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="fname">First Name</form:label></td>
            <td><form:input path="fname"/></td>
        </tr>
        <tr>
            <td><form:label path="lname">Last Name</form:label></td>
            <td><form:input path="lname"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
