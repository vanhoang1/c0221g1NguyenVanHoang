<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<div class="container text-center">


<h1>Edit product</h1>
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
<p>
    <a href="/products">Back to product list</a>
</p>
</div>
<div class="container">


<form method="post" class="form">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input disabled type="text"  value="${product.getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${product.getProductName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${product.getProductPrice()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description" value="${product .getProductDescription()}"></td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td><input type="text" name="manufacturer" id="manufacturer" value="${product.getManufacturer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>