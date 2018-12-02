<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<link rel="stylesheet" href="resources/css/login.css" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form name="uploadForm" class="form-signin" method="post"
		action="UploadToDB" id="form" enctype="multipart/form-data">
		<h1 class="h3 mb-3 font-weight-normal text-center">Fill the
			details</h1>
		<label for="username" class="sr-only">Username</label> <input
			type="text" name="username" class="form-control"
			placeholder="Username" autofocus> <span id="spanUsername"></span>
		<label for="title" class="sr-only">Title</label> <input
			type="text" name="title" class="form-control"
			placeholder="Title" autofocus> <span id="spanTitle"></span>
		<label for="caption" class="sr-only">Caption</label> <input
			type="text" name="caption" class="form-control"
			placeholder="Caption"> <span id="spanCaption"></span>
		<div class="custom-file">
			<input type="file" class="custom-file-input" id="image" name="image">
			<label class="custom-file-label" for="customFile">Choose file</label>
		</div>
		<button id="button" class="btn btn-lg btn-primary btn-block"
			type="button" onclick="return validations()">Upload</button>
	</form>
	<%@ include file="footer.jsp"%>
	<script>
		$('#image').on('change', function() {
			//get the file name
			var fileName = $(this).val().replace("C:\\fakepath\\", "");
			//replace the "Choose a file" label
			$(this).next('.custom-file-label').html(fileName);
		})
	</script>
	<script type="text/javascript" src="resources/js/upload.js"></script>
</body>
</html>