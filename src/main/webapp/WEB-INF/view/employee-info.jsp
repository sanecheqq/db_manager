<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.04.2023
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <style><%@include file="/WEB-INF/view/css/style.css"%></style>
    <title>Employee info form</title>
</head>
    <body>
    <div class="container-employees">
        <div class="container-form">
            <h2>Employee info</h2>
            <form:form class="form-form-object" action="save-employee" modelAttribute="newEmployee">
                <form:hidden path="id"/>
                <a class="form-input-header">Name</a>
                <form:input class="form-input-data" path="name"/>
                <form:errors path="name"/>
                <a class="form-input-header">Surname</a>
                <form:input class="form-input-data" path="surname"/>
                <form:errors path="surname"/>
                <a class="form-input-header">Department</a>
                <form:input class="form-input-data" path="department"/>
                <a class="form-input-header">Salary</a>
                <form:input class="form-input-data" path="salary"/>
                <form:errors path="salary"/>
                <input class="input-button-ok" type="submit" value="OK"/>
            </form:form>
        </div>
    </div>
    </body>
</html>
