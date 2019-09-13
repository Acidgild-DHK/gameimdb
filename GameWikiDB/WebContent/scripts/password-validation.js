function formValidation(){
	var curPass = document.passUpdateForm.currpassword;
	var newPass = document.passUpdateForm.newpassword;
	
	if (validateCurr(curPass) > 0 && validatePass(newPass)){
		return true;
	}
	else return false;
}

function validateLength(str, mx, my){

	var len = str.value.length;
	if (len == 0 || len > my || len < mx){
		return false;
	}
	return true;
}

function validateCurr(currPass){
	if(currPass.value.length == 0){
		alert("Password is required.");
		return false;
	}
	return true;
}
function validatePass(newPass){
	var pat = /^[0-9a-zA-Z]+$/;
	if ( validateLength(newPass,6,13) && newPass.value.match(pat)){
		return true;
	} else {
		alert("Password must have alphanumeric with length 6 -12.");
		return false;
	}
}