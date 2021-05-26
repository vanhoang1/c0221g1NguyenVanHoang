<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26-May-21
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<%
  ArrayList<Customer> list = new ArrayList<>();
  list.add(new Customer("nguyễn văn hoàng", "1/1/1", "đà nẵng", "img/1.jpg"));
  list.add(new Customer("nguyễn văn hoàng", "1/1/1", "đà nẵng", "img/1.jpg"));
  list.add(new Customer("nguyễn văn hoàng", "1/1/1", "đà nẵng", "img/1.jpg"));
%>
<table class="table">
  <thead>
  <tr>
    <th scope="col">Tên</th>
    <th scope="col">Ngày Sinh</th>
    <th scope="col">Địa Chỉ</th>
    <th scope="col">Ảnh</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="<%=list%>" var="listCustomer">
    <tr>
      <td>${listCustomer.name}</td>
      <td>${listCustomer.birthday}</td>
      <td>${listCustomer.address}</td>
      <td><img src="${listCustomer.img}" alt="" width="100"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
