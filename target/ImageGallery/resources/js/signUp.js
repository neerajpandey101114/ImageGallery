function validations()                                    
{ 
    var username = document.forms["signUpForm"]["username"];               
    var password = document.forms["signUpForm"]["password"];  
    var confirmPassword = document.forms["signUpForm"]["confirmPassword"];  
    var span1 = document.getElementById("spanUsername");
    var span2 = document.getElementById("spanPassword");
    var span3 = document.getElementById("spanConfirmPassword");
    
    if (username.value == "")                                  
    { 	
    	span1.innerHTML = "Please enter a username";
    	span2.innerHTML = "";
    	span3.innerHTML = "";
    	username.focus(); 
        return false; 
    } 

    else if (password.value == "")                        
    { 
    	span2.innerHTML = "Please enter a password";
    	span1.innerHTML = "";
    	span3.innerHTML = "";
    	password.focus(); 
        return false; 
    }
    
    else if (confirmPassword.value == "")                        
    { 
    	span3.innerHTML = "Please enter a password";
    	span1.innerHTML = "";
    	span2.innerHTML = "";
        confirmPassword.focus(); 
        return false; 
    }
    
    else if (confirmPassword.value !== password.value)                        
    { 
    	span3.innerHTML = "Passwords do not match"; 
    	span1.innerHTML = "";
    	span2.innerHTML = "";
        confirmPassword.focus(); 
        password.focus();
        return false; 
    }
    
    document.getElementById("form").submit();
    return true; 
}