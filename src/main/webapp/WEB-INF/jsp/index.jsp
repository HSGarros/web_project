<%--
  Created by IntelliJ IDEA.
  User: guoqi
  Date: 2021/11/11
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h2>table</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>inserttime</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.getId()}</th>
            <th>${user.getName()}</th>
            <th>${user.getInserttime()}</th>
        </tr>

    </c:forEach>
</table>
<hr>
<h2>update</h2>
<form action="update" method="post">
    <select name="uid" id="uid">
        <c:forEach items="${users}" var="user">
            <option value="${user.getId()}">${user.getName()}</option>
        </c:forEach>
    </select>
    <input type="text" name="rename" required>
    <button type="submit">submit</button>
</form>
<hr>
<h2>query</h2>
<ul>
    <c:forEach items="${users}" var="user">
        <li><a href="query?id=${user.getId()}">${user.getName()}</a></li>
    </c:forEach>
</ul>
</body>
</html>
