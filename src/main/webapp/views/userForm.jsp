<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>Enter Personal Information</h2>
<form:form method="POST" action="/user/submit" modelAttribute="user">
    Name: <form:input path="name"/><br/>
    Age: <form:input path="age"/><br/>
    Address: <form:input path="address"/><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>

