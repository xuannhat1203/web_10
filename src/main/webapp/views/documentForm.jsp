<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Document</title>
</head>
<body>

<h2>Upload Document</h2>

<form:form method="post" modelAttribute="document" action="uploadDocument" enctype="multipart/form-data">

    <table>
        <tr>
            <td><label for="title">Title:</label></td>
            <td><form:input path="title" id="title" /></td>
        </tr>
        <tr>
            <td><label for="description">Description:</label></td>
            <td><form:textarea path="description" id="description" rows="4" cols="30"/></td>
        </tr>
        <tr>
            <td><label for="file">File:</label></td>
            <td><form:input path="file" type="file" id="file" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Upload" />
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>

