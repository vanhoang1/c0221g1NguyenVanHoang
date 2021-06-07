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
    <title>Create Contract </title>
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
                        <h4 class="card-title">Create Contract Detail</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <label> Contract

                                    </label>
                                    <select class="form-control"
                                            name="idContract">
                                        <c:if test="${contractDetail. contract!=null}">
                                            <option selected
                                                    value="${contractDetail.contract.idContract }">${contractDetail.contract.idContract }</option>
                                        </c:if>
                                        <c:forEach var="contract" items="${contractList}">
                                            <c:if test="${contractDetail.contract.idContract!= contract.idContract}">
                                                <option value="${contract.idContract }"
                                                >${contract.idContract }</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>Attach Service

                                        </label>
                                        <select class="form-control"
                                                name="idAttachService">
                                            <c:if test="${contractDetail.attachService!=null}">
                                                <option selected
                                                        value="${contractDetail.attachService.id }">${contractDetail.attachService.id }
                                                    : ${contractDetail.attachService.attachName}</option>
                                            </c:if>
                                            <c:forEach var="attachService" items="${attachServiceList}">
                                                <c:if test="${contractDetail.attachService.id!= attachService.id}">
                                                    <option value="${attachService.id}" >${attachService.id}
                                                        : ${attachService.attachName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 pr-1">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Quantity</label>
                                            <input type="text" class="form-control" placeholder=""
                                                   value="${contractDetail.quantity}" name="quantity">
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

