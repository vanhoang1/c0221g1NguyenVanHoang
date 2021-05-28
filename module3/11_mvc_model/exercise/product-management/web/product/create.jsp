<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<div class="container text-center">
    <h1>Create new Product</h1>
    <c:if test='${requestScope["message"] != null&&!requestScope["err"]}'>
        <div class="alert alert-success" role="alert">
                ${requestScope["message"]}
        </div>
    </c:if>
    <c:if test='${requestScope["message"] != null&&requestScope["err"]}'>
        <div class="alert alert-danger" role="alert">
                ${requestScope["message"]}
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
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Manufacturer:</td>
                    <td><input type="text" name="manufacturer" id="manufacturer"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create customer"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>