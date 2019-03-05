<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update customers</title>

    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/add-edit-customer-style.css">
</head>

<body>

<header>
    <div id="title">
        <h2>Customer - CRUD Application</h2>
    </div>
</header>

<button type="button" id="backButton" onclick="window.location.href='list'">back</button>

<br>
<br>


<div id="container">

    <c:url var="editUrl" value="/customer/edit"/>

    <fieldset>
    <legend>Edit an existing customer here</legend>

        <form:form method="post" action="${editUrl}" modelAttribute="customer">

            <div class="table">
                <table>
                    <tr>
                        <td><form:label path="firstName">First name</form:label></td>
                        <td><form:input path="firstName" placeholder="${customer.firstName}"></form:input></td></td>
                    </tr>
                </table>

                <c:set var="error"><form:errors path="firstName"/></c:set>
                <c:if test="${not empty error}">
                    <div class="error">
                            ${error}
                    </div>
                </c:if>
            </div>

            <div class="table">
                <table>
                    <tr>
                        <td><form:label path="lastName">Last name</form:label></td>
                        <td><form:input path="lastName" placeholder="${customer.lastName}"></form:input></td></td>
                    </tr>
                </table>

                <c:set var="error"><form:errors path="lastName"/></c:set>
                <c:if test="${not empty error}">
                    <div class="error">
                            ${error}
                    </div>
                </c:if>
            </div>

            <div class="table">
                <table>
                    <tr>
                        <td><form:label path="email">E-Mail</form:label></td>
                        <td><form:input path="email" placeholder="${customer.email}"></form:input></td>
                    </tr>
                </table>
                <c:set var="error"><form:errors path="email"/></c:set>
                <c:if test="${not empty error}">
                    <div class="error">
                            ${error}
                    </div>
                </c:if>
            </div>

            <br>

            <form:hidden path="id" value="${customerId}"></form:hidden>
            <form:button>save</form:button>

        </form:form>
    </fieldset>

</div>

</body>

</html>
