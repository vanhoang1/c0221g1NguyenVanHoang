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
    <title>Edit Employee </title>

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
                        <h4 class="card-title">Edit Employee</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name" name="name"
                                               value="${employee.nameEmployee}">
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label>Position

                                    </label>
                                    <select class="form-control"
                                            name="idPosition">
                                        <c:if test="${employee.position !=null}">
                                            <option selected value="${employee.position.id }">${employee.position.name }</option>
                                        </c:if>
                                        <c:forEach var="position" items="${positionList}">
                                            <c:if test="${employee.position.id != position.id}">
                                                <option value="${position.id }"
                                                > ${position.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Education

                                        </label>
                                        <select class="form-control"
                                                name="idEducation">
                                            <c:if test="${employee.education!=null}">
                                                <option selected value="${employee.education.id}">${employee.education.name}</option>
                                            </c:if>
                                            <c:forEach var="education" items="${educationList}">
                                                <c:if test="${employee.education.id != education.id}">
                                                    <option value="${education.id }"
                                                    > ${education.name}</option>
                                                </c:if>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Division

                                        </label>
                                        <select class="form-control"
                                                name="idDivision">
                                            <c:if test="${employee.division!=null}">
                                                <option selected value="${employee.division.id}">${employee.division.name}</option>
                                            </c:if>
                                            <c:forEach var="division" items="${divisionList}">
                                                <c:if test="${employee.division.id != division.id}">
                                                    <option value="${division.id }"
                                                    > ${division.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <input class="form-control" type="date" id="date-input" name="birthDay"
                                                   value="<fmt:formatDate value="${employee.birthDay}" pattern="yyyy-MM-dd" />">
                                        </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>ID card</label>
                                            <input type="text" class="form-control" placeholder="" value="${employee.idCard}" name="idCard">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Salary</label>
                                        <input type="text" class="form-control" placeholder="Salary" value="${employee.salary}" name="salary">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" placeholder="" value="${employee.address}"
                                               name="address">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label>Status</label>
                                    <input type="text" class="form-control" placeholder="phone" value="${employee.phone}" name="phone">

                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control" placeholder="ID number" value="${employee.email}" name="email">

                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" class="form-control" placeholder="Username" value="${employee.username}" name="username">
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-right">Edit</button>
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

