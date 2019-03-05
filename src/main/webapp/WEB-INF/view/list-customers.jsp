<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>

    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/list-customer-style.css">
</head>

<body>

<header>
    <div id="title">
        <h2>Customer - CRUD Application</h2>
    </div>
</header>

<button id="addButton" type="button" onclick="window.location.href='showAddCustomerForm'"></button>
Add a new customer

<div id="container">

    <c:set var="counter" value="0"/>
    <c:set var="rowColor" value="white"/>


    <div id="content">

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">
                <c:set var="counter" value="${counter + 1}"/>


                <c:url var="editLink" value="/customer/showEditCustomerForm">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>


                <c:choose>
                    <c:when test="${counter % 2 == 0}">
                        <c:set var="rowColor" value="lightgrey"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="rowColor" value="white"/>
                    </c:otherwise>
                </c:choose>

                <tr style="background: ${rowColor}">
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                    <td>
                        <a href="${editLink}">
                            <img src="https://img.icons8.com/metro/18/000000/edit.png">
                        </a>
                    </td>

                    <td>
                        <a href="${deleteLink}">
                            <img src="https://img.icons8.com/windows/22/000000/trash.png">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <span>hits: ${counter}</span>
</div>

<br>
<br>

<footer>
   <span id="icons">
    <a href="https://icons8.com/icon/48/edit">Edit icon by Icons8</a> |
    <a href="https://icons8.com/icon/14237/trash">Trash icon by Icons8</a> |
    <a href="https://icons8.com/icon/2/add-user-male">Add User Male icon by Icons8</a>
   </span>
</footer>

</body>
</html>
