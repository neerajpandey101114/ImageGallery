<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>File Upload to Database Demo</h1>
	<form method="post" action="UploadToDB" enctype="multipart/form-data">
		Author: <input type="text" name="author" size="50"/><br>
		Description: <input type="text" name="description" size="50"/><br>
		Portrait Photo:<input type="file" name="image" size="50"/> 
		<input type="submit" value="Save">
	</form>
	<!-- <h1>Retrieve a image from the database</h1>
	<form action="DownloadServlet" method="get">
	ID: <input type="text" name="id"/>
	<input type="submit" value="Retrieve">
	</form> -->
</body>
</html>