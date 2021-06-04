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

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer Create</title>
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
                        <h4 class="card-title">Create Employee</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name" name="name"
                                               value="${employee.getNameEmployee()}">
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label>Position

                                    </label>
                                    <select class="form-control"
                                            name="idPosition">
                                        <c:if test="${employee. getIdPosition() !=null}">
                                            <option selected value="${employee. getIdPosition() }">Lễ tân</option>
                                        </c:if>
                                        <c:if test="${employee. getIdPosition() ==null}">
                                            <option value="1" selected >Lễ tân</option>
                                        </c:if>

                                        <option value="2">phục vụ</option>
                                        <option value="3">chuyên viên</option>
                                    </select>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Education

                                        </label>
                                        <select class="form-control"
                                                name="idEducation">
                                            <c:if test="${employee.getIdEducation()!=null}">
                                                <option selected value="${employee.getIdEducation()}">Trung cấp</option>
                                            </c:if>
                                            <c:if test="${employee.getIdEducation()==null}">
                                                <option value="1" selected >Trung cấp</option>
                                            </c:if>

                                            <option value="2">Đại học </option>
                                            <option value="3">sau đại học</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Division

                                        </label>
                                        <select class="form-control"
                                                name="idDivision">
                                            <c:if test="${employee.getIdDivision()!=null}">
                                                <option selected value="${employee.getIdDivision()}">Sale – Marketing</option>
                                            </c:if>
                                            <c:if test="${employee.getIdDivision()==null}">
                                                <option value="1" selected >Sale – Marketing</option>
                                            </c:if>

                                            <option value="2">Hành Chính</option>
                                            <option value="3">Phục vụ</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <input class="form-control" type="date" id="date-input" name="birthDay"
                                               value="<fmt:formatDate value="${employee.getBirthDay()}" pattern="yyyy-MM-dd" />">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>ID card</label>
                                            <input type="text" class="form-control" placeholder="" value="${employee.getIdCard()}" name="idCard">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Salary</label>
                                        <input type="text" class="form-control" placeholder="Salary" value="${employee.getSalary()}" name="salary">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" placeholder="" value="${employee.getAddress()}"
                                               name="address">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label>Status</label>
                                    <input type="text" class="form-control" placeholder="phone" value="${employee.getPhone()}" name="phone">

                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control" placeholder="ID number" value="${employee.getEmail()}" name="email">

                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" class="form-control" placeholder="Username" value="${employee.getUsername()}" name="username">
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-right">Create</button>
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

