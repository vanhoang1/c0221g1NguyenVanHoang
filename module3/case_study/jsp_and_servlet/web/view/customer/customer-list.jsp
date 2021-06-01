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
                <button type="button" class="btn btn-outline-secondary"><i class="fa fa-plus-circle"></i> Thêm mới
                </button>
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
                        <a href="/customers" class="text-decoration-none d-flex">
                            <button class="btn btn-outline-success ">Back to customer list</button>
                        </a>
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

                        <th>SoCMND</th>
                        <th>SDT</th>
                        <th>Address</th>
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
                            <td>${customer.getSoCMND()}</td>
                            <td>${customer.getSoDT()}</td>
                            <td>${customer.getAddress()}</td>
                            <td>${customer.getEmail()}</td>
                            <td>${customer.getTypeOfCustomer()}</td>


                                <%--                        thao tac--%>
                            <td class="td-actions text-right">

                                    <a href="/customers?action=view&id=${customer.getId()}" class="text-light"> <button type="button" rel="tooltip" class="btn btn-info btn-round btn-just-icon btn-sm"
                                                                                                                        data-original-title="" title="info"> <i
                                            class="fa fa-user"></i> </button> </a>


                                    <a href="/customers?action=edit&id=${customer.getId()} " class="text-light"> <button type="button" rel="tooltip"
                                                                                                                         class="btn btn-success btn-round btn-just-icon btn-sm" data-original-title=""
                                                                                                                         title="edit"> <i
                                            class="fa fa-edit"></i>             </button></a>


                                <a  data-href="/customers?action=delete&id=${customer.getId()}"
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
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                                </div>

                                <div class="modal-body">
                                    <p>You are about to delete one track, this procedure is irreversible.</p>
                                    <p>Do you want to proceed?</p>
                                    <p class="debug-url"></p>
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
<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>
<script>
    $('#confirm-delete').on('show.bs.modal', function (e) {
        let currow= $(this).closest('tr');
        $('.debug-url').html('Delete URL: <strong>' + col1+ '</strong>');
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
</script>

</html>
