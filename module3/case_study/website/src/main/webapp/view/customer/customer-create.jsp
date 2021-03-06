<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-May-21
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">
<head>
    <title> Create Customer</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

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

<div class="content">
    <div class="container-fluid">
        <div class="row ">
            <div class="col-md-8 mx-auto">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Create Customer</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-8 pr-1">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name Customer" name="name"
                                               value="${customer.nameCustomer}">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <input class="form-control" type="date" id="date-input" name="birthDay"
                                               value="<fmt:formatDate value="${customer.dateOfBirth}" pattern="yyyy-MM-dd" />">
                                    </div>
                                </div>

                            </div>
                            <div class="row">

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control" placeholder=" Email" value="${customer.email}"
                                               name="email">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>ID Customer</label>
                                        <input type="text" class="form-control" placeholder=" Email" value="${customer.maKhachHang}"
                                               name="maKhachHang">

                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" placeholder="Home Address" value="${customer.address}"
                                               name="address">
                                    </div>
                                </div>
                                <div class="form-group col-md-4 flex-column d-flex">
                                    <label class="form-control-label px-3">Gender
                                        <span class="text-danger"> *</span></label>
                                    <div class="form-check d-flex px-5">
                                        <label class="form-check-label" for="exampleRadios1">
                                            Male
                                        </label>
                                        <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="0"
                                               <c:if test="${customer.gender==0}">checked</c:if>   >

                                    </div>
                                    <div class="form-check d-flex px-5">
                                        <label class="form-check-label" for="exampleRadios2">
                                            Female
                                        </label>
                                        <input class="form-check-input" type="radio" name="gender" id="exampleRadios2" value="1"
                                               <c:if test="${customer.gender==1}">checked</c:if>>

                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input type="text" class="form-control" placeholder="Phone" name="phone"
                                               value="${customer.soDT}">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>ID number</label>
                                        <input type="text" class="form-control" placeholder="ID number" value="${customer.soCMND}" name="soCMND">
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Type of Customer

                                        </label>
                                        <select class="form-control"
                                                name="typeOfCustomer">
                                            <c:if test="${customer.customerType!=null}">
                                                <option selected value="${customer.customerType.id}">${customer.customerType.name}</option>
                                            </c:if>
                                            <c:forEach var="type" items="${typeList}">
                                                <c:if test="${customer.customerType.id != type.id}">
                                                    <option value="${type.id }"
                                                    > ${type.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-right">Create </button>
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

