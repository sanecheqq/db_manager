<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.04.2023
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <style><%@include file="/WEB-INF/view/css/style.css"%></style>
<%--    <link rel="stylesheet" href="./css/style.css" />--%>
    <title>All Employees</title>
</head>
    <body>
        <div class="container-employees">
            <div class="container-table">
                <h2 class="table-header">All Employees</h2>
                <table>
                    <tr>
                        <th class="table-block">Name</th>
                        <th class="table-block">Surname</th>
                        <th class="table-block">Department</th>
                        <th class="table-block">Salary</th>
                        <th class="table-block">Operations</th>
                    </tr>
                    <c:forEach var="employee" items="${allEmployees}">
                        <c:url var="updateButton" value="update-employee">
                            <c:param name="empId" value="${employee.id}"/>
                        </c:url>

                        <c:url var="deleteButton" value="delete-employee">
                            <c:param name="empId" value="${employee.id}"/>
                        </c:url>
                        <tr>
                            <td class="table-block">${employee.name}</td>
                            <td class="table-block">${employee.surname}</td>
                            <td class="table-block">${employee.department}</td>
                            <td class="table-block">${employee.salary}</td>
                            <td class="table-block">
                                <input class="table-update-button" type="button" name="Update" value="Update"
                                       onclick="window.location.href='${updateButton}'"/>
                                <input class="table-delete-button" type="button" name="Delete" value="Delete"
                                       onclick="window.location.href='${deleteButton}'"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <input class="input-button-add" type="button" value="Add"
                onclick="window.location.href = 'add-new-employee'">
        </div>
    </body>
</html>
