<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-May-21
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer Edit</title>
    <script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <script src="../../bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/all.css">
    <script src="../../jquery/header.js"></script>
</head>
<body>
<header-component></header-component>
<div class="content">
    <div class="container-fluid">
        <div class="row ">
            <div class="col-md-8 mx-auto">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Edit Profile</h4>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-md-8 pr-1">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name Customer" name="name"
                                               value="${customer.getNameCustomer()}">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <input class="form-control" type="date" id="date-input" name="birthDay"
                                               value="${customer.getDateOfBirth()}">
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-6 pr-1  ">
                                    <label> Gender :</label>
                                    <div class="d-flex">
                                        <div class="form-check px-4 ">
                                            <label class="form-check-label">

                                                <input type="radio" class="form-check-input" name="gender" id="male"
                                                       value="male"
                                                <c:if test="${customer.getGender()=='Male'}">
                                                checked
                                                </c:if> >
                                                Male
                                            </label>
                                        </div>
                                        <div class="form-check px-4 ">
                                            <label class="form-check-label">
                                                <input type="radio" class="form-check-input" name="gender" id="female"
                                                <c:if test="${customer.getGender()=='Female'}">
                                                       checked
                                                </c:if>
                                                       value="female">
                                                Female
                                            </label>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>ID number</label>
                                        <input type="text" class="form-control" placeholder="ID number" value="${customer.getSoCMND()}" name="soCMND">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" placeholder="Home Address" value="${customer.getSoCMND()}"
                                               name="address">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input type="text" class="form-control" placeholder="Phone" name="phone"
                                               value="${customer.getSoCMND()}">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Id Card</label>
                                        <input type="text" class="form-control" placeholder="Id Card" name="idCard"
                                               value="${customer.getSoCMND()}">
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Type of Customer</label>
                                        <input type="number" class="form-control" placeholder="Type of Customer"
                                               name="typeOfCustomer" value="${customer.getSoCMND()}">
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-right">Update Profile</button>
                            <div class="clearfix"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

