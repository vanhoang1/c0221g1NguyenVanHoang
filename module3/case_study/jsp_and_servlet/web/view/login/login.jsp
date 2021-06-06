<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06-Jun-21
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../jquery/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../../css/all.css">
    <link rel="stylesheet" href="../../css/util.css">
    <link rel="stylesheet" href="../../css/main.css">

    <script src="../../jquery/header.js"></script>
</head>
<body>
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
<div class="bg-contact3" style="background-image: url('../../img/download.jpg');">
    <div class="container-contact3">
        <div class="wrap-contact3">
            <form class="contact3-form validate-form" method="post">
					<span class="contact3-form-title">
						Login
					</span>

                <div class="wrap-input3 validate-input" data-validate="Name is required">
                    <input class="input3" type="text" value="${username}" name="username" placeholder="Your Name">
                    <span class="focus-input3"></span>
                </div>

                <div class="wrap-input3 validate-input" data-validate = "Pass is required">
                    <input class="input3" type="password" value="${password}" name="password" placeholder="Your Password">
                    <span class="focus-input3"></span>
                </div>


                <div class="wrap-contact3-form-radio">
                    <div class="contact3-form-radio m-r-42">
                        <input class="input-radio3" id="radio1" type="radio" name="remember" value="1">
                        <label class="label-radio3" for="radio1">
                            Remember me
                        </label>
                    </div>
                </div>

                <div class="container-contact3-form-btn">
                    <button class="contact3-form-btn">
                        Submit
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
<script src="../../jquery/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../jquery/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../jquery/login.js"></script>
<script>
    $(document).ready(function () {
        $('#tableList').dataTable({"dom" :'lrtip',"lengthChange":false,"pageLength":5})
    });
    setTimeout(function() {
        $('.alert').fadeOut('fast');
    }, 1000);
    $('#confirm-delete').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
        var data = $(e.relatedTarget).data();
        $('.debug-url').text(data.recordTitle);

    });
</script>
</html>
