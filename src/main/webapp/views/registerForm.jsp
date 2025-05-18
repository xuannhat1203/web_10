<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Register Account</title>
</head>
<body>
<h2>User Registration</h2>
<form:form method="POST" action="/account/register" modelAttribute="account">
    Username: <form:input path="username"/><br/>
    Password: <form:password path="password"/><br/>
    Email: <form:input path="email"/><br/>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>

