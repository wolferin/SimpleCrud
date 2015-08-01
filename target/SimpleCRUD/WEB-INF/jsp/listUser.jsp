<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kenny
  Date: 01.08.2015
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>LIST</title>
    <h2>USER LISR</h2>

</head>
<body>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Phone</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
<tbody>
<%--@elvariable id="users" type="java.util.List"--%>
        <c:forEach items="${users}" var="user">
                <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.surname}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.phone}"/></td>
            <td><a href="index?action=edit&id=<c:out value="${user.id}"/>"> Edit </a></td>
            <td><a href="index?action=delete&id=<c:out value="${user.id}"/>"> Delete </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<p><a href="index?action=addUser">Add User</a></p>
</body>
</html>
