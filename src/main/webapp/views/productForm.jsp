<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
<h2>Enter Product Information</h2>
<form:form method="POST" action="/product/add" modelAttribute="product">
    Name: <form:input path="name"/><br/>
    Price: <form:input path="price"/><br/>
    Description: <form:input path="description"/><br/>
    <input type="submit" value="Add Product"/>
</form:form>
</body>
</html>

