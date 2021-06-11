<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../jquery/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/all.css">
</head>
<body>
<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-lg-4 col-sm-4 col-md-4 col-5"><a href="#" class="brand-wrap" data-abc="true">
                    <span class="logo">Exam</span> </a></div>
                <div class="col-lg-4 col-xl-4 col-sm-8 col-md-4 col-7 ml-auto">
                    <div class="d-flex justify-content-end">
                        <c:if test="${sessionScope.acc!=null}">
                            <a target="_blank" href="/login?action=logout" data-abc="true"
                               class="nav-link widget-header  text-light"> <i
                                    class="fas fa fa-whatsapp"></i> ${sessionScope.acc.username}</a>

                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                            <a class="nav-link nav-user-img" href="/login?action=login" data-abc="true"><span
                                    class="login">LOGIN</span></a>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <nav class="navbar navbar-expand-md navbar-main border-bottom shadow ">
        <div class="container-fluid ">
            <form class="d-md-none mt-2 ">
                <div class="input-group"><input type="search" name="search" class="form-control" placeholder="Search"
                                                required="">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </form>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#dropdown6"
                    aria-expanded="false"><span class="navbar-toggler-icon"></span></button>
            <div class="navbar-collapse collapse" id="dropdown6" style="">
                <ul class="navbar-nav mx-auto ">
                    <li class="nav-item px-4"><a class="nav-link" href="/home" data-abc="true">Home </a></li>
                    <li class="nav-item px-4"><a class="nav-link" href="/products" data-abc="true">Products</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
<script src="../../jquery/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../jquery/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableList').dataTable({"dom": 'lrtip', "lengthChange": false, "pageLength": 5});
        $('#confirm-delete').on('show.bs.modal', function (e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            var data = $(e.relatedTarget).data();
            $('.debug-url').text(data.recordTitle);

        })
    });
    setTimeout(function () {
        $('.alert').fadeOut('slow');
    }, 3000);

</script>
</body>
</html>
