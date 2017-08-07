<%--
  Created by IntelliJ IDEA.
  User: Meeliana
  Date: 8/7/2017
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>

    <tr>
        <td>ID :</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Username :</td>
        <td>${Username}</td>
    </tr>
    <tr>
        <td>password :</td>
        <td>${Password}</td>
    </tr>
</table>
<div class="col-sm-4">
    <h3>Educational Background</h3>
    <p>Education</p>
    <c:forEach var="Educ" items="${listofCon}" >
       <c:out value = "${Educ}"/>
    </c:forEach>

</div>
</body>
</html>
