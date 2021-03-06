<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09.11.2020
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Department Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #ff6d4c">
        <div>
            <a class="navbar-brand"> Department Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<c:url value="/listDepartment"/>"
                   class="nav-link">Departments</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">List of Employees ${name_department}</h3>
        <hr>
        <div class="container text-left">

            <a href="/createUpdateFormEmployee?id_department=${id_department}" class="btn btn-success">
                Add New Employees to ${name_department}</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Birthday</th>
                <th>Mail</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${listEmployee}">

                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><calendar:formatDate value="${employee.dateOfBirthday}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${employee.mail}"/></td>
                    <td><c:out value="${employee.salary}"/></td>
                    <td>
                        <div class="btn-group btn-group-justified">
                            <a href="createUpdateFormEmployee?id_department=${id_department}&id_employee=<c:out value='${employee.id}' />"
                               class="btn btn-primary">Edit</a>
                        </div>
                        <div class="btn-group btn-group-justified">
                            <a href="deleteEmployee?id_employee=<c:out value='${employee.id}' />"
                               class="btn btn-primary">Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>

