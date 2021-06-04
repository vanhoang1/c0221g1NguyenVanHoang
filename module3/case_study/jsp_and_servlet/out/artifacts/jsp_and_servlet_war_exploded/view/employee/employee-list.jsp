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
    <title>Employee List</title>

</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container pt-3">
    <div class="title text-center">
        <h3>Employee</h3>
    </div>
    <div class="row ">
        <div class="mx-auto ">
            <div class="d-grid gap-2 d-md-flex justify-content-md-between my-3">
                <a href="/employees?action=create"> <button type="button" class="btn btn-outline-secondary"><i class="fa fa-plus-circle"></i> Thêm mới
                </button></a>
                <div class="col-lg-4 col-xl-4 col-sm-8 col-md-4 d-none d-md-flex ">
                    <form action="/employees" class="search-wrap">
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
                <table class="table table-striped table-bordered " id="tableList">
                    <thead class="thead-dark">
                    <tr>
                        <th class="text-center">#</th>
                        <th>Name</th>
                        <th>Birth Day</th>
                        <th>ID card</th>
                        <th>Salary</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <%--                             thao tác--%>
                        <th class="text-right">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items='${list}' var="employee" varStatus="count">
                        <tr >
                            <td class="text-center">${count.count}</td>

                            <td>${employee.getNameEmployee()}</td>
                            <td class="text-center">${employee.getBirthDay()}</td>
                            <td class="text-center">${employee.getIdCard() }</td>
                            <td class="text-center">${employee.getSalary()}</td>
                            <td class="text-center">${employee.getPhone()}</td>
                            <td class="text-center">${employee. getAddress() }</td>


                                <%--                        thao tac--%>
                            <td class="td-actions text-right">

                                <a href="/employees?action=view&id=${employee.getIdEmployee()}" class="text-light"> <button type="button" rel="tooltip" class="btn btn-info btn-round btn-just-icon btn-sm"
                                                                                                                  data-original-title="" title="info"> <i
                                        class="fa fa-user"></i> </button> </a>


                                <a href="/employees?action=edit&id=${employee.getIdEmployee()} " class="text-light"> <button type="button" rel="tooltip"
                                                                                                                   class="btn btn-success btn-round btn-just-icon btn-sm" data-original-title=""
                                                                                                                   title="edit"> <i
                                        class="fa fa-edit"></i>             </button></a>


                                <a  data-href="/employees?action=delete&id=${employee.getIdEmployee()}"
                                    data-record-title="${employee.getNameEmployee()}"
                                    data-toggle="modal" data-target="#confirm-delete" class="text-light ">
                                    <button type="button" rel="tooltip"
                                            class="btn btn-danger btn-round btn-just-icon btn-sm" data-original-title=""
                                            title="delete"><i class="fas fa-trash"></i></button>
                                </a>

                            </td>
                        </tr>
                    </c:forEach>
                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

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
