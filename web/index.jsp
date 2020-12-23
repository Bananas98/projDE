<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Departments</title>

    <script src="<c:url value="/resources/js/libs/jquery-1.12.3.min.js"/>"></script>
    <script src="<c:url value="/resources/js/libs/underscore.js"/>"></script>
    <script src="<c:url value="/resources/js/libs/validate.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>

    <script src="<c:url value="/resources/js/index.js"/>"></script>
<%--    <script src="<c:url value="/resources/js/services/employeeService.js"/>"></script>--%>
    <script src="<c:url value="/resources/js/services/departmentService.js"/>"></script>
    <script src="<c:url value="/resources/js/utils/tableDrawer.js"/>"></script>
    <script src="<c:url value="/resources/js/utils/formDrawer.js"/>"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<%--    <link href="<c:url value="/resources/css/addDep.css"/>" rel="stylesheet" type="text/css">--%>
</head>
<body>
<div class="department"></div>
</body>
</html>