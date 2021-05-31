<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31-May-21
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
    <script src="../../bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <script src="../../bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/all.css">
    <script src="../../jquery/header.js"></script>
    <script src="../../jquery/create.js"></script>
    <link rel="stylesheet" href="../../css/create.css">
</head>
<body>
<header-component></header-component>
<div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <div class="card">
                <h5 class="text-center mb-4">Create Customer</h5>
                <form class="form-card">
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label
                                class="form-control-label px-3">Name<span class="text-danger"> *</span></label> <input
                                type="text" id="name" name="name"
                                placeholder="Enter your name"
                                onblur="validate(1)"></div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label
                                class="form-control-label px-3">Date<span class="text-danger"> *</span></label> <input
                                type="date" id="date" name="birthDay" value="2011-08-19"
                                onblur="validate(2)">

                        </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Email<span class="text-danger"> *</span></label> <input type="text" id="email" name="email"
                                                                                                                                                                           placeholder="" onblur="validate(3)">
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Phone
                            number<span class="text-danger"> *</span></label> <input type="text" id="phone" name="phone"
                                                                                     placeholder=""
                                                                                     onblur="validate(4)"></div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Id Card
                            <span class="text-danger"> *</span></label> <input type="text" id="idCard" name="idCard"
                                                                               placeholder="" onblur="validate(5)">
                        </div>
                        <div class=" form-group col-sm-6 flex-column d-flex ">
                            <label> Gender :</label>
                            <div class="form-check px-4 ">
                                <label class="form-check-label">

                                    <input type="radio" class="form-check-input" name="gender" id="male"
                                           value="male"
                                           checked>Male
                                </label>
                            </div>
                            <div class="form-check px-4 ">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="gender" id="female"
                                           value="female">
                                    Female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">CMND<span class="text-danger"> *</span></label> <input type="text" id="soCMND" name="soCMND"
                                                                                                                                                                          placeholder="" onblur="validate(3)">
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Type Of Customer
                            <span class="text-danger"> *</span></label> <input type="text" id="typeOfCustomer" name="typeOfCustomer"
                                                                               placeholder=""
                                                                               onblur="validate(6)"></div>
                    </div>
                    <div class="row justify-content-end">
                        <div class="form-group col-sm-6">
                            <button type="submit" class="btn-block btn-primary">Create</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
