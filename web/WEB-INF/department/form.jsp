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
            <a class="navbar-brand"> Department Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<c:url value="/listDepartment"/>"
                   class="nav-link">Departments</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <form action="insertUpdateDepartment" method="post">

                    <caption>
                        <h2>
                            <c:if test="${not empty department}">
                                Edit Department
                            </c:if>
                            <c:if test="${empty department}">
                                Add New Department
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${not empty department}">
                        <input type="hidden" name="id" value="<c:out value='${department.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Department Name</label> <input type="text"
                                                              value="<c:out value='${department.name}' />"
                                                              class="form-control"
                                                              name="name" required="required">
                    </fieldset>
                    <div class="text-danger">${error['name']}</div>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
