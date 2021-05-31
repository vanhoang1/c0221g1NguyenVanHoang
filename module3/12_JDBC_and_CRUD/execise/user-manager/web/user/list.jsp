
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>

    <link href="bootstrap413/css/bootstrap.css" rel="stylesheet">
    <link href="datatables/js/dataTables.bootstrap4.js" rel="stylesheet">
</head>
<body>
<div style="text-align: center;">
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</div>
<div class="container">
    <div align="center">
        <div class="">
            <form class="d-flex" action="/users" method="get">
                <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <c:if test="${message}">
            <p> delete thành công</p>
        </c:if>
        <table border="1" cellpadding="5" id="tableUser" class="table table-striped table-bordered">
            <caption><h2>List of Users</h2></caption>
            <thead>
            <tr>
                <th>ID</th>
                <th><a>Name</a></th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <a href="/users?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="bootstrap413/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableUser').dataTable({
            "dom" :'lrtip',
            "lengthChange":false,
            "pageLength":5
        });
    });
</script>
</body>
</html>