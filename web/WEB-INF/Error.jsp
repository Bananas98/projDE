<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%--<div style="text-align: center;"><h1>Oooooooooooops, something wrong </h1></div>--%>
<ul>
    <li>Exception:<c:out value="${requestScope['javax.servlet.error.exception']}"/></li>
    <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}"/></li>
    <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}"/></li>
    <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}"/></li>
    <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}"/></li>
    <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}"/></li>
</ul>
</body>
</html>