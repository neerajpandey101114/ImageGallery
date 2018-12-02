<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="resources/css/login.css" type="text/css">
</head>
<body>
<%@ include file="resources/views/header.jsp" %>
<form name ="signUpForm" class="form-signin" method="post" action="register" id="form">
  <h1 class="h3 mb-3 font-weight-normal text-center">Sign Up</h1>
  <label for="inputUsername" class="sr-only">username</label>
  <input type="text" id="inputUsername" name="username" class="form-control" placeholder="username" autofocus>
  <span id="spanUsername"></span>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password">
  <span id="spanPassword"></span>
  <label for="inputPassword" class="sr-only">Confirm Password</label>
  <input type="password" id="inputPassword" name="confirmPassword" class="form-control" placeholder="ConfirmPassword">
  <span id="spanConfirmPassword"></span>
  <b>${ error_message_login }</b>
  <button id="button" class="btn btn-lg btn-primary btn-block" type="button" onclick="return validations()">Sign Up</button>
</form>
<%@ include file="resources/views/footer.jsp" %>
<script type="text/javascript" src="resources/js/signUp.js"></script>
</body>
</html>