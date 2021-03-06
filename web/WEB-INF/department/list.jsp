<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Department
                Management App </a>
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
        <h3 class="text-center">List of Departments</h3>
        <hr>
        <div class="container text-left">

            <a href="<c:url value="/createUpdateFormDepartment"/>"
               class="btn btn-success">Add New Department</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="department" items="${listDepartment}">

                <tr>
                    <td><c:out value="${department.id}"/></td>
                    <td><c:out value="${department.name}"/></td>

                    <td>
                        <div class="btn-group btn-group-justified">
                            <a href="createUpdateFormDepartment?id=<c:out value='${department.id}' />"
                               class="btn btn-primary">Edit</a>
                        </div>
                        <div class="btn-group btn-group-justified">
                            <a href="deleteDepartment?id=<c:out value='${department.id}' />"
                               class="btn btn-primary">Delete</a>
                        </div>
                        <div class="btn-group btn-group-justified">
                            <a href="listEmployee?id_department=<c:out value='${department.id}' />"
                               class="btn btn-primary">List Employee</a>
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
