<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-May-21
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>

    <script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <script src="../../bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/all.css">
    <script src="../../jquery/header.js"></script>
</head>
<body>
<header-component></header-component>
<div class="container pt-3">
    <div class="title text-center">
        <h3>Tables</h3>
    </div>
    <div class="row ">
        <div class="mx-auto ">
            <div class="d-grid gap-2 d-md-flex justify-content-md-between my-3">
                <button type="button" class="btn btn-outline-secondary"><i class="fa fa-plus-circle"></i> Thêm mới</button>
                <div class="col-lg-4 col-xl-4 col-sm-8 col-md-4 d-none d-md-flex ">
                    <form action="#" class="search-wrap">
                        <div class="input-group w-100"><input type="text" class="form-control search-form"
                                                              style="width:55%;" placeholder="Search">
                            <div class="input-group-append">
                                <button class="btn btn-primary search-button" type="submit"><i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <c:if test='${message != null}'>
                        <a href="/customers" class="text-decoration-none d-flex" >  <button class="btn btn-outline-success "  >Back to customer list </button></a>
                    </c:if>
                </div>
                <c:if test='${message != null&&!err}'>
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </c:if>
                <c:if test='${message != null&&err}'>
                    <div class="alert alert-danger" role="alert">
                            ${message}
                    </div>
                </c:if>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th class="text-center">#</th>
                        <th>Name</th>
                        <th>BirthDay</th>
                        <th>Gender</th>
                        <th>SoCMND</th>
                        <th>SDT</th>
                        <th>IdCard</th>
                        <th>Email</th>
                        <th>TypeCustomer</th>
<%--                             thao tác--%>
                        <th class="text-right">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items='${list}' var="customer" varStatus="count">
                    <tr>
                        <td class="text-center">${count.count}</td>

                        <td>${customer.getNameCustomer()}</td>
                        <td>${customer.getDateOfBirth()}</td>
                        <td>${customer.getGender()}</td>
                        <td>${customer.getSoCMND()}</td>
                        <td>${customer.getSoDT()}</td>
                        <td>${customer. getIdCard()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getTypeOfCustomer()}</td>


<%--                        thao tac--%>
                        <td class="td-actions text-right">
                            <button type="button" rel="tooltip" class="btn btn-info btn-round btn-just-icon btn-sm" data-original-title="" title="info">
                              <a href="/customers?action=view&id=${customer.getId()}" class="text-light">  <i class="fa fa-user"></i> </a>
                            </button>
                            <button type="button" rel="tooltip" class="btn btn-success btn-round btn-just-icon btn-sm" data-original-title="" title="edit">
                                <a href="/customers?action=edit&id=${customer.getId()} " class="text-light">   <i class="fa fa-edit"></i> </a>
                            </button>
                            <button type="button" rel="tooltip" class="btn btn-danger btn-round btn-just-icon btn-sm" data-original-title="" title="delete">
                                <a href="/customers?action=delete&id=${customer.getId()}" class="text-light">   <i class="fas fa-trash"></i> </a>
                            </button>
                        </td>
                    </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
