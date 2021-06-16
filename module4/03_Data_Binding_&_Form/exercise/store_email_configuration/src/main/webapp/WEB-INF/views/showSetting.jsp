<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16-Jun-21
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Show Setting</title>
    <link rel="stylesheet" href="../../../resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h2>Setting</h2>

<table class="table  table-responsive">
    <tr>
        <td>Language:</td>
        <td>${setting.language}</td>
    </tr>
    <tr>
        <td>Page size:</td>
        <td>${setting.pageSite}</td>
    </tr>
    <tr>
        <td>Spam Filer:</td>
        <td>${setting.spamFiler?"Enable":"None"}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${setting.signature}</td>
    </tr>
</table>
    <div class="form-group row">
        <a href="edit">
            <div class="col-sm-10">
                <button type="button" class="btn btn-primary">Edit</button>
            </div>
        </a>

    </div>
</div>
</body>

</html>
