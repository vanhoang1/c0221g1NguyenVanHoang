<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26-May-21
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container py-5 shadow">
    <div class="row text-center"><h1>Danh sách khách hàng</h1></div>

    <table class="table text-center ">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items='${requestScope["listCustomer"]}' varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getBirthday()}</td>
                <td>${customer.getAddress()}</td>
                <td><img src="${customer.getImg()}" alt="" width="100"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
