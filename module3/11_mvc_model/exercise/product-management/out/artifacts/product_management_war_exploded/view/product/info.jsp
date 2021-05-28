<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-May-21
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<div class="container text-center">
    <h1>Product information</h1>
    <p>
        <a href="/products">Back to product list</a>
    </p>
</div>

<div class="container">
    <table border="1" class="table">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Manufacturer</td>
            <td colspan="2">Thao tác</td>
        </tr>
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductDescription()}</td>
                <td>${product.getManufacturer()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            </tr>
    </table>
</div>
</body>
</html>
