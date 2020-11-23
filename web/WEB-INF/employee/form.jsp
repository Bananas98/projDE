<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09.11.2020
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
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
            <a class="navbar-brand"> Department Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="/listEmployee?id_department=${id_department}"
                   class="nav-link">Employee</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="insertUpdateEmployee" method="post">
                <caption>
                    <h2>
                        <c:if test="${not empty employee}">
                            Edit Employee
                        </c:if>
                        <c:if test="${empty employee}">
                            Add New Employee
                        </c:if>
                    </h2>
                </caption>

                <input type="hidden" name="id_department" value="<c:out value="${id_department}"/>"/>
                <c:if test="${not empty employee}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
                </c:if>

                <fieldset class="form-group">

                    <label>Employee Name</label> <input type="text"
                                                        value="<c:out value='${employee.name}' />"
                                                        class="form-control"
                                                        name="name" required="required">
                    <div class="text-danger">${error['name']}</div>

                    <label>Date Of Birthday</label> <input type="date"
                                                           value="<c:out value='${employee.dateOfBirthday}' />"
                                                           class="form-control"
                                                           name="dateOfBirthday" required="required">

                    <label>Mail</label><input type="text"
                                              value="<c:out value='${employee.mail}' />" class="form-control"
                                              name="mail" required="required">

                    <div class="text-danger">${error['mail']}</div>

                    <label>Salary</label> <input type="text"
                                                 value="<c:out value='${employee.salary}' />" class="form-control"
                                                 name="salary" required="required">
                    <div class="text-danger">${error['salary']}</div>

                </fieldset>


                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
