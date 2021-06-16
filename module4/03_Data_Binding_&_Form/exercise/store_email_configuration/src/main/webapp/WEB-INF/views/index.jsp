<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Greeting</title>
    <link rel="stylesheet" href="../../../resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row mt-5 justify-content-center ">
        <h2>
            Settings
        </h2>
    </div>
    <div class="row">
        <div class="col-6 mx-auto">


            <form:form method="POST" action="configSetting" modelAttribute="setting">
                <div class="form-group row">
                    <form:label path="language" cssClass="col-sm-2 col-form-label">Language</form:label>
                    <div class="col-sm-10">
                        <form:select cssClass="form-control" path="language">

                            <form:option value="English">English</form:option>
                            <form:option value="Vietnamese">Vietnamese</form:option>
                            <form:option value="Japanese">Japanese</form:option>
                            <form:option value="Chinese">Chinese</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group row">
                    <form:label path="pageSite" cssClass="col-sm-2 col-form-label">Page Site</form:label>
                    <div class="col-sm-10">
                        <span>Show</span>
                        <form:select cssClass="form-check-inline" path="pageSite">
                            <form:option value="5">5</form:option>
                            <form:option value="10">10</form:option>
                            <form:option value="15">15</form:option>
                            <form:option value="25">25</form:option>
                            <form:option value="100">100</form:option>
                        </form:select>
                        <span>email per page</span>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2"> Spams filter</div>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <form:checkbox path="spamFiler" value="${true}" cssClass="form-check-input"/>
                            <form:label path="spamFiler" cssClass=" d-flex col-form-label">
                                Enable spams filter
                            </form:label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">Signature</div>
                    <div class="col-sm-10">
                        <form:input path="signature" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group row justify-content-between align-content-between">
                    <div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>

                    <div>
                        <div>
                            <a href="/">
                                <button type="button" class="btn btn-primary ">Cancel</button>
                            </a>
                        </div>
                    </div>


                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
