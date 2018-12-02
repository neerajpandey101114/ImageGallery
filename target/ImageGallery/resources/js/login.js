function validations()                                    
{ 
    var username = document.forms["loginForm"]["username"];               
    var password = document.forms["loginForm"]["password"];  
    var span1 = document.getElementById("spanUsername");
    var span2 = document.getElementById("spanPassword");
    
    if (username.value == "")                                  
    { 	
    	span1.innerHTML = "Please enter a username";
    	username.focus(); 
        return false; 
    } 

    else if (password.value == "")                        
    { 
    	span2.innerHTML = "Please enter a password";
    	span1.innerHTML = "";
        password.focus(); 
        return false; 
    }

    document.getElementById("form").submit();
    return true; 
}