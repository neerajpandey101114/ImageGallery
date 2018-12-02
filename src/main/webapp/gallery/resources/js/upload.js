function validations() {
	var username = document.forms["uploadForm"]["username"];
	var title = document.forms["uploadForm"]["title"];
	var caption = document.forms["uploadForm"]["caption"];
	var image = document.forms["uploadForm"]["image"];
	var span1 = document.getElementById("spanUsername");
	var span2 = document.getElementById("spanTitle");
	var span3 = document.getElementById("spanCaption");
	var span4 = document.getElementById("spanImage");

	if (username.value == "") {
		span1.innerHTML = "Please enter a username";
		span2.innerHTML = "";
		span3.innerHTML = "";
		span4.innerHTML = "";
		username.focus();
		return false;
	}

	else if (title.value == "") {
		span2.innerHTML = "Please enter a title";
		span1.innerHTML = "";
		span3.innerHTML = "";
		span4.innerHTML = "";
		title.focus();
		return false;
	}

	else if (caption.value == "") {
		span3.innerHTML = "Please enter a caption";
		span1.innerHTML = "";
		span2.innerHTML = "";
		span4.innerHTML = "";
		description.focus();
		return false;
	}

	else if (image.value == "") {
		span4.innerHTML = "Please select a image";
		span1.innerHTML = "";
		span2.innerHTML = "";
		span3.innerHTML = "";
		image.focus();
		return false;
	}
	

	document.getElementById("form").submit();
	return true;
}