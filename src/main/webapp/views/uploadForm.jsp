<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h2>Upload Avatar</h2>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<form:form method="POST" action="/profile/uploadAvatar" modelAttribute="userProfile" enctype="multipart/form-data">
    Username: <form:input path="username"/><br/>
    Avatar: <form:input path="avatar" type="file"/><br/>
    <input type="submit" value="Upload"/>
</form:form>
<c:if test="${not empty avatarPath}">
    <h3>Uploaded Avatar:</h3>
    <img src="${avatarPath}" alt="Avatar" width="150"/>
</c:if>
</body>
</html>

