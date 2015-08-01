<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kenny
  Date: 01.08.2015
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>NEW USER</title>
  <h2>ADD DETAILS PLEASE</h2>
</head>
<body>

<form method="POST" action="/MyServlet" name="addUser">
    ID: <input type="text" readonly="readonly" name="id"
               value="<c:out value="${users.id}"/>"/> <br/>
    Name: <input type="text" name="name"
                 value="<c:out value="${users.name}"/>"/> <br/>
    Surname: <input type="text" name="surname"
                    value="<c:out value="${users.surname}"/>"/> <br/>
    Email: <input type="text" name="email"
                  value="<c:out value="${users.email}"/>"/> <br/>
    Phone: <input type="text" name="phone"
                  value="<c:out value="${users.phone}"/>"/> <br/>
            <input type="submit" value="Submit"/>


</form>

</body>
</html>
