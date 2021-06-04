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
    <title>Edit Contract </title>
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
                        <h4 class="card-title">Edit Contract</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>Start Date</label>
                                        <input class="form-control" type="date" name="startDate"
                                               value="<fmt:formatDate value="${contract.getStartDate()}" pattern="yyyy-MM-dd" />">
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>End Date</label>
                                        <input class="form-control" type="date" name="endDate"
                                               value="<fmt:formatDate value="${contract.getEndDate()}" pattern="yyyy-MM-dd" />">
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <label> Employee

                                    </label>
                                    <select class="form-control"
                                            name="idEmployee">
                                        <c:if test="${contract. getEmployee()!=null}">
                                            <option selected
                                                    value="${contract.getEmployee().getIdEmployee() }">${contract.getEmployee().getIdEmployee() }
                                                : ${contract.getEmployee().getNameEmployee()}</option>
                                        </c:if>
                                        <c:forEach var="employee" items="${employeeList}">
                                            <c:if test="${contract.getEmployee().getIdEmployee()!= employee.getIdEmployee()}">
                                                <option value="${employee.getIdEmployee() }"
                                                        >${employee.getIdEmployee() }
                                                    : ${employee.getNameEmployee()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label> Customer

                                        </label>
                                        <select class="form-control"
                                                name="idCustomer">
                                            <c:if test="${contract.getCustomer()!=null}">
                                                <option selected
                                                        value="${contract.getCustomer().getId()}">${contract.getCustomer().getId() }
                                                    : ${contract.getCustomer().getNameCustomer()}</option>
                                            </c:if>
                                            <c:forEach var="customer" items="${customerList}">
                                                <c:if test="${contract.getCustomer().getId()!= customer.getId()}">
                                                    <option value="${customer.getId()}" >${customer.getId()}
                                                        : ${customer.getNameCustomer()}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>id Service

                                        </label>
                                        <select class="form-control"
                                                name="idService">
                                            <c:if test="${contract.getService()!=null}">
                                                <option selected
                                                        value="${contract.getService().getId() }">${contract.getService().getId() }
                                                    : ${contract.getService().getServiceName()}</option>
                                            </c:if>
                                            <c:forEach var="service" items="${servicesList}">
                                                <c:if test="${contract.getCustomer().getId()!= service.getId()}">
                                                    <option value="${service.getId()}" >${service.getId()}
                                                        : ${service.getServiceName()}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Deposit</label>
                                            <input type="text" class="form-control" placeholder=""
                                                   value="${contract.getDeposit()}" name="deposit">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Total Money</label>
                                            <input type="text" class="form-control" placeholder=""
                                                   value="${contract.getTotalMoney()}" name="totalMoney">
                                        </div>
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

