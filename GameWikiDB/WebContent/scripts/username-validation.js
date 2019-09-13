function formValidation(){
	var username = document.usernameForm.username;
	
	if (username.value.length == 0){
		alert("Username is required");
		return false;
	}
}