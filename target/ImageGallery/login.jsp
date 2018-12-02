<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="resources/css/login.css" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<form name ="loginForm" class="form-signin" action="login" method="post" id="form">
  <h1 class="h3 mb-3 font-weight-normal text-center">Sign In</h1>
  <input type="text" name="username" class="form-control" placeholder="username" autofocus>
  <span id="spanUsername"></span>
  <input type="password" name="password" class="form-control" placeholder="Password">
  <span id="spanPassword"></span>
  <span id="error">${ error_message_login }</span>
  <button id="button" class="btn btn-lg btn-primary btn-block" type="button" onclick="return validations()">Sign in</button>
</form>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="resources/js/login.js"></script>
</body>
</html>