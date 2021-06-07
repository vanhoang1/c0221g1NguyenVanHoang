<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-May-21
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <title>Service Edit</title>
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
                        <h4 class="card-title">Edit Profile</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name" name="name"
                                               value="${service.serviceName}">
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Area Of Use </label>
                                        <input type="text" class="form-control" placeholder=""
                                               value="${service.areaOfUse}"
                                               name="areaOfUse">

                                    </div>

                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Number Of Floors</label>
                                        <input type="text" class="form-control" placeholder=" "
                                               value="${service.numberOfFloors}"
                                               name="numberOfFloors">

                                    </div>

                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Max Num Of People</label>
                                        <input type="text" class="form-control" placeholder=" "
                                               value="${service.maxNumOfPeople}"
                                               name="maxNumOfPeople">

                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Rental Costs</label>
                                        <input type="text" class="form-control" placeholder=""
                                               value="${service.rentalCosts}"
                                               name="rentalCosts">

                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>ID Service</label>
                                        <input type="text" class="form-control" placeholder=""
                                               value="${service.maDichVu}"

                                               name="maDichVu">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label>Type of Rent

                                    </label>
                                    <select class="form-control"
                                            name="idRentType">
                                        <c:if test="${service.rentType!=null}">
                                            <option selected
                                                    value="${service.rentType.id}">${service.rentType.name}</option>
                                        </c:if>
                                        <c:forEach var="rentType" items="${rentTypeList}">
                                            <c:if test="${service.rentType.id != rentType.id}">
                                                <option value="${rentType.id }"
                                                > ${rentType.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Type of Service

                                        </label>
                                        <select class="form-control"
                                                name="idServiceType">
                                            <c:if test="${service.serviceType!=null}">
                                                <option selected
                                                        value="${service.serviceType.id}">${service.serviceType.name}</option>
                                            </c:if>
                                            <c:forEach var="serviceType" items="${serviceTypeList}">
                                                <c:if test="${service.serviceType.id != serviceType.id}">
                                                    <option value="${serviceType.id }"
                                                    > ${serviceType.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Status</label>
                                        <input type="text" class="form-control" placeholder="Status"
                                               value="${service.status}" name="status">
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

