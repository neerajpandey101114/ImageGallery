<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.Image"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	padding-bottom: 70px;
}

.jumbotron {
	color: #2c3e50;
}

.card-img-top {
	width: 100%;
	height: 15vw;
	object-fit: cover;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty username}">
			<%@ include file="header.jsp"%>
			<br />
		</c:when>
		<c:otherwise>
			<%@ include file="userHeader.jsp"%>
			<br />
		</c:otherwise>
	</c:choose>
	<div class="container p-3 mb-2">

		<div class="jumbotron">
			<h1>
				<i class="fa fa-camera-retro"></i> The Image Gallery
			</h1>
			<p>A bunch of beautiful images that I didn't take (except for the
				first one!)</p>
			<p>
				<a class="btn btn-primary btn-large" href="gallery/addImage.jsp">
					Add Image to the Gallery</a>
			</p>

		</div>
		<div class="card-deck pop">
			<c:forEach var="asd" items="${gallery}" begin="0" end="2">
				<div class="card">
					<img class="card-img-top"
						src="data:image/;base64,${asd.getBase64image()}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title text-center">${asd.getTitle()}</h5>
						<p class="card-text text-center">${asd.getCaption()}</p>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="card-deck mt-4">
			<c:forEach var="asd" items="${gallery}" begin="3" end="5">
				<div class="card">
					<img class="card-img-top"
						src="data:image/;base64,${asd.getBase64image()}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title text-center">${asd.getTitle()}</h5>
						<p class="card-text text-center">${asd.getCaption()}</p>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="card-deck mt-4">
			<c:forEach var="asd" items="${gallery}" begin="6" end="8">
				<div class="card">
					<img class="card-img-top"
						src="data:image/;base64,${asd.getBase64image()}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title text-center">${asd.getTitle()}</h5>
						<p class="card-text text-center">${asd.getCaption()}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="modal fade" id="imagemodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<img src="" class="imagepreview" style="width: 100%;">
				</div>
			</div>
		</div>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${currentPage != 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage - 1}">Previous</a></li>
			</c:if>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li class="page-item active"><a class="page-link" href="#">
								${i}<span class="sr-only">(current)</span>
						</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${currentPage lt noOfPages}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage + 1}">Next</a></li>
			</c:if>
		</ul>
	</nav>
	<%@ include file="footer.jsp"%>
	<script>
		$(function() {
			$('.pop').on(
					'click',
					function() {
						$('.imagepreview').attr('src',
								$(this).find('img').attr('src'));
						$('#imagemodal').modal('show');
					});
		});
	</script>
</body>
</html>