<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27-May-21
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container text-center">
    <h1>Product</h1>
    <p>
        <a href="/products?action=create">Create new product</a>
    </p>

</div>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <div class="row">
                <form class="d-flex" action="/products" method="get">
                    <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                    <c:if test='${message != null}'>
                        <a href="/products" class="text-decoration-none d-flex" >  <button class="btn btn-outline-success "  >Back to product list </button></a>
                    </c:if>
                </div>
            </div>
        </nav>
        <c:if test='${message != null&&!err}'>
            <div class="alert alert-success" role="alert">
                    ${message}
            </div>
        </c:if>
        <c:if test='${message != null&&err}'>
            <div class="alert alert-danger" role="alert">
                    ${message}
            </div>
        </c:if>
    </div>


</div>
<div class="container">
    <table border="1" class="table">
        <tr>
            <td>STT</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Manufacturer</td>
            <td colspan="2">Thao tác</td>
        </tr>
        <c:forEach items='${products}' var="product" varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductDescription()}</td>
                <td>${product.getManufacturer()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
