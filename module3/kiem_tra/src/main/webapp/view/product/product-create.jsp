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
    <title> Create Product</title>
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
                        <h4 class="card-title">Create Product</h4>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-12 pr-1">
                                    <div class="form-group">
                                        <label>Name </label>
                                        <input type="text" class="form-control" placeholder="Name Product" name="name"
                                               value="${product.name}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>Price </label>
                                        <input type="text" class="form-control" placeholder="Price" name="price"
                                               value="${product.price}">
                                    </div>
                                </div>
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>Amount </label>
                                        <input type="text" class="form-control" placeholder="Amount" name="amount"
                                               value="${product.amount}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 pr-1">
                                    <div class="form-group">
                                        <label>Color </label>
                                        <input type="text" class="form-control" placeholder="Color" name="color"
                                               value="${product.color}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 pr-1">
                                    <div class="form-group">
                                        <label>Description </label>
                                        <input type="text" class="form-control" placeholder="Description" name="description"
                                               value="${product.description}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">

                                <div class="col-md-12 pl-1">
                                    <div class="form-group">
                                        <label>Type of Category

                                        </label>
                                        <select class="form-control"
                                                name="idCategory">
                                            <c:if test="${product.category!=null}">
                                                <option selected value="${product.category.id}">${product.category.name}</option>
                                            </c:if>
                                            <c:forEach var="category" items="${categoryList}">
                                                <c:if test="${product.category.id != category.id}">
                                                    <option value="${category.id }"
                                                    > ${category.name}</option>
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

