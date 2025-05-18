<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm Dự Án Mới</title>
</head>
<body>
<h2>Tạo Dự Án Mới</h2>

<form:form method="post" action="project" modelAttribute="project" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label for="name">Tên dự án:</label></td>
            <td><form:input path="name" id="name" /></td>
        </tr>
        <tr>
            <td><label for="description">Mô tả:</label></td>
            <td><form:textarea path="description" id="description" rows="4" cols="50" /></td>
        </tr>
        <tr>
            <td><label for="documents">Tài liệu đính kèm:</label></td>
            <td>
                <input type="file" name="files" id="documents" multiple />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Tạo dự án" />
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
