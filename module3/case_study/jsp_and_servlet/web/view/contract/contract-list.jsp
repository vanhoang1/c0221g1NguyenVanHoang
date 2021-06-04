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
    <title>Contract List</title>

</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container pt-3">
    <div class="title text-center">
        <h3>Contract</h3>
    </div>
    <div class="row ">
        <div class="mx-auto ">
            <div class="d-grid gap-2 d-md-flex justify-content-md-between my-3">
                <a href="/contracts?action=create">
                    <button type="button" class="btn btn-outline-secondary"><i class="fa fa-plus-circle"></i> Thêm mới
                    </button>
                </a>
                <div class="col-lg-4 col-xl-4 col-sm-8 col-md-4 d-none d-md-flex ">
                    <form action="/contracts" class="search-wrap">
                        <input hidden name="action" value="search">
                        <div class="input-group w-100"><input type="text" class="form-control search-form"
                                                              style="width:55%;" placeholder="Search" name="search">
                            <div class="input-group-append">
                                <button class="btn btn-primary search-button" type="submit"><i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
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
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-bordered" id="tableList">
                    <thead class="thead-dark">
                    <tr>
                        <th class="text-center">#</th>
                        <th>Customer</th>
                        <th>Employee</th>
                        <th>Service</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Deposit</th>
                        <th>Total Money</th>

                        <%--                             thao tác--%>
                        <th class="text-right">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items='${list}' var="contract" varStatus="count">
                        <tr>
                            <td class="text-center">${count.count}</td>

                            <td class="text-center">${contract.getCustomer().getNameCustomer()}</td>
                            <td class="text-center">${contract.getEmployee() .getNameEmployee()}</td>
                            <td class="text-center">${contract.getService().getServiceName()}</td>
                            <td>${contract.getStartDate()}</td>

                            <td>${contract.getEndDate()}</td>
                            <td>${contract.getDeposit()}</td>
                            <td>${contract.getTotalMoney()}</td>


                                <%--                        thao tac--%>
                            <td class="td-actions text-right">

                                <a href="/contracts?action=view&id=${contract. getIdContract()}" class="text-light">
                                    <button type="button" rel="tooltip"
                                            class="btn btn-info btn-round btn-just-icon btn-sm"
                                            data-original-title="" title="info"><i
                                            class="fa fa-user"></i></button>
                                </a>


                                <a href="/contracts?action=edit&id=${contract. getIdContract()} " class="text-light">
                                    <button type="button" rel="tooltip"
                                            class="btn btn-success btn-round btn-just-icon btn-sm"
                                            data-original-title=""
                                            title="edit"><i
                                            class="fa fa-edit"></i></button>
                                </a>


                                <a data-href="/contracts?action=delete&id=${contract. getIdContract()}"
                                   data-record-title="row ${count.count}"
                                   data-toggle="modal" data-target="#confirm-delete" class="text-light ">
                                    <button type="button" rel="tooltip"
                                            class="btn btn-danger btn-round btn-just-icon btn-sm" data-original-title=""
                                            title="delete"><i class="fas fa-trash"></i></button>
                                </a>

                            </td>
                        </tr>
                    </c:forEach>
                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>

                                <div class="modal-body">

                                    Do you want to delete <strong> <span class="debug-url"></span></strong> ?

                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <a class="btn btn-danger btn-ok">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
