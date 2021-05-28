<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<div class="container">

    <form method="post" class="form">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>ID: </td>
                    <td><input disabled type="text" name="id" id="id" value="${product.getId()}"></td>
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
                    <td><input type="text" name="description" id="description" value="${product.getProductDescription()}"></td>
                </tr>
                <tr>
                    <td>Manufacturer: </td>
                    <td><input type="text" name="manufacturer" id="manufacturer" value="${product.getManufacturer()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Delete product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>