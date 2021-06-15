<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Greeting</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5 ">
    <form method="post" id="formCalculation">
        <div class="row">
            <h2> Calculator</h2>
        </div>
        <div class="row">

            <div class="col-6">
                <input type="text" class="form-control" placeholder="First Number" aria-label="First Number"
                       aria-describedby="basic-addon2" name="firstNum">
            </div>
            <div class="col-6">
                <input type="text" class="form-control" placeholder="First Number" aria-label="Second Number"
                       aria-describedby="basic-addon2" name="secondNum">
            </div>
            <div></div>
            <input type="text" hidden name="calculation" id="calculation" value="">
        </div>


    </form>
    <div class="my-3">
        <button type="submit"  onclick="calculation('add')" class="btn btn-primary">Addition</button>
        <button type="button" onclick="calculation('sub')" class="btn btn-secondary">Subtraction</button>
        <button type="button" onclick="calculation('mul')" class="btn btn-success">Multiplication</button>
        <button type="button" onclick="calculation('div')" class="btn btn-danger">Division</button>
    </div>
    <div class="col-12 mt-2 ">
        <h2>Result :<strong>${result}</strong></h2>
    </div>
</div>


</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    function calculation(calculation) {
            document.getElementById("calculation").value=calculation;
            document.getElementById("formCalculation").submit();
    }
</script>

</html>
