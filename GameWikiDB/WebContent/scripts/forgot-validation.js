function formValidation(){
	var password = document.forgotForm.newpassword;
	
	var pat = /^[0-9a-zA-Z]+$/;
	if ( validateLength(password,6,13) && password.value.match(pat)){
		return true;
	} else {
		alert("Password must have alphanumeric with length 6 -12.");
		return false;
	}
}

function validateLength(str, mx, my){

	var len = str.value.length;
	if (len == 0 || len > my || len < mx){
		return false;
	}
	return true;
}