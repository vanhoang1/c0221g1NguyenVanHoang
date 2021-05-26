<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26-May-21
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form class="row col-6 " action="/discount" method="post">
  <div class="mb-3 row">
    <label for="productDescription" class="col-sm-2 col-form-label">Product Descriptio</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" id="productDescription" name="productDescription" >
    </div>
  </div>
  <div class="mb-3 row">
    <label for="listPrice" class="col-sm-2 col-form-label">List Price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="listPrice" name="listPrice">
    </div>
  </div>
    <div class="mb-3 row">
        <label for="discountPercent" class="col-sm-2 col-form-label">Discount Percent</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="discountPercent" name="discountPercent">
        </div>
    </div>
  <button type="submit" id="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
