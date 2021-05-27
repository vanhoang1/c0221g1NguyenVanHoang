<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26-May-21
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simple Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container py-5">
    <div class="row col-4 ">
        <form action="/calculate" method="post">
            <fieldset class="p-2 border border-primary ">
                <legend>Simple Calculator</legend>
                <div class="mb-3">
                    <div class="row">
                        <div class="col-4">
                            First Number
                        </div>
                        <div class="col-auto">
                            <input type="text" id="first" name="first" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <div class="row">
                        <div class="col-4">Operation</div>
                        <div class="col-auto">
                            <select id="Operation" class="form-select" name="operation" >
                                <option value="add" selected>Addition</option>
                                <option value="sub">Subtraction</option>
                                <option value="multi">Multiplication</option>
                                <option value="div">Division</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <div class="row">
                        <div class="col-4">Second Number</div>
                        <div class="col-auto">
                            <input type="text" id="second" name="second" class="form-control">
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<div class="container">
    <div class="row col-4">
        <div class="alert alert-primary" role="alert" >
            ${result}
        </div>
    </div>
</div>
</body>
</html>
