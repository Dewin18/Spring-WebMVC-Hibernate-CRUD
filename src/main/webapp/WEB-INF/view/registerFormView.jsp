<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Master
  Date: 24.01.2019
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>



    <form:form method="POST" action="confirmation" modelAttribute="user" >
    <fieldset>
        <legend>Registration</legend>

        <form:label path="firstName">First name: </form:label>
        <form:input path="firstName" />

        <br> <br>

        <form:label path="lastName">Last name: </form:label>
        <form:input path="lastName" />

        <br> <br>

        <form:label path="email">E-Mail: </form:label>
        <form:input path="email" />

        <br> <br>

        <button type="submit">register</button>
    </fieldset>
    </form:form>

    <h1>Register here ;-)</h1>
</body>
</html>
