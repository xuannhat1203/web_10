<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đặt Vé Xem Phim</title>
</head>
<body>
<h2>Form Đặt Vé</h2>

<form:form action="${pageContext.request.contextPath}/booking" method="post" modelAttribute="ticket">
    <label for="movieTitle">Tên phim:</label><br>
    <form:input path="movieTitle" id="movieTitle" required="required"/><br><br>

    <label for="showTime">Thời gian chiếu:</label><br>
    <form:input path="showTime" id="showTime" type="datetime-local" required="required"/><br><br>

    <label>Chọn ghế:</label><br>
    <form:checkbox path="seats" value="A1"/>A1
    <form:checkbox path="seats" value="A2"/>A2
    <form:checkbox path="seats" value="A3"/>A3
    <form:checkbox path="seats" value="A4"/>A4
    <form:checkbox path="seats" value="A5"/>A5
    <br><br>

    <input type="submit" value="Đặt vé"/>
</form:form>

</body>
</html>
