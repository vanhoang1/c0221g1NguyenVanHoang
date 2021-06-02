<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31-May-21
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
    <script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <script src="../../bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/all.css">
    <script src="../../jquery/header.js"></script>
    <script src="../../jquery/create.js"></script>
    <link rel="stylesheet" href="../../css/create.css">
</head>
<body>
<header-component></header-component>

<c:if test='${message != null&&!err}'>
    <div class="alert alert-success fixed-top col-4" role="alert">
            ${message}
    </div>
</c:if>
<c:if test='${message != null&&err}'>
    <div class="alert alert-danger fixed-top col-4" role="alert">
            ${message}
    </div>
</c:if>

<div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <div class="card">
                <h5 class="text-center mb-4">Create Customer</h5>
                <form class="form-card" method="post">
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label
                                class="form-control-label px-3">Name<span class="text-danger"> *</span></label> <input
                                type="text" id="name" name="name"
                                placeholder="Enter your name"
                                onblur="validate(1)"></div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label
                                class="form-control-label px-3">Date<span class="text-danger"> *</span></label> <input
                                type="date" id="date" name="birthDay" value="2011-08-19"
                                onblur="validate(2)">

                        </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Email<span
                                class="text-danger"> *</span></label> <input type="text" id="email" name="email"
                                                                             placeholder="" onblur="validate(3)">
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Phone
                            number<span class="text-danger"> *</span></label> <input type="text" id="phone" name="phone"
                                                                                     placeholder=""
                                                                                     onblur="validate(4)"></div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-8 flex-column d-flex"><label class="form-control-label px-3">Address
                            <span class="text-danger"> *</span></label> <input type="text" id="address" name="address"
                                                                               placeholder="" onblur="validate(5)">
                        </div>
                        <div class="form-group col-sm-4 flex-column d-flex">
                            <label class="form-control-label px-3">Gender
                                <span class="text-danger"> *</span></label>
                            <div class="form-check d-flex px-5">
                                <label class="form-check-label" for="exampleRadios1">
                                    Male
                                </label>
                                <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="0"
                                       checked>

                            </div>
                            <div class="form-check d-flex px-5">
                                <label class="form-check-label" for="exampleRadios2">
                                    Female
                                </label>
                                <input class="form-check-input" type="radio" name="gender" id="exampleRadios2"
                                       value="1">

                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label
                                class="form-control-label px-3">CMND<span class="text-danger"> *</span></label> <input
                                type="text" id="soCMND" name="soCMND"
                                placeholder="" onblur="validate(7)">
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Type
                            Of Customer
                            <span class="text-danger"> *</span></label> <select class="form-control"
                                                                                name="typeOfCustomer">

                            <option value="1" selected>Diamond</option>
                            <option value="2">Gold</option>
                            <option value="3">Silver</option>
                        </select></div>
                    </div>
                    <div class="row justify-content-end">
                        <div class="form-group col-sm-6">
                            <button type="submit" class="btn-block btn-primary">Create</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
    setTimeout(function () {
        $('.alert').fadeOut('fast');
    }, 1000);
</script>
</body>
</html>
