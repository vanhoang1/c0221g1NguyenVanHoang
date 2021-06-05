<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-May-21
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <script src="bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="bootstrap-4.6.0-dist/css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/all.css">

</head>
<body>

<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-lg-3 col-sm-4 col-md-4 col-5"><a href="#" class="brand-wrap" data-abc="true">

                    <span class="logo">FURAMA</span> </a></div>
                <div class="col-lg-4 col-xl-5 col-sm-8 col-md-4 d-none pt-3 d-md-block">
                    <form action="#" class="search-wrap">
                        <div class="input-group w-100"><input type="text" class="form-control search-form"
                                                              style="width:55%;" placeholder="Search">
                            <div class="input-group-append">
                                <button class="btn btn-primary search-button" type="submit"><i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-5 col-xl-4 col-sm-8 col-md-4 col-7">
                    <div class="d-flex justify-content-end"><a target="_blank" href="#" data-abc="true"
                                                               class="nav-link widget-header"> <i
                            class="fas fa fa-whatsapp"></i></a> <span class="vl"></span>
                        <div class="dropdown btn-group"><a class="nav-link nav-icons" href="#"
                                                           id="navbarDropdownMenuLink1" data-toggle="dropdown"
                                                           aria-haspopup="true" aria-expanded="false" data-abc="true"><i
                                class="fas fa fa-bell"></i></a>
                            <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                                <li>
                                    <div class="notification-title">More Info</div>
                                    <div class="notification-list">
                                        <div class="list-group"><a href="affiliates"
                                                                   class="list-group-item list-group-item-action active"
                                                                   data-abc="true">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img
                                                        src="https://img.icons8.com/nolan/100/000000/helping-hand.png"
                                                        alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span
                                                        class="notification-list-user-name">Affiliate program</span>
                                                </div>
                                            </div>
                                        </a> <a href="redemption-center"
                                                class="list-group-item list-group-item-action active" data-abc="true">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img
                                                        src="https://img.icons8.com/bubbles/100/000000/prize.png" alt=""
                                                        class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span
                                                        class="notification-list-user-name">Redemption Center</span>
                                                </div>
                                            </div>
                                        </a> <a href="#" class="list-group-item list-group-item-action active"
                                                data-abc="true">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img
                                                        src="https://img.icons8.com/ultraviolet/100/000000/medal.png"
                                                        alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span
                                                        class="notification-list-user-name">Achievements</span></div>
                                            </div>
                                        </a> <a href="#" class="list-group-item list-group-item-action active"
                                                data-abc="true">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img
                                                        src="https://img.icons8.com/bubbles/100/000000/call-female.png"
                                                        alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span
                                                        class="notification-list-user-name">Contact us</span></div>
                                            </div>
                                        </a></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <span class="vl"></span> <a class="nav-link nav-user-img" href="#" data-toggle="modal"
                                                    data-target="#login-modal" data-abc="true"><span
                                class="login">LOGIN</span></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <nav class="navbar navbar-expand-md navbar-main border-bottom shadow ">
        <div class="container-fluid ">
            <form class="d-md-none my-2">
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
                    <li class="nav-item px-4"><a class="nav-link" href="/employees" data-abc="true">Employee</a></li>
                    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
                                                     data-abc="true" aria-expanded="false">Customer</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/customers" data-abc="true">List Customer</a>
                        <a class="dropdown-item" href="/summary" data-abc="true">Customers are using the service </a>
                    </div>
                    </li>
                    <li class="nav-item px-4"><a class="nav-link" href="/services" data-abc="true">Service</a></li>
                    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
                                                     data-abc="true" aria-expanded="false">Contract</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/contracts" data-abc="true">List Contract</a>
                            <a class="dropdown-item" href="/contract-detail" data-abc="true">Contract Detail</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">
    <div class="carousel slide" id="main-carousel" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#main-carousel" data-slide-to="0" class="active"></li>
            <li data-target="#main-carousel" data-slide-to="1"></li>
            <li data-target="#main-carousel" data-slide-to="2"></li>
            <li data-target="#main-carousel" data-slide-to="3"></li>
        </ol><!-- /.carousel-indicators -->

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src="https://s19.postimg.cc/qzj5uncgj/slide1.jpg" alt="">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Mountain</h1>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="https://s19.postimg.cc/lmubh3h0j/slide2.jpg" alt="">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Mountain</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci esse vitae exercitationem
                        fugit, numquam minus!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="https://s19.postimg.cc/99hh9lr5v/slide3.jpg" alt="">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Mountain</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci esse vitae exercitationem
                        fugit, numquam minus!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://s19.postimg.cc/nenabzsnn/slide4.jpg" alt="" class="d-block img-fluid">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Mountain</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci esse vitae exercitationem
                        fugit, numquam minus!</p>
                </div>
            </div>
        </div><!-- /.carousel-inner -->

        <a href="#main-carousel" class="carousel-control-prev" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
            <span class="sr-only" aria-hidden="true">Prev</span>
        </a>
        <a href="#main-carousel" class="carousel-control-next" data-slide="next">
            <span class="carousel-control-next-icon"></span>
            <span class="sr-only" aria-hidden="true">Next</span>
        </a>
    </div><!-- /.carousel -->
</div><!-- /.container -->
<script src="jquery/header.js"></script>
</body>
</html>
